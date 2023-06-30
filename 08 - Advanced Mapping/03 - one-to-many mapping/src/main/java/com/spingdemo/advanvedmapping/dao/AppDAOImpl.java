package com.spingdemo.advanvedmapping.dao;

import com.spingdemo.advanvedmapping.entity.Course;
import com.spingdemo.advanvedmapping.entity.Insructor;
import com.spingdemo.advanvedmapping.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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
        List<Course> courses = tempInsructor.getCourses();
        for (Course tempCourse : courses){
            tempCourse.setInstructor(null);
        }
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

    @Override
    public List<Course> findCourseByInstructorId(int theID) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theID);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Insructor findInstructorByIdJoinFetch(int theID) {
        TypedQuery<Insructor> query = entityManager.createQuery(
                "select i from Insructor i " + "JOIN FETCH i.courses " + "where i.id = :data", Insructor.class);
        query.setParameter("data", theID);
        Insructor instructor = query.getSingleResult();
        return instructor;

    }

    @Override
    @Transactional
    public void updateInstructor(Insructor insructor) {
        entityManager.merge(insructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseByID(int theID) {
        return entityManager.find(Course.class, theID);
    }

    @Override
    @Transactional
    public void deleteCoursebyID(int theID) {
        Course tempCourse = entityManager.find(Course.class, theID);
        entityManager.remove(tempCourse);
    }

}
