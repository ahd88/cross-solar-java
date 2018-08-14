package com.crossover.techtrial.dao.layer;

import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.exceptions.HourlyException;

public interface HourlyElectricityDAO {
	DailyElectricity getPanelDailyData(Long panelId)throws HourlyException;
}
