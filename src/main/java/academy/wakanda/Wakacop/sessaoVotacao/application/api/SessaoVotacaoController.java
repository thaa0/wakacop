package academy.wakanda.Wakacop.sessaoVotacao.application.api;

import java.util.UUID;

import org.springframework.web.bind.annotation.RestController;

import academy.wakanda.Wakacop.sessaoVotacao.application.service.SessaoVotacaoService;
import academy.wakanda.Wakacop.sessaoVotacao.domain.VotoRequest;
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

	@Override
	public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
		log.info("[Start] SessaoVotacaoController  - recebeVoto");
		log.info("[Start] idSessao  - {}", idSessao);
		VotoResponse votoResponse = sessaoVotacaoService.recebeVoto(idSessao,novoVoto);
		log.info("[Finish] SessaoVotacaoController  - recebeVoto");
		return votoResponse;
	}

	@Override
	public ResultadoSessaoResponse obtemResultado(UUID idSessao) {
		log.info("[Start] SessaoVotacaoController  - obtemResultado");
		log.info("[Start] idSessao  - {}", idSessao);	
		ResultadoSessaoResponse resultado = sessaoVotacaoService.obtemResultado(idSessao);
		log.info("[Finish] SessaoVotacaoController  - obtemResultado");
		return resultado;
	}

}
