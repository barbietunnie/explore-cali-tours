package com.xuxperience.exploretours;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xuxperience.exploretours.business.service.TourPackageService;
import com.xuxperience.exploretours.business.service.TourService;
import com.xuxperience.exploretours.data.Difficulty;
import com.xuxperience.exploretours.data.Region;
import com.xuxperience.exploretours.entity.Tour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ExploreToursApplication implements CommandLineRunner {
	@Autowired
	private TourService tourService;
	@Autowired
	private TourPackageService tourPackageService;

	public static void main(String[] args) {
		SpringApplication.run(ExploreToursApplication.class, args);
	}

	/**
	 * Method invoked after this class has been instantiated by Spring container
	 * initializes the in-memory database with all the TourPackages and Tours
	 * @param strings
	 * @throws Exception
	 */
	@Override
	public void run(String... strings) throws Exception {
		// Create the default tour packages
		tourPackageService.createTourPackage("BC", "Backpack Cal");
		tourPackageService.createTourPackage("CC", "California Calm");
		tourPackageService.createTourPackage("CH", "California Hot springs");
		tourPackageService.createTourPackage("CY", "Cycle California");
		tourPackageService.createTourPackage("DS", "From Desert to Sea");
		tourPackageService.createTourPackage("KC", "Kids California");
		tourPackageService.createTourPackage("NW", "Nature Watch");
		tourPackageService.createTourPackage("SC", "Snowboard Cali");
		tourPackageService.createTourPackage("TC", "Taste of California");

		long num = tourPackageService.getNumberOfTourPackages();
		System.out.println("Number of tour packages: " + num);

		// Persist the tours to the database
		ToursFromFile.importTours().forEach(t -> tourService.createTour(
				t.title,
				t.description,
				t.blurb,
				Integer.parseInt(t.price),
				t.length,
				t.bullets,
				t.keywords,
				t.packageType,
				Difficulty.valueOf(t.difficulty),
				Region.findByLabel(t.region)
				));
		System.out.println("Numbers of tours after import: " + tourService.getNumberOfTours());
	}

	/**
	 * Helper class to import the records in the ExploreCalifornia.json file
	 */
	static class ToursFromFile {
		//attributes as listed in the .json file
		private String packageType, title, description, blurb, price, length, bullets, keywords,  difficulty, region;

		static List<ToursFromFile> importTours() throws Exception {
			return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
									.readValue(ToursFromFile.class.getResourceAsStream("/ExploreCalifornia.json"),
												new TypeReference<List<ToursFromFile>>(){});
		}
	}
}
