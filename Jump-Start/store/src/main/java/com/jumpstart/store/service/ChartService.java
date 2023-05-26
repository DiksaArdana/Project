package com.jumpstart.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jumpstart.store.entity.Chart;
import com.jumpstart.store.repository.ChartRepository;

@Service
public class ChartService {
	@Autowired
	private ChartRepository chartRepo;
	
	public Chart SaveChart(Chart dta) {
	
		return chartRepo.save(dta);
	}
	public Chart editStatusChart(long id) {
		Chart dta = getChartId(id);
		dta.setStatus("disable");
		return chartRepo.save(dta);
	}
	public Chart getChartId(Long id) {
		return chartRepo.findById(id).get();
	}
	public List<Chart> listChartByStatus(long uid) {
		List<Chart> list = chartRepo.findByEnableChart(uid);
		return list;
	}
	public List<Chart> listAllChart() {
		List<Chart> list = chartRepo.findAll();
		return list;
	}

}
