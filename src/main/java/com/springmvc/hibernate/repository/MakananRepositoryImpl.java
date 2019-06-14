package com.springmvc.hibernate.repository;

import com.springmvc.hibernate.domain.Makanan;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MakananRepositoryImpl implements MakananRepository{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Makanan makanan) {
        sessionFactory.getCurrentSession().save(makanan);
    }

    @Override
    public void update(Makanan makanan){
        sessionFactory.getCurrentSession().save(makanan);
    }

    @Override
    public void delete(Makanan makanan) {
        sessionFactory.getCurrentSession().delete(makanan);
    }

    @Override
    public Makanan getMakanan(String idMakanan) {
        return sessionFactory.getCurrentSession().get(Makanan.class, idMakanan);
    }

    @Override
    public List<Makanan> getMakanans() {
        return sessionFactory.getCurrentSession().createCriteria(Makanan.class).list();
    }
}
