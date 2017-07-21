package com.xuxperience.exploretours.business.service;

import com.xuxperience.exploretours.entity.TourPackage;
import com.xuxperience.exploretours.repository.TourPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TourPackageService {
    private TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    /**
     * Create a new TourPackage
     *
     * @param code
     * @param name
     * @return
     */
    public TourPackage createTourPackage(String code, String name) {
        if(tourPackageRepository.findOne(code) == null) {
            return tourPackageRepository.save(
                    new TourPackage(code, name));
        } else {
            return null;
        }
    }

    /**
     * Get the total number of tour packages
     *
     * @return
     */
    public long getNumberOfTourPackages() {
        return tourPackageRepository.count();
    }

    /**
     * Get the list of all TourPackages
     *
     * @return
     */
    public Iterable<TourPackage> getAllTourPackages() {
        return tourPackageRepository.findAll();
    }
}
