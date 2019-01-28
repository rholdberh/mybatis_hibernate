package com.mybatis;

import com.mybatis.dbObjects.Product;
import com.mybatis.mappers.ProductMapper;
import com.mybatis.mappers.SubscriberMapper;
import com.mybatis.dbObjects.Subscriber;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        productLogic();
        subscriberLogic();

    }

    private static void subscriberLogic() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SubscriberMapper subscriberMapper = sqlSession.getMapper(SubscriberMapper.class);
        List subscribers = subscriberMapper.getSubscribers();
        Subscriber subscriber = subscriberMapper.getSubscriberById(1);
        Integer numberOfSubscribers = subscriberMapper.getNumberOfSubscribers();
        System.out.println("First subscriber" + subscriber);
        System.out.println("All subscribers" + subscribers);
        System.out.println("Number of subscribers: " + numberOfSubscribers);


        Subscriber sub = new Subscriber();
        sub.setId(Long.valueOf(5));
        sub.setName("roman3");
        sub.setRefTariff("value");
        subscriberMapper.insertSubscriber(sub);
        sqlSession.commit();
        Integer numberOfSubscribers2 = subscriberMapper.getNumberOfSubscribers();
        System.out.println("Number of subscribers: " + numberOfSubscribers2);
    }

    private static void productLogic() throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        ProductMapper productMapper = sqlSession.getMapper(ProductMapper.class);

        Integer lastId = productMapper.getLastID();

        Product prod = new Product();
        prod.setName("newProd");
        prod.setId(lastId + 1);

        productMapper.insertProduct(prod);
        sqlSession.commit();
        List products2 = productMapper.getProducts();
        System.out.println(products2);


        List products = productMapper.getProducts();
        Product product = productMapper.getProductById(1);
        System.out.println(products);
        System.out.println(product);
    }
}
