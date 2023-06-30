package com.spingdemo.advanvedmapping.dao;

import com.spingdemo.advanvedmapping.entity.Insructor;
import com.spingdemo.advanvedmapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDAOImpl implements AppDAO{

    public EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager theEntityManager){
        this.entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Insructor insructor) {
        entityManager.persist(insructor);
    }

    @Override
    public Insructor findInstructorByID(int theId) {
        return entityManager.find(Insructor.class, theId);
    }

    @Transactional
    public void deletInstructor(int theId) {
        Insructor tempInsructor = entityManager.find(Insructor.class, theId);
        entityManager.remove(tempInsructor);
    }

    @Override
    public InstructorDetail findInstructorDetailsByID(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int theID) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theID);
        entityManager.remove(tempInstructorDetail);
    }

}
