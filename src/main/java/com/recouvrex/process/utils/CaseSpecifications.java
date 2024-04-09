package com.recouvrex.process.utils;

import com.recouvrex.process.model.Case;
import com.recouvrex.process.model.Procedure;
import com.recouvrex.process.model.Status;
import com.recouvrex.process.model.User;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;

public class CaseSpecifications {

        public static Specification<Case> withCriteria(String caseId, Long statusId, Long procedureId, Long userId , String firstname , String lastname , String contractId , String thirdPartyId) {
            System.out.println(userId);
            return (Root<Case> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
                Predicate predicate = criteriaBuilder.conjunction();
                Predicate casesUserConnected = criteriaBuilder.conjunction();

                // Ajouter la condition pour filtrer par l'utilisateur connecté
                if (predicate != null) {
                    casesUserConnected = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("assignedAgent").get("id"),1));
                }
                // Ajoutez ici vos conditions de recherche en fonction des critères fournis
                if (!StringUtils.isBlank(caseId)) {
                    predicate = criteriaBuilder.and(casesUserConnected, criteriaBuilder.like(root.get("caseId"), "%" + caseId + "%"));
                }
                if (statusId != null) {
                    //Join<Case, Status> statusJoin = root.join("status");
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status_id"), statusId));
                }

                if (procedureId != null) {
                    //Join<Case, Procedure> procedureJoin = root.join("procedure");
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("id"), procedureId));
                }
                if (firstname != null) {
                    Join<Case, User> procedureJoin = root.join("procedure");
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(procedureJoin.get("id"), procedureId));
                }

                if (userId != null) {
                    // Jointure avec l'entité User pour le champ assignedAgent
                    //Join<Case, User> userJoin = root.join("assignedAgent");
                    // Création du prédicat pour filtrer par userId
                    Predicate userPredicate = criteriaBuilder.conjunction();
                    userPredicate = criteriaBuilder.and(userPredicate, criteriaBuilder.equal(root.get("assignedAgent").get("id"), userId));
                    // Jointure avec l'entité User pour le champ manager
                   // Join<Case, User> assignedJoin = root.join("assignedAgent");
                    Join<Case, User> managerJoin = root.join("assignedAgent");
                    // Ajout de la condition de recherche pour le manager
                    userPredicate = criteriaBuilder.or(userPredicate, criteriaBuilder.equal(managerJoin.get("manager").get("id"), userId));
                    // Ajout du prédicat userPredicate à la prédicat global
                    predicate = criteriaBuilder.and(predicate, userPredicate);
                }

                return predicate;
            };
            //REMARQUE A DISCUTER
            // SI un user cherche par exemple par id de procedure , le resultat sera les cases qui ont
            // id procedure saisie et aussi si un status ou un user a meme id sera afficher dans ca
            // va faire un petit proleme ,( mais si les id saisie sont des id fonctionnel dans ce cas c'est  )
            // tres defficil de tomber dans ce genre de probleme

            //F7ALAT KAN MANGER null MAKAY2AFICHICH CASES DYAL LUSER LI MANAGER DYALO NULL
        }

}
