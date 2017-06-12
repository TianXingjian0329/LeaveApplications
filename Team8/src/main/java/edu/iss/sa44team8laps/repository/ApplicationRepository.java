package edu.iss.sa44team8laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.sa44team8laps.model.Application;
import edu.iss.sa44team8laps.model.User;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	@Query("SELECT u FROM application u WHERE u.userid=:un")
	ArrayList<Application> findAppByUserId(@Param("un") Integer uname);
}
