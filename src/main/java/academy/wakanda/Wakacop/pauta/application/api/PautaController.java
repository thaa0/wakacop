package academy.wakanda.Wakacop.pauta.application.api;

import org.springframework.web.bind.annotation.RestController;
import academy.wakanda.Wakacop.pauta.application.service.PautaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequiredArgsConstructor
@Log4j2
public class PautaController implements PautaAPI {

	private final PautaService pautaService;

	@Override
	public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
		log.info("[Start] PautaController - cadastraPauta");
		PautaCadastradaResponse pautaCadastrada = pautaService.cadastraPauta(novaPauta);
		log.info("[Start] PautaController - cadastraPauta");
		return pautaCadastrada;
	}

}