package com.mybatis;

import com.mybatis.mappers.SubscriberMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
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
            SqlSession sqlSession = sqlSessionFactory.openSession();
            SubscriberMapper subscriberMapper = sqlSession.getMapper(SubscriberMapper.class);
            List subscribers =  subscriberMapper.getSubscribers();
            Subscriber subscriber = subscriberMapper.getSubscriberById(1);
            Integer numberOfSubscribers  = subscriberMapper.getNumberOfSubscribers();
            System.out.println("First subscriber" +subscriber);
            System.out.println("All subscribers" +subscribers);
            System.out.println("Number of subscribers: " + numberOfSubscribers);


            Subscriber sub = new Subscriber();
            sub.setId(Long.valueOf(5));
            sub.setName("roman3");
            sub.setRefTariff("value");
            subscriberMapper.insertSubscriber(sub);
            sqlSession.commit();
            Integer numberOfSubscribers2  = subscriberMapper.getNumberOfSubscribers();
            System.out.println("Number of subscribers: " + numberOfSubscribers2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
