package com.crossover.techtrial.dao.registry;

import com.crossover.techtrial.dao.implementation.HourlyElectricityDAOImpl;
import com.crossover.techtrial.dao.layer.HourlyElectricityDAO;

public class RegistryDAO {
	public static HourlyElectricityDAO hourlyElectricityDAO = new HourlyElectricityDAOImpl();
	
	

	public static HourlyElectricityDAO getHourlyElectricityDAO() {
		return hourlyElectricityDAO;
	}

	public static void setHourlyElectricityDAO(HourlyElectricityDAO hourlyElectricityDAO) {
		RegistryDAO.hourlyElectricityDAO = hourlyElectricityDAO;
	}
	
}
