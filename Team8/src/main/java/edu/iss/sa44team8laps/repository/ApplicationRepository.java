package edu.iss.sa44team8laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.sa44team8laps.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

	@Query("SELECT u FROM Application u WHERE u.UserId = :uname")
	ArrayList<Application> findAppByUserId(@Param("uname") Integer uname);
}
