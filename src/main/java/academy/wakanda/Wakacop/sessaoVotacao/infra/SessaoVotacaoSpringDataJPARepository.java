package academy.wakanda.Wakacop.sessaoVotacao.infra;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import academy.wakanda.Wakacop.sessaoVotacao.domain.SessaoVotacao;

public interface SessaoVotacaoSpringDataJPARepository extends JpaRepository<SessaoVotacao, UUID> {
}