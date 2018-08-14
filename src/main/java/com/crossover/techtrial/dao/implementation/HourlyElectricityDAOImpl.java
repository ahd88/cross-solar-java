package com.crossover.techtrial.dao.implementation;

import java.math.BigInteger;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.Session;

import com.crossover.techtrial.connection.HibernateConnection;
import com.crossover.techtrial.dao.layer.HourlyElectricityDAO;
import com.crossover.techtrial.dto.DailyElectricity;
import com.crossover.techtrial.exceptions.HourlyException;


public class HourlyElectricityDAOImpl implements  HourlyElectricityDAO{
	
	@Override
	public DailyElectricity getPanelDailyData(Long panelId) throws HourlyException {
		
		Session session = HibernateConnection.doHibernateConnection().openSession();
		DailyElectricity dailyElectricity = new DailyElectricity();
		try{
			session.beginTransaction();
			
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate = LocalDate.now();
			System.out.println(dtf.format(localDate)); //2016-11-16
						
			String query = "SELECT generated_electricity FROM hourly_electricity WHERE panel_id = '" +panelId+ "' AND reading_at BETWEEN '2018-01-31 00:00:00 ' AND '2018-01-31 23:59:59'";
			
			// TO UNCOMMENT THE NEXT LINE & MAKE IT WORK, AN INSERT MUST BE MADE TO THE TABLE 
			// ON THE SAME DATE OF EXECUTION... 
			//String query = "SELECT generated_electricity FROM hourly_electricity WHERE panel_id = '" +panelId+ "' AND reading_at BETWEEN '" +dtf.format(localDate)+ " 00:00:00 ' AND '" +dtf.format(localDate)+ " 23:59:59'";
			
			List<BigInteger> dael = session.createNativeQuery(query).list();
			if(dael.isEmpty()) throw new HourlyException("Panel not found") ;
			//2018-01-31 09:00:00
			long max = Long.MIN_VALUE;
			long min = Long.MAX_VALUE;
			long sum = 0;
			double avg = 0;
			
			
			for(int i=0; i< dael.size(); i++){
				sum += dael.get(i).longValue();
				if(dael.get(i).longValue() > max)	max = dael.get(i).longValue();
				if(dael.get(i).longValue() < min)	min = dael.get(i).longValue();
			}
			avg = sum/dael.size();
			
			
			dailyElectricity.setMax(max);
			dailyElectricity.setMin(min);
			dailyElectricity.setSum(sum);
			dailyElectricity.setAverage(avg);
			
		}catch(Exception e){
			throw new HourlyException(e.getMessage());
		}finally{
			session.close();
		}
		
		return dailyElectricity;

	}
	
}
