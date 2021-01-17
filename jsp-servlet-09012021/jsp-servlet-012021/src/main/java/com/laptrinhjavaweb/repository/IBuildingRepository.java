package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.paging.Pageable;

public interface IBuildingRepository extends JpaRepository<BuildingEntity> {
	//List<BuildingDTO> findAll();
	//List<BuildingEntity> findAll(Map<String, Object> params, Pageable pageable); //xly phan trang
}
