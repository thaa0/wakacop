package academy.wakanda.Wakacop.sessaoVotacao.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.Wakacop.sessaoVotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.Wakacop.sessaoVotacao.application.api.SessaoAberturaResponse;
import academy.wakanda.Wakacop.sessaoVotacao.application.repository.SessaoVotacaoRepository;
import academy.wakanda.Wakacop.sessaoVotacao.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaoVotacaoService {

	private final SessaoVotacaoRepository sessaoVotacaoRepository;

	@Override
	public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
		log.info("[Start] SessaoVotacaoApplicationService  - abreSessao");
		SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest));
		log.info("[Finish] SessaoVotacaoApplicationService  - abreSessao");
		return new SessaoAberturaResponse(sessaoVotacao);
	}
}