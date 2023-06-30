package com.spingdemo.advanvedmapping.dao;

import com.spingdemo.advanvedmapping.entity.Course;
import com.spingdemo.advanvedmapping.entity.Insructor;
import com.spingdemo.advanvedmapping.entity.InstructorDetail;

import java.util.List;

public interface AppDAO {

    void save(Insructor insructor);

    Insructor findInstructorByID(int theId);

    void deletInstructor(int theId);

    InstructorDetail findInstructorDetailsByID(int theId);

    void deleteInstructorDetail(int theID);

    List<Course> findCourseByInstructorId(int theID);

    Insructor findInstructorByIdJoinFetch(int theID);

    void updateInstructor(Insructor insructor);

    void updateCourse(Course course);

    Course findCourseByID(int theID);

    void deleteCoursebyID(int theID);

    void save(Course theCourse);

    Course findCourseAndReviewByID(int theID);

}
