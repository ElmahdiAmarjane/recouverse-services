package com.recouvrex.process.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="collect_case")
public class Case extends BaseEntity {

    private String caseId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "status_id")
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="procedure_id")
    private Procedure procedure;

    private LocalDate startDate; //Date de début

    private BigDecimal principalAmount; //Le montant initial de la dette ou de l'obligation à récupérer, sans inclure les intérêts, les frais de retard ou d'autres frais supplémentaires.

    private BigDecimal interestAmount; //Le montant des intérêts à recupérer

    private BigDecimal penaltyAmount; //Montant des pénalités

    private BigDecimal  totalAmount; //Montant total à récupérer

    private BigDecimal commissionAmount; //Montant de la commission à payer à l'agent de recouvrement

    private BigDecimal insuranceSettlementAmout; //Le montant à récupérer auprès de l'assurance
}


