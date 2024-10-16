package academy.wakanda.Wakacop.sessaoVotacao.infra;

import java.util.UUID;

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

	@Override
	public SessaoVotacao buscaPorId(UUID idSessao) {
		log.info("[Start] SessaoVotacaoInfraRepository  - buscaPorId");
		SessaoVotacao sessao = sessaoVotacaoSpringDataJPARepository.findById(idSessao)
						.orElseThrow(()-> new RuntimeException("Sessao nao encontrada"));
		log.info("[Finish] SessaoVotacaoInfraRepository  - buscaPorId");
		return sessao;
	}
}