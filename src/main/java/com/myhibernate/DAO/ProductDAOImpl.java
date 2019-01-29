package com.myhibernate.DAO;

import com.myhibernate.HibernateUtil;
import com.myhibernate.Entity.ProductEntity;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImpl implements ProductDAO {

    @Override
    public List<ProductEntity> getProducts() {

        List products = new ArrayList();
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery cr = cb.createQuery(Object.class); //will return an object
            Root<ProductEntity> root = cr.from(ProductEntity.class); //setting root class element
            cr.select(root); //setting element type
            products = session.createQuery(cr).list();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public ProductEntity getProductBytId(long id) {
        ProductEntity productEntity = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            productEntity = session.load(ProductEntity.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return productEntity;
    }

    @Override
    public void addProduct(ProductEntity product) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            session.beginTransaction();

            CriteriaQuery cr = cb.createQuery(Object.class);
            Root<ProductEntity> root = cr.from(ProductEntity.class);
            cr.select(cb.max(root.get("id")));
            Object max = session.createQuery(cr).getSingleResult();
            product.setId((long) max + 1);
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
