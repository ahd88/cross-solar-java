package com.crossover.techtrial.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import com.crossover.techtrial.dao.registry.RegistryDAO;
import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.exceptions.HourlyException;
import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.repository.HourlyElectricityRepository;


public class HourlyElectricityServiceImplTest {
	@InjectMocks
	private HourlyElectricityServiceImpl hourlyElectricityService;
	
	@Mock
	private HourlyElectricityRepository hourlyElectricityRepository;
	
	@Spy
	private SessionFactory hibernateSessionFactory;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testSave(){
		HourlyElectricity hourlyElectricityMock = Mockito.mock(HourlyElectricity.class);
		Mockito.when(hourlyElectricityRepository.save(hourlyElectricityMock)).thenReturn(hourlyElectricityMock);
		HourlyElectricity response = hourlyElectricityService.save(hourlyElectricityMock);
		assertEquals(response, hourlyElectricityMock);
	}
	
	@Test
	public void testGetAllHourlyElectricityByPanelId() {
		Pageable pageAble = Mockito.mock(Pageable.class);
		HourlyElectricity hourlyElectricityMock = Mockito.mock(HourlyElectricity.class);
		List<HourlyElectricity> hourlyElectricityList = new ArrayList<>();
		hourlyElectricityList.add(hourlyElectricityMock);
		Page<HourlyElectricity> hourlyElectricityPage = new PageImpl<HourlyElectricity>(hourlyElectricityList);
		Mockito.when(hourlyElectricityRepository.findAllByPanelIdOrderByReadingAtDesc(new Long(1), pageAble)).thenReturn(hourlyElectricityPage);
		Page<HourlyElectricity> response = hourlyElectricityService.getAllHourlyElectricityByPanelId(new Long(1), pageAble);
		assertEquals(response.getTotalPages(), 1);
		assertEquals(response.getContent(), hourlyElectricityList);
	}
	
	@Test
	public void testGetPanelDailyData() throws HourlyException{
		Long panelId = new Long(1);
		
		DailyElectricity daily = RegistryDAO.getHourlyElectricityDAO().getPanelDailyData(panelId);
		assertEquals(daily.getMax(), new Long(100));
	}
}
