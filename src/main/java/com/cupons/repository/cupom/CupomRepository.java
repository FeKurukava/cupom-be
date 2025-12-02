package com.cupons.repository.cupom;

import com.cupons.models.cupom.Cupom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface CupomRepository extends JpaRepository<Cupom, String> {

    @Query("""
        SELECT c FROM Cupom c
        WHERE c.comercio.cnpjComercio = :cnpj
          AND CURRENT_DATE BETWEEN c.dtaInicioCupom AND c.dtaTerminoCupom
    """)
    List<Cupom> findAtivosByCnpj(String cnpj);

    @Query("""
        SELECT c FROM Cupom c
        WHERE c.comercio.cnpjComercio = :cnpj
          AND c.dtaTerminoCupom < CURRENT_DATE
    """)
    List<Cupom> findVencidosByCnpj(String cnpj);
}
