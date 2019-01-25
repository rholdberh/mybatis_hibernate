package com.mybatis.mappers;

import com.mybatis.Subscriber;

import java.util.List;

public interface SubscriberMapper {

    Subscriber getSubscriberById(Integer id);

    List getSubscribers();

    Integer getNumberOfSubscribers();

}
