package com.crossover.techtrial.dto;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;


public class DailyElectricityTest {
	private static DailyElectricity dailyElectricity;
	
	@BeforeClass
	public static void init() {
		dailyElectricity = new DailyElectricity();
	}
	
	@Test
	public void testGetDate() {
		LocalDate date = LocalDate.MIN;
		dailyElectricity.setDate(date);
		assertEquals(dailyElectricity.getDate(), date);
	}
	
	@Test
	public void testGetMax() {
		Long max = new Random().nextLong();
		dailyElectricity.setMax(max);
		assertEquals(dailyElectricity.getMax(), max);
	}
	
	@Test
	public void testGetMin() {
		Long min = new Random().nextLong();
		dailyElectricity.setMin(min);
		assertEquals(dailyElectricity.getMin(), min);
	}
	
	@Test
	public void testGetSum() {
		Long sum = new Random().nextLong();
		dailyElectricity.setSum(sum);
		assertEquals(dailyElectricity.getSum(), sum);
	}
	
	@Test
	public void testGetAvg() {
		Double avg = new Random().nextDouble();
		dailyElectricity.setAverage(avg);
		assertEquals(dailyElectricity.getAverage(), avg);
	}
}
