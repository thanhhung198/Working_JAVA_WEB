package com.laptrinhjavaweb.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.paging.PageRequest;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;

public class BuildingController {
	public static void main(String[] args) {
		/*
		 * IBuildingService buildingService = new BuildingService(); try {
		 * buildingService.test(); } catch (Exception e) { System.out.print(e); }
		 */
		int page = 2;
		int limit  = 2;
		//int offset = (page - 1) * limit;
		String name = "building";
		String district = "";
		Integer buildingArea = null;
		Integer numberOfBasement = null;
		IBuildingService buildingService = new BuildingService();
		BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder().setName(name).setDistrict(district)
														.setNumberOfBasement(numberOfBasement).setBuildingArea(buildingArea)
														.build();
		
		Pageable pageable = new PageRequest(page, limit);
		List<BuildingDTO> buildings = buildingService.findAll(buildingSearchBuilder, pageable);
		for(BuildingDTO item: buildings) {
			System.out.println("ID: " +item.getId()+"- Name: "+ item.getName() + "- Adress: "+item.getStreet()+ "- BuildingArea: " +item.getBuildingArea());
		}
	}
}
