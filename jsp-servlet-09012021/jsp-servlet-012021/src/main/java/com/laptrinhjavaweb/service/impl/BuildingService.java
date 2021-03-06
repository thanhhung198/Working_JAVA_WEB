package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.BuildingDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;
import com.laptrinhjavaweb.repository.IBuildingRepository;
import com.laptrinhjavaweb.repository.impl.BuildingRepository;
import com.laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {
	// ktao contructor de new dtuong

	private IBuildingRepository buildingRepository;
	private BuildingConverter buildingConverter;

	public BuildingService() {
		buildingRepository = new BuildingRepository();
		buildingConverter = new BuildingConverter();
	}

	@Override
	public List<BuildingDTO> findAll(BuildingSearchBuilder fieldSearch, Pageable pageable) {
		
		
		// java 7
		/* List<BuildingDTO> results = new ArrayList<>();
		 * for(BuildingEntity item: buildingEntities) { BuildingDTO buildingDTO =
		 * buildingConverter.convertToDTO(item); results.add(buildingDTO); } return
		 * results;
		 */

		// java 8
		//Map<String, Object> maps = new HashMap<>();
		Map<String, Object> properties = new HashMap<>();
		properties.put("name", fieldSearch.getName());
		properties.put("district", fieldSearch.getDistrict());
		properties.put("buildingArea", fieldSearch.getBuildingArea());
		properties.put("numberOfBasement", fieldSearch.getNumberOfBasement());
		
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(properties, pageable);
		return buildingEntities.stream().map(item -> buildingConverter.convertToDTO(item)).collect(Collectors.toList());
	}

}
