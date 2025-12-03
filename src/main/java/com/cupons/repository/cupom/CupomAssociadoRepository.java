package com.cupons.repository.cupom;

import com.cupons.models.cupom.CupomAssociado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CupomAssociadoRepository extends JpaRepository<CupomAssociado, Integer> {

    CupomAssociado findFirstByCupom_NumCupomAndDtaUsoCupomAssociadoIsNull(String numCupom);
}
