package com.voyager.kylin;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class KylinDruidQuery {
    public static void main(String[] args) throws IOException {
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis_config.xml");
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);

        SqlSession sqlSession = build.openSession();
        DeviceMapper mapper = sqlSession.getMapper(DeviceMapper.class);
        mapper.deviceSending(new DeviceQueryModel("2021-12-20"));
        for(int i =0 ; i< 10; i++) {
            new Thread(()-> {
                mapper.deviceSending(new DeviceQueryModel("2021-12-20"));
            }).start();
            System.out.println(i);
        }

//        List<DeviceResultModel> deviceResultModels1 = mapper.deviceSending(new DeviceQueryModel("2021-12-20"));
//        List<DeviceResultModel> deviceResultModels2 = mapper.deviceSending(new DeviceQueryModel("2021-12-20"));
//        for (DeviceResultModel deviceResultModel : deviceResultModels) {
//            System.out.println(deviceResultModel);
//        }

    }
}
