package com.mybatis.mappers;

import com.mybatis.Subscriber;

import java.util.List;

public interface SubscriberMapper {

    public Subscriber getSubscriberById(Integer id);

    public List getSubscribers();

}
