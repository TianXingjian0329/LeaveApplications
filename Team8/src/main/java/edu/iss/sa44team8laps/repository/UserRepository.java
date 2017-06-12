package edu.iss.sa44team8laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.sa44team8laps.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("SELECT u FROM User u WHERE u.userid=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") Integer uname, @Param("pwd") String pwd);
	
	@Query("SELECT u FROM User u WHERE u.name=:un")
	User findUserByName(@Param("un") String uname);
}
