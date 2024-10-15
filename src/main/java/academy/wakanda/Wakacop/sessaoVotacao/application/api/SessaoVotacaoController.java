package academy.wakanda.Wakacop.sessaoVotacao.application.api;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.Wakacop.sessaoVotacao.application.service.SessaoVotacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RequiredArgsConstructor
@RestController
public class SessaoVotacaoController implements SessaoVotacaoAPI {

	private final SessaoVotacaoService sessaoVotacaoService;

	@Override
	public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
		log.info("[Start] SessaoVotacaoController  - abreSessao");
		log.info("[Start] SessaoVotacaoController  - {}", sessaoAberturaRequest.getIdPauta());		
		SessaoAberturaResponse sessaoAberturaResponse = sessaoVotacaoService.abreSessao(sessaoAberturaRequest);
		log.info("[Finish] SessaoVotacaoController  - abreSessao");
		return sessaoAberturaResponse;
	}
}
