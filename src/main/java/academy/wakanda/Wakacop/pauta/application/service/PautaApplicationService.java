package academy.wakanda.Wakacop.pauta.application.service;

import org.springframework.stereotype.Service;

import academy.wakanda.Wakacop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.Wakacop.pauta.application.api.PautaCadastradaResponse;
import academy.wakanda.Wakacop.pauta.application.repository.PautaRepository;
import academy.wakanda.Wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class PautaApllicationService implements PautaService {

	private final PautaRepository pautaRepository;

	@Override
	public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
		log.info("[Start] PautaApllicationService - cadastraPauta");
		log.info("[Nova Pauta] - {}", novaPauta);
		Pauta pauta = pautaRepository.salva(new Pauta(novaPauta));
		log.info("[Finish] PautaApllicationService - cadastraPauta");
		return new PautaCadastradaResponse(pauta);
	}
}