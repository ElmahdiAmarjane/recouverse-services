package com.recouvrex.process.utils;

import com.recouvrex.process.model.*;
import com.recouvrex.process.repository.CaseRepository;
import com.recouvrex.process.repository.UserRepository;
import jakarta.persistence.criteria.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CaseSpecifications {




        //REMARQUE A DISCUTER
        // SI un user cherche par exemple par id de procedure , le resultat sera les cases qui ont
        // id procedure saisie et aussi si un status ou un user a meme id sera afficher dans ca
        // va faire un petit proleme ,( mais si les id saisie sont des id fonctionnel dans ce cas c'est  )
        // tres defficil de tomber dans ce genre de probleme

        //F7ALAT KAN MANGER null MAKAY2AFICHICH CASES DYAL LUSER LI MANAGER DYALO NULL


 public static Predicate casesForUsers(Long connectedUserId, Root<Case> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
     Predicate userPredicate = criteriaBuilder.conjunction();

     userPredicate = criteriaBuilder.and(userPredicate, criteriaBuilder.equal(root.get("assignedAgent").get("id"), connectedUserId));

     Join<Case, User> managerJoin = root.join("assignedAgent");
     userPredicate = criteriaBuilder.or(userPredicate, criteriaBuilder.equal(managerJoin.get("manager").get("id"), connectedUserId));

     return userPredicate;
 }

    public static Specification<Case> withCriteria(Long userConnectedId, Long userId, String caseId, Long statusId, Long procedureId, String firstname, String lastname, String contractId, String thirdPartyId) {
        return (Root<Case> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = casesForUsers(userConnectedId, root, query, criteriaBuilder);

            // Add your additional search conditions based on the provided criteria
            if (!StringUtils.isBlank(caseId)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("caseId"), "%" + caseId + "%"));
            }
            if (statusId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("status").get("id"), statusId));
            }
            if (procedureId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("procedure").get("id"), procedureId));
            }
            if (firstname != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("thirdParty").get("firstName"), "%" + firstname + "%"));
            }
            if (lastname != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("thirdParty").get("lastName"), "%" + lastname + "%"));
            }
            if (contractId != null) {
                // Subquery to select the thirdpartyId based on the contractId
                Subquery<Long> thirdPartyIdSubquery = query.subquery(Long.class);
                Root<Contract> contractRoot = thirdPartyIdSubquery.from(Contract.class);
                thirdPartyIdSubquery.select(contractRoot.get("thirdParty").get("id"));
                thirdPartyIdSubquery.where(criteriaBuilder.equal(contractRoot.get("contractId"), contractId));

                // Main query to select cases where thirdpartyId matches the subquery result
                predicate = criteriaBuilder.and(predicate, root.get("thirdParty").get("id").in(thirdPartyIdSubquery));
            }


            if (thirdPartyId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("thirdParty").get("thirdPartyId"), "%" + thirdPartyId + "%"));
            }
            if (userId != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("assignedAgent").get("id"), userId));
            }


            return predicate;
        };
    }
    /*public static Specification<Case> withCriteriaOneString(Long userConnectedId, String searchText) {
        return (Root<Case> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = casesForUsers(userConnectedId, root, query, criteriaBuilder);

            // Add your additional search conditions based on the provided criteria
            if (!StringUtils.isBlank(searchText)) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("caseId"), "%" + searchText + "%"));
            }
            if (searchText != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("status").get("status"), searchText));
            }
            if (searchText != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("procedure").get("procedureLabel"), searchText));
            }
            if (searchText != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("thirdParty").get("firstName"), "%" + searchText + "%"));
            }
            if (searchText != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.like(root.get("thirdParty").get("lastName"), "%" + searchText + "%"));
            }
         *//*   if (contractId != null) {
                // Subquery to select the thirdpartyId based on the contractId
                Subquery<Long> thirdPartyIdSubquery = query.subquery(Long.class);
                Root<Contract> contractRoot = thirdPartyIdSubquery.from(Contract.class);
                thirdPartyIdSubquery.select(contractRoot.get("thirdParty").get("id"));
                thirdPartyIdSubquery.where(criteriaBuilder.equal(contractRoot.get("contractId"), contractId));

                // Main query to select cases where thirdpartyId matches the subquery result
                predicate = criteriaBuilder.or(predicate, root.get("thirdParty").get("id").in(thirdPartyIdSubquery));
            }


            if (thirdPartyId != null) {
                predicate = criteriaBuilder.or(predicate, criteriaBuilder.like(root.get("thirdParty").get("thirdPartyId"), "%" + thirdPartyId + "%"));
            }
            if (userId != null) {
                predicate = criteriaBuilder.or(predicate, criteriaBuilder.equal(root.get("assignedAgent").get("id"), userId));
            }
*//*

            return predicate;
        };
    }*/
    /*public static Specification<Case> withCriteriaOneString(Long userConnectedId, String searchText) {
        return (Root<Case> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = casesForUsers(userConnectedId, root, query, criteriaBuilder);
            List<Predicate> searchPredicates = new ArrayList<>();

            // Add your additional search conditions based on the provided criteria
            if (!StringUtils.isBlank(searchText)) {
                searchPredicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("caseId")), "%" + searchText.toLowerCase() + "%"));
                searchPredicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("status").get("status")), searchText.toLowerCase()));
                searchPredicates.add(criteriaBuilder.equal(criteriaBuilder.lower(root.get("procedure").get("procedureLabel")), searchText.toLowerCase()));
                searchPredicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("thirdParty").get("firstName")), "%" + searchText.toLowerCase() + "%"));
                searchPredicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("thirdParty").get("lastName")), "%" + searchText.toLowerCase() + "%"));
            }

            // Add comparisons for contractId, thirdPartyId, and userId
            if (searchText != null) {
                Subquery<Long> thirdPartyIdSubquery = query.subquery(Long.class);
                Root<Contract> contractRoot = thirdPartyIdSubquery.from(Contract.class);
                thirdPartyIdSubquery.select(contractRoot.get("thirdParty").get("id"));
                thirdPartyIdSubquery.where(criteriaBuilder.equal(contractRoot.get("contractId"), searchText));
                Predicate contractPredicate = criteriaBuilder.in(root.get("thirdParty").get("id")).value(thirdPartyIdSubquery);
                predicate = criteriaBuilder.or(predicate, contractPredicate);
            }
            if (searchText != null) {
                Expression<String> thirdPartyIdExpression = root.get("thirdParty").get("thirdPartyId").as(String.class);
                searchPredicates.add(criteriaBuilder.equal(thirdPartyIdExpression, searchText));
            }
            if (searchText != null) {
                Expression<String> userIdExpression = root.get("assignedAgent").get("id").as(String.class);
                searchPredicates.add(criteriaBuilder.equal(userIdExpression, searchText));
            }

            // Combine individual predicates with OR
            if (!searchPredicates.isEmpty()) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.or(searchPredicates.toArray(new Predicate[0])));
            }

            return predicate;
        };
    }
*/

    public static Specification<Case> withCriteriaOneString(Long userConnectedId, String searchText) {
        return (Root<Case> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) -> {
            Predicate predicate = casesForUsers(userConnectedId, root, query, criteriaBuilder);

            // Add your additional search conditions based on the provided searchText
            if (!StringUtils.isBlank(searchText)) {
                // Parse searchText to check if it's a Long or String
                try {
                    Long value = Long.parseLong(searchText);
                    // If successful, it's a Long
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.or(
                           // criteriaBuilder.equal(root.get("status").get("id"), value),
                            criteriaBuilder.equal(root.get("procedure").get("id"), value),
                            criteriaBuilder.equal(root.get("assignedAgent").get("id"), value)
                    ));
                } catch (NumberFormatException e) {
                    // If parsing fails, it's a String
                    String searchTextLower = searchText.toLowerCase(); // Convert search text to lowercase
                    predicate = criteriaBuilder.and(predicate, criteriaBuilder.or(
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("caseId")), "%" + searchTextLower + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("thirdParty").get("firstName")), "%" + searchTextLower + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("status").get("status")), "%" + searchTextLower + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("thirdParty").get("lastName")), "%" + searchTextLower + "%"),
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("thirdParty").get("thirdPartyId")), "%" + searchTextLower + "%"),
                            // Handle contractId using subquery
                            getContractIdPredicate(searchTextLower, root, query, criteriaBuilder)
                    ));
                }

            }

            return predicate;
        };
    }

    private static Predicate getContractIdPredicate(String contractId, Root<Case> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        // Subquery to select the thirdpartyId based on the contractId
        Subquery<Long> thirdPartyIdSubquery = query.subquery(Long.class);
        Root<Contract> contractRoot = thirdPartyIdSubquery.from(Contract.class);
        thirdPartyIdSubquery.select(contractRoot.get("thirdParty").get("id"));
        thirdPartyIdSubquery.where(criteriaBuilder.equal(contractRoot.get("contractId"), contractId));

        // Main query to select cases where thirdpartyId matches the subquery result
        return root.get("thirdParty").get("id").in(thirdPartyIdSubquery);
    }


}

