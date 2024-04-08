package com.recouvrex.process.utils;

import com.recouvrex.process.model.Case;
import com.recouvrex.process.model.Procedure;
import com.recouvrex.process.model.Status;
import com.recouvrex.process.model.User;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class CaseSpecifications {

        public static Specification<Case> withCriteria(String caseId, Long statusId, Long procedureId, Long userId) {
            return (Root<Case> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
                Predicate predicate = criteriaBuilder.conjunction();

                // Ajoutez ici vos conditions de recherche en fonction des critères fournis
                if (!StringUtils.isBlank(caseId)) {
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("caseId"), "%" + caseId + "%"));
                }
                if (statusId != null) {
                    Join<Case, Status> statusJoin = root.join("status");
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(statusJoin.get("id"), statusId));
                }

                if (procedureId != null) {
                    Join<Case, Procedure> procedureJoin = root.join("procedure");
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(procedureJoin.get("id"), procedureId));
                }

                if (userId != null) {
                    Join<Case, User> userJoin = root.join("assignedAgent");
                    //predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(userJoin.get("id"), userId));
                    Predicate userPredicate = criteriaBuilder.conjunction();
                    userPredicate = criteriaBuilder.and(userPredicate, criteriaBuilder.equal(userJoin.get("id"), userId));
                    Join<Case, User> assignedJoin = root.join("assignedAgent");
                    Join<User, User> managerJoin = assignedJoin.join("manager");
                    userPredicate =criteriaBuilder.or(userPredicate, criteriaBuilder.equal(managerJoin.get("id"), userId));
                    predicate = criteriaBuilder.and(predicate, userPredicate);

                }

                return predicate;
            };
        }

}
