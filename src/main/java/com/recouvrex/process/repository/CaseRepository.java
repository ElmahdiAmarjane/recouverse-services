package com.recouvrex.process.repository;

import com.recouvrex.process.model.Case;
import com.recouvrex.process.model.enums.StatusEnum;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CaseRepository extends JpaRepository <Case, Long>, JpaSpecificationExecutor<Case> {

	List<Case> findByCaseId(String caseId);

	@Query("SELECT c from Case c WHERE c.status = :status")
	List<Case> findByStatus(@Param("status") StatusEnum status);

	@Query(value = "SELECT * FROM collect_case c WHERE LOWER(c.case_id) LIKE LOWER(CONCAT('%', :caseId,'%')) AND (c.status_id) = :statusId AND (c.procedure_id) = :procedureId", nativeQuery = true)
	List<Case> findByCaseIdContainingAndStatusAndProcedure(String caseId, Long statusId, Long procedureId);
	
}
