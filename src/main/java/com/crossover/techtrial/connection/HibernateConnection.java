package com.crossover.techtrial.connection;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.crossover.techtrial.dto.DailyElectricity;


public class HibernateConnection {
public static SessionFactory sessionFactory;
	
	public static SessionFactory doHibernateConnection(){
		Properties database = new Properties();
		database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		database.setProperty("hibernate.connection.username", "root");
		database.setProperty("hibernate.connection.password", "");
		// IF IT DIDN'T WORK, DELETE THE PASSWORD LINE ABOVE PLEASE & USE THE DOWN ONE
		//database.setProperty("hibernate.connection.password", "ahd88");
		database.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/crosssolar");
		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		database.setProperty("hibernate.show_sql", "true");
		
		Configuration cfg = new Configuration()
							.setProperties(database)
							.addPackage("com.crossover.techtrial.dto")
							.addAnnotatedClass(DailyElectricity.class);
		
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		
		sessionFactory = cfg.buildSessionFactory(ssrb.build());
		
		return sessionFactory;
		
	}
}
