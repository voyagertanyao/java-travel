package com.voyager.kylin;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

public class KylinDruidDataSource implements DataSourceFactory {

    private DataSource dataSource;

    public void setProperties(Properties props) {
        try {
            this.dataSource = DruidDataSourceFactory.createDataSource(props);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public DataSource getDataSource() {
        return this.dataSource;
    }
}
