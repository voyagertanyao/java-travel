package com.voyager.kylin;

import org.apache.ibatis.builder.xml.XMLMapperBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeException;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.apache.kylin.jdbc.Driver;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Properties;

public class KylinQuery {

    public static void main(String[] args) throws Exception {
        Driver driver = (Driver)Class.forName("org.apache.kylin.jdbc.Driver").newInstance();

        Properties info = new Properties();
        info.put("user", "ADMIN");
        info.put("password", "KYLIN");
        Connection conn = driver.connect("jdbc:kylin://slave001:7000/QLYOM", info);
        PreparedStatement state;

        Configuration configuration = new Configuration();
        TypeHandlerRegistry typeHandlerRegistry = new TypeHandlerRegistry(configuration);
        String resource = "qlyom.xml";
        try (InputStream inputStream = Resources.getResourceAsStream(resource)) {
            XMLMapperBuilder builder = new XMLMapperBuilder(inputStream, configuration, resource, configuration.getSqlFragments());
            builder.parse();
            MappedStatement mappedStatement = configuration.getMappedStatement("com.voyager.kylin.Qlyom.deviceSending");
            Object parameterObject = new DeviceQueryModel("2021-10-15",null);
            BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);
            String sql = boundSql.getSql();
            state = conn.prepareStatement(sql);
            List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();

            for (int i = 0; i < parameterMappings.size(); i++) {
                ParameterMapping parameterMapping = parameterMappings.get(i);
                if (parameterMapping.getMode() != ParameterMode.OUT) {
                    Object value;
                    String propertyName = parameterMapping.getProperty();
                    if (boundSql.hasAdditionalParameter(propertyName)) { // issue #448 ask first for additional params
                        value = boundSql.getAdditionalParameter(propertyName);
                    } else if (parameterObject == null) {
                        value = null;
                    } else if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
                        value = parameterObject;
                    } else {
                        MetaObject metaObject = configuration.newMetaObject(parameterObject);
                        value = metaObject.getValue(propertyName);
                    }
                    TypeHandler typeHandler = parameterMapping.getTypeHandler();
                    JdbcType jdbcType = parameterMapping.getJdbcType();
                    if (value == null && jdbcType == null) {
                        jdbcType = configuration.getJdbcTypeForNull();
                    }
                    try {
                        typeHandler.setParameter(state, i + 1, value, jdbcType);
                    } catch (Exception e) {
                        throw new TypeException("Could not set parameters for mapping: " + parameterMapping + ". Cause: " + e, e);
                    }
                }
            }
        }

//        state.setInt(1, 10);
        ResultSet resultSet = state.executeQuery();
        while (resultSet.next()){
            String anInt = resultSet.getString(3);
            System.out.println(anInt);
        }
    }
}
