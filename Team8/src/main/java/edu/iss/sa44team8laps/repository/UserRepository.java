package edu.iss.sa44team8laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.iss.sa44team8laps.model.User;


public interface UserRepository extends JpaRepository<User, String> {
	
	@Query("SELECT u FROM User u WHERE u.UserId=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") int uname, @Param("pwd") String pwd);
	
	@Query("SELECT u FROM User u WHERE u.UserId=:id")
	User findUserById(@Param("id") int id);
}
