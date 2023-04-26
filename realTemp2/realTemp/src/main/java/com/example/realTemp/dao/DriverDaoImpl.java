package com.example.realTemp.dao;

import com.example.realTemp.entity.Drivers;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DriverDaoImpl implements DriverDao {

    EntityManager entityManager;

    @Autowired
    void DriverDaoImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    public List<Drivers> findAllDriver() {
        TypedQuery<Drivers> t  = entityManager.createQuery("from Drivers", Drivers.class);
        return t.getResultList();
    }

//    @Override
//    public Drivers putDriver(Drivers driver) {
//        driver.setId(0);
//        return entityManager.merge(driver);
//    }

}
