package com.mybatis;

import com.mybatis.mappers.SubscriberMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        SqlSessionFactory sqlSessionFactory;
        try {
            Reader reader = Resources.getResourceAsReader("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            SubscriberMapper subscriberMapper = sqlSessionFactory.openSession().getMapper(SubscriberMapper.class);
            List subscribers =  subscriberMapper.getSubscribers();
            Subscriber subscriber = subscriberMapper.getSubscriberById(1);
            System.out.println(subscriber);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
