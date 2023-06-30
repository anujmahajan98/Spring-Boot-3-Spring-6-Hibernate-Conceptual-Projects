package com.spingdemo.advanvedmapping.dao;

import com.spingdemo.advanvedmapping.entity.Insructor;
import com.spingdemo.advanvedmapping.entity.InstructorDetail;

public interface AppDAO {

    void save(Insructor insructor);

    Insructor findInstructorByID(int theId);

    void deletInstructor(int theId);

    InstructorDetail findInstructorDetailsByID(int theId);

    void deleteInstructorDetail(int theID);

}
