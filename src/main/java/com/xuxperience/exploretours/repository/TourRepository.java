package com.xuxperience.exploretours.repository;

import com.xuxperience.exploretours.entity.Tour;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Tour Repository Interface
 */
@Repository
public interface TourRepository extends CrudRepository<Tour, Integer> {
    List<Tour> findByTourPackageCode(String code);
}
