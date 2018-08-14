package com.crossover.techtrial.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crossover.techtrial.dao.registry.RegistryDAO;
import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.exceptions.HourlyException;

/**
 * DailyElectricityController for all Rest APIs related to Daily Electricity.
 * @author Ahmed
 *
 */
@RestController
public class DailyElectricityController {
	
	@GetMapping("/getPanelHistory")
	public DailyElectricity getPanelHistory() throws HourlyException{
		
		long panelId = 1;		// must be given by front end guys 
		DailyElectricity dailyElectricity = RegistryDAO.getHourlyElectricityDAO().getPanelDailyData(panelId);
		System.out.println(dailyElectricity.getSum());
		return  dailyElectricity;
	}
}
