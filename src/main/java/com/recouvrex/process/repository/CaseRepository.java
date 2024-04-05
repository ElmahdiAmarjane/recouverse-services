package com.recouvrex.process.repository;

import com.recouvrex.process.model.Case;
import com.recouvrex.process.model.User;
import com.recouvrex.process.model.enums.StatusEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaseRepository extends JpaRepository <Case, Long> {

	List<Case> findByCaseId(String caseId);

	@Query("SELECT c from Case c WHERE c.status = :status")
	List<Case> findByStatus(@Param("status") StatusEnum status);

	@Query(value = "SELECT * FROM collect_case c WHERE LOWER(c.case_id) LIKE LOWER(CONCAT('%', :caseId,'%')) AND (c.status_id) = :statusId AND (c.procedure_id) = :procedureId", nativeQuery = true)
	List<Case> findByCaseIdContainingAndStatusAndProcedure(String caseId, Long statusId, Long procedureId);

//	@Query("SELECT c from Case c WHERE c.user.userId = :userId")
//	List<Case> findByUserId(@Param("userId") String userId);
@Query(value = "SELECT * FROM collect_case c WHERE c.user_id = :userId", nativeQuery = true)
List<Case> findByUserId(@Param("userId") Long userId);

}
