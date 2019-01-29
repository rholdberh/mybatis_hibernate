package com.myhibernate;


import com.myhibernate.DAO.ProductDAO;
import com.myhibernate.DAO.ProductDAOImpl;
import com.myhibernate.Entity.ProductEntity;

import java.util.List;


public class Main {
    public static void main(String[] args) {


        ProductDAO productDAO = new ProductDAOImpl();
        List<ProductEntity> products = productDAO.getProducts();
        System.out.println(products.size());

        ProductEntity enti = new ProductEntity();
        enti.setName("bla");
        productDAO.addProduct(enti);

//        Factory instance = Factory.getInstance();
//
//        Collection products = instance.getProductDao().getProducts();
//        System.out.println(products.size());
//
//        ProductEntity entity = instance.getProductDao().getProductBytId(1);
//        System.out.println(entity);

    }
}
