package academy.wakanda.Wakacop.sessaoVotacao.infra;

import org.springframework.stereotype.Repository;

import academy.wakanda.Wakacop.sessaoVotacao.application.repository.SessaoVotacaoRepository;
import academy.wakanda.Wakacop.sessaoVotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoInfraRepository implements SessaoVotacaoRepository {

	private final SessaoVotacaoSpringDataJPARepository sessaoVotacaoSpringDataJPARepository;

	@Override
	public SessaoVotacao salva(SessaoVotacao sessaoVotacao) {
		log.info("[Start] SessaoVotacaoInfraRepository  - salva");
		sessaoVotacaoSpringDataJPARepository.save(sessaoVotacao);
		log.info("[Finish] SessaoVotacaoInfraRepository  - salva");
		return sessaoVotacao;
	}
}