package com.mybatis.mappers;

import com.dbObjects.Payment;

import java.util.List;

public interface PaymentMapper {
    List<Payment> getPaymentsByIdSub(Integer id);
}