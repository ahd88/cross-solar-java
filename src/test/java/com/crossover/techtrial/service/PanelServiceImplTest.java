package com.crossover.techtrial.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.crossover.techtrial.model.HourlyElectricity;
import com.crossover.techtrial.model.Panel;
import com.crossover.techtrial.repository.PanelRepository;

public class PanelServiceImplTest {
	@InjectMocks
	private PanelServiceImpl panelService;
	
	@Mock
	private PanelRepository panelRepository;
	
	@Before
	public void setup() throws Exception {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSave(){
		Panel panelMock = Mockito.mock(Panel.class);
		Mockito.when(panelRepository.save(panelMock)).thenReturn(panelMock);

	}
	
	@Test
	public void testFindBySerial(){
		Panel panelMock = Mockito.mock(Panel.class);
		Mockito.when(panelRepository.findBySerial(new String("test"))).thenReturn(panelMock);
	}
}
