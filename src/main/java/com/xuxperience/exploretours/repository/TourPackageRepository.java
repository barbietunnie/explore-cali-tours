package com.xuxperience.exploretours.repository;

import com.xuxperience.exploretours.entity.Tour;
import com.xuxperience.exploretours.entity.TourPackage;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Tour Package Repository Interface
 */
@Repository
public interface TourPackageRepository extends CrudRepository<TourPackage, String> {
    TourPackage findByName(@Param("name") String name);
}
