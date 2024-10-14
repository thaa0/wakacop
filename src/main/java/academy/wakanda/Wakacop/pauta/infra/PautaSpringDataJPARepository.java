package academy.wakanda.Wakacop.pauta.infra;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import academy.wakanda.Wakacop.pauta.domain.Pauta;

public interface PautaSpringDataJPARepository extends JpaRepository<Pauta, UUID> {

}