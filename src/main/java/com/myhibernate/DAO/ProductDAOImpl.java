package com.myhibernate.DAO;

import com.myhibernate.HibernateUtil;
import com.myhibernate.Entity.ProductEntity;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<ProductEntity> getProducts() {

        List products = new ArrayList();
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            products = session.createCriteria(ProductEntity.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public ProductEntity getProductBytId(long id) {
        ProductEntity productEntity = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            productEntity = session.load(ProductEntity.class, id);

        } catch (Exception e){
            e.printStackTrace();
        }
        return productEntity;
    }


}
