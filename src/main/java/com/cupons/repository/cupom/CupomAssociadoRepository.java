package com.cupons.repository.cupom;

import com.cupons.models.cupom.CupomAssociado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CupomAssociadoRepository extends JpaRepository<CupomAssociado, Integer> {

    CupomAssociado findFirstByCupom_NumCupomAndDtaUsoCupomAssociadoIsNull(String numCupom);

    @Query("select max(ca.idCupomAssociado) from CupomAssociado ca")
    Integer buscarMaiorId();

    @Query("""
        select ca from CupomAssociado ca
        where ca.associado.cpfAssociado = :cpf
          and ca.dtaUsoCupomAssociado is null
          and CURRENT_DATE between ca.cupom.dtaInicioCupom and ca.cupom.dtaTerminoCupom
        order by ca.cupom.dtaInicioCupom desc
    """)
    List<CupomAssociado> buscarReservadosPorCpf(String cpf);

    @Query("""
        select ca from CupomAssociado ca
        where ca.associado.cpfAssociado = :cpf
          and ca.cupom.dtaTerminoCupom < CURRENT_DATE
        order by ca.cupom.dtaInicioCupom desc
    """)
    List<CupomAssociado> buscarVencidosPorCpf(String cpf);
}
