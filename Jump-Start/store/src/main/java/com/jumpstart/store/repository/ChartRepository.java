package com.jumpstart.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jumpstart.store.entity.Chart;

@Repository
public interface ChartRepository extends JpaRepository<Chart, Long> {

	@Query(value = "SELECT * FROM chart_tb WHERE status = 'enable' AND user_id = :uid ", nativeQuery = true)
	public List<Chart> findByEnableChart(@Param("uid") Long uid);

}
