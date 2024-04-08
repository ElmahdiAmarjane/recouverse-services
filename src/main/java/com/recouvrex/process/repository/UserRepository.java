package com.recouvrex.process.repository;

import com.recouvrex.process.model.Case;
import com.recouvrex.process.model.User;
import com.recouvrex.process.model.enums.StatusEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository <User, Long> {

	List<User> findAll();

	@Query(value = "SELECT * FROM user u WHERE  u.profile_id = :profileId", nativeQuery = true)
	List<User> findByProfile(Long profileId);

}
