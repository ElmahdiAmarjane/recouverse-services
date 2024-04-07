package com.recouvrex.process.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountCasesStatus implements Serializable {
   /* int nbrPreDouteux ;
    int nbrDouteux ;
    int nbrComiteImpayes;
    int nbrComiteDeclassementAgence;
    int nbrRadie ;
    int nbrPreContentieux ;
    int nbrContentieux;
    int nbrSaisieConservationImmobiliereInitiee ;
    int nbrTermine;*/

    String status;
    Long count;
}
