package com.mybatis.mappers;

import com.mybatis.dbObjects.Subscriber;

import java.util.List;

public interface SubscriberMapper {

    Subscriber getSubscriberById(Integer id);

    List getSubscribers();

    Integer getNumberOfSubscribers();

    void insertSubscriber(Subscriber sub);

}
