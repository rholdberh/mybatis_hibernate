package com.mybatis.mappers;

import com.mybatis.dbObjects.Tariff;

public interface TariffMapper {
    Tariff getTariffById(Integer id);
}