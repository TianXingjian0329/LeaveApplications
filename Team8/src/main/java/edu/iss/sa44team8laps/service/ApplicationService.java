package edu.iss.sa44team8laps.service;
import java.util.ArrayList;
import java.util.Date;

import edu.iss.sa44team8laps.model.*;
public interface ApplicationService {
	ArrayList<Application> findAllApplications();
	Application findAppById(Integer id);
	ArrayList<Application> findAppByUserId(Integer uid);
	ArrayList<Application> findAppByUserName(String name);
	ArrayList<Application> findAppByManager(Integer mid);
	Application editApp(Application app);
	Application createApp(Application app);
	void deleteApp(Application app);
	ArrayList<Application> listHistoryByUserIdBeforeTime(Integer uid, Date date);
}
