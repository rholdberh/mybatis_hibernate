package com.myhibernate;

import com.myhibernate.DAO.ProductDAO;
import com.myhibernate.DAO.ProductDAOImpl;

public class Factory {

    private static ProductDAO productDao = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public ProductDAO getProductDao() {
        if (productDao == null) {
            productDao = new ProductDAOImpl();
        }
        return productDao;
    }
}



