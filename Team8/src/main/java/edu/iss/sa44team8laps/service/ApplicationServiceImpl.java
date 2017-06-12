package edu.iss.sa44team8laps.service;

import java.util.ArrayList;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.iss.sa44team8laps.model.Application;
import edu.iss.sa44team8laps.model.Employee;
import edu.iss.sa44team8laps.model.User;
import edu.iss.sa44team8laps.repository.ApplicationRepository;
import edu.iss.sa44team8laps.repository.EmployeeRepository;
import edu.iss.sa44team8laps.repository.UserRepository;
@Service
public class ApplicationServiceImpl implements ApplicationService {

	@Resource
	private ApplicationRepository appRepository;
	@Resource
	private UserRepository userRepository;
	@Resource
	private EmployeeRepository empRepository;
	@Override
	@Transactional
	public ArrayList<Application> findAllApplications() {
		// TODO Auto-generated method stub
		ArrayList<Application> all=(ArrayList<Application>)appRepository.findAll();
		return all;
	}

	@Override
	@Transactional
	public ArrayList<Application> findAppById(Integer id) {
		// TODO Auto-generated method stub
		ArrayList<Application> app=appRepository.findAppByUserId(id);
		return app;
	}

	@Override
	@Transactional
	public ArrayList<Application> findAppByUserId(Integer uid) {
		// TODO Auto-generated method stub
		
		ArrayList<Application> app=appRepository.findAppByUserId(uid);
		
		return app;
	}

	@Override
	@Transactional
	public ArrayList<Application> findAppByUserName(String name) {
		// TODO Auto-generated method stub
		User user=userRepository.findUserByName(name);
		ArrayList<Application> app=appRepository.findAppByUserId(user.getUserId());
		return app;
	}

	@Override
	@Transactional
	public ArrayList<Application> findAppByManager(Integer mid) {
		// TODO Auto-generated method stub
		ArrayList<Employee> elist=empRepository.findEmpByManagerId(mid);
		ArrayList<Application>alist=new ArrayList<Application>();
		for(int i=0;i<elist.size();i++){
			int eid= elist.get(i).getEmployeeId();
			ArrayList<Application> apps=appRepository.findAppByUserId(eid);
			alist.addAll(apps);
		}
		return alist;
	}

	@Override
	@Transactional
	public Application editApp(Application app) {
		// TODO Auto-generated method stub
		return appRepository.saveAndFlush(app);
	}

	@Override
	@Transactional
	public Application createApp(Application app) {
		// TODO Auto-generated method stub
		return appRepository.saveAndFlush(app);
	}

	@Override
	@Transactional
	public void deleteApp(Application app) {
		// TODO Auto-generated method stub
		appRepository.delete(app);
	}


	@Transactional
	public ArrayList<Application> listHistoryByUserIdBeforeTime(Integer uid, Date date) {
		// TODO Auto-generated method stub
		ArrayList<Application> alist= appRepository.findAppByUserId(uid);
		ArrayList<Application> atlist= new ArrayList<Application>();
		for(int i=0;i<alist.size();i++){
			if(alist.get(i).getLeaveDate().after(date)){
				atlist.add(alist.get(i));
			}
		}
		return atlist;
	}

}
