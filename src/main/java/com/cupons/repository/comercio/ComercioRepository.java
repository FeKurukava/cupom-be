package com.cupons.repository.comercio;

import com.cupons.models.comercio.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ComercioRepository extends JpaRepository<Comercio, String> {
    Optional<Comercio> findByEmailComercio(String emailComercio);
}
