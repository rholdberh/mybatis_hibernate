package com.mybatis.mappers;

import dbObjects.Payment;

import java.util.List;

public interface PaymentMapper {
    List<Payment> getPaymentsByIdSub(Integer id);
}