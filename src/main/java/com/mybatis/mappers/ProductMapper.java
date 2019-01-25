package com.mybatis.mappers;

import com.mybatis.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ProductMapper {

    @Select("select * from \"SCHEMA_TEST_ROMAN\".\"SUBSRIBER\" where id = #{id}")
    Product getProductById(Integer id);

    @Select("select max(id) from \"SCHEMA_TEST_ROMAN\".\"PRODUCT\"")
    Integer getLastID();

    @Select("select * from \"SCHEMA_TEST_ROMAN\".\"PRODUCT\"")
    @Results({
            @Result(property= "id", column="id"),
            @Result(property = "name", column = "name")
    })
    List<Product> getProducts();

    @Insert("INSERT INTO \"SCHEMA_TEST_ROMAN\".\"PRODUCT\"(ID,NAME) VALUES(#{id},#{name})")
    void insertProduct(Product prod);

}
