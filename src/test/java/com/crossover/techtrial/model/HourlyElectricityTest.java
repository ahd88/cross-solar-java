package com.crossover.techtrial.model;

import static org.junit.Assert.assertEquals;

import java.time.LocalDateTime;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;



public class HourlyElectricityTest {
	private static HourlyElectricity hourlyElectricity;
	private static Panel panel;
	
	@BeforeClass
	public static void init(){
		hourlyElectricity = new HourlyElectricity();
		panel = new Panel();
	}
	
	@Test
	public void testGetId(){
		Long id = new Random().nextLong();
		hourlyElectricity.setId(id);
		assertEquals(hourlyElectricity.getId(), id);
	}
	
	@Test
	public void testGetPanel(){
		hourlyElectricity.setPanel(panel);
		assertEquals(hourlyElectricity.getPanel(), panel);
	}
	
	@Test
	public void testGetGeneratedElectricity(){
		Long generatedElectricity = new Random().nextLong();
		hourlyElectricity.setGeneratedElectricity(generatedElectricity);
		assertEquals(hourlyElectricity.getGeneratedElectricity(), generatedElectricity);
	}
	
	@Test
	public void testGetReadingAt(){
		LocalDateTime dateTime = LocalDateTime.now();
		hourlyElectricity.setReadingAt(dateTime);
		assertEquals(hourlyElectricity.getReadingAt(), dateTime);
	}
}
