package com.myhibernate.DAO;

import com.myhibernate.Entity.ProductEntity;

import java.util.List;

public interface ProductDAO {

    List<ProductEntity> getProducts();

    ProductEntity getProductBytId(long id);

}
