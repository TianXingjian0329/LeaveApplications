package edu.iss.sa44team8laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.sa44team8laps.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.UserName=:un AND u.UserPassword=:pwd")
	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);
	
	@Query("SELECT u FROM User u WHERE u.UserName=:un")
	User findUserByName(@Param("un") String uname);
	
	@Query("SELECT u FROM User u WHERE u.EmployeeId=:un")
	User findUserByEmpId(@Param("un") Integer uname);
	
}
