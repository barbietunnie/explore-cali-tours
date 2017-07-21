package com.xuxperience.exploretours.business.service;

import com.xuxperience.exploretours.data.Difficulty;
import com.xuxperience.exploretours.data.Region;
import com.xuxperience.exploretours.entity.Tour;
import com.xuxperience.exploretours.entity.TourPackage;
import com.xuxperience.exploretours.repository.TourPackageRepository;
import com.xuxperience.exploretours.repository.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Tour service
 */
@Service
public class TourService {
    private TourRepository tourRepository;
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(TourRepository tourRepository,
                       TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a new Tour and persist it to the database
     *
     * @param title
     * @param description
     * @param blurb
     * @param price
     * @param duration
     * @param bullets
     * @param keywords
     * @param tourPackageName
     * @param difficulty
     * @param region
     * @return
     */
    public Tour createTour(String title,
                           String description,
                           String blurb,
                           Integer price,
                           String duration,
                           String bullets,
                           String keywords,
                           String tourPackageName,
                           Difficulty difficulty,
                           Region region) {

        TourPackage tourPackage = tourPackageRepository.findByName(tourPackageName);
        if(tourPackage == null)
            throw new RuntimeException("Tour package '" + tourPackageName + "' does not exist");

        return tourRepository.save(
                new Tour(title, description, blurb, price, duration,
                        bullets, keywords, tourPackage, difficulty, region));
    }

    /**
     * Get the number of tours in the database
     *
     * @return the number of tours
     */
    public long getNumberOfTours() {
        return tourRepository.count();
    }
}
