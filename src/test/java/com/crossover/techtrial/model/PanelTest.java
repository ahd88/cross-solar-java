package com.crossover.techtrial.model;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;



public class PanelTest {
	private static Panel panel;
	
	@BeforeClass
	public static void init(){
		panel = new Panel();
	}
	
	@Test
	public void testGetId(){
		Long id = new Random().nextLong();
		panel.setId(id);
		assertEquals(panel.getId(), id);
	}
	
	@Test
	public void testGetSerial(){
		String serial = "test";
		panel.setSerial(serial);
		assertEquals(panel.getSerial(),serial);
	}
	
	@Test
    public void testGetLongitude() {
		Double longitude = new Random().nextDouble();
        panel.setLongitude(longitude);
        assertEquals(panel.getLongitude() , longitude);
    }
	
	@Test
    public void testGetLatitude() {
		Double latitude = new Random().nextDouble();
        panel.setLatitude(latitude);
        assertEquals(panel.getLatitude(), latitude);
    }
	
	@Test
    public void testGetBrand() {
		String brand = "tset";
        panel.setBrand(brand);
        assertEquals(panel.getBrand(), brand);
    }
}
