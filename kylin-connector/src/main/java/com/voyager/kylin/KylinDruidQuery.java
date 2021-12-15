package com.voyager.kylin;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class KylinDruidQuery {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();
        DeviceMapper mapper = sqlSession.getMapper(DeviceMapper.class);
        List<DeviceResultModel> deviceResultModels = mapper.deviceSending(new DeviceQueryModel("2021-11-30", "重庆市"));
        for (DeviceResultModel deviceResultModel : deviceResultModels) {
            System.out.println(deviceResultModel);
        }
        List<DeviceResultModel> deviceResultModelss = mapper.deviceSending(new DeviceQueryModel("2021-11-29", "四川省"));
        for (DeviceResultModel deviceResultModel : deviceResultModelss) {
            System.out.println(deviceResultModel);
        }
    }
}
