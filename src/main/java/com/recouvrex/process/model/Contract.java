package com.recouvrex.process.model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="contrat")
public class Contract extends BaseEntity{



    private String contractId;

    @ManyToOne
    @JoinColumn(name = "thirdparty_id")
    private ThirdParty thirdParty;

    private LocalDateTime createdOn;

}
