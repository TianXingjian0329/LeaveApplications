package edu.iss.sa44team8laps.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import edu.iss.sa44team8laps.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query("SELECT u FROM Role u WHERE u.role_name=:un")
	Role findRoleByRoleName(@Param("un") String eid);
}
