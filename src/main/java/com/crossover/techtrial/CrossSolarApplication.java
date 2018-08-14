package com.crossover.techtrial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.crossover.techtrial.dao.registry.RegistryDAO;
import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.exceptions.HourlyException;


@SpringBootApplication
public class CrossSolarApplication {

  public static void main(String[] args) throws HourlyException {
    SpringApplication.run(CrossSolarApplication.class, args);
    
    
    /*AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	context.scan("com.crossover.techtrial.dao.registry");
	context.refresh();
	
	DailyElectricity dl = RegistryDAO.getHourlyElectricityDAO().getPanelDailyData(new Long(1));
	System.out.println("The Maximum today's reading for Panel no.1 = "+ dl.getMax());
	System.out.println("The Minimum today's reading for Panel no.1 = "+ dl.getMin());
	System.out.println("The average of today's reading for Panel no.1 = "+ dl.getAverage());
	System.out.println("The sum of today's reading for Panel no.1 = "+ dl.getSum());
	
	context.close();*/
  }

}
