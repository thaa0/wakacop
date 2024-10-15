package academy.wakanda.Wakacop.pauta.application.service;

import java.util.UUID;

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
public class PautaApplicationService implements PautaService {

	private final PautaRepository pautaRepository;

	@Override
	public PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta) {
		log.info("[Start] PautaApplicationService - cadastraPauta");
		log.info("[Nova Pauta] - {}", novaPauta);
		Pauta pauta = pautaRepository.salva(new Pauta(novaPauta));
		log.info("[Finish] PautaApllicationService - cadastraPauta");
		return new PautaCadastradaResponse(pauta);
	}

	@Override
	public Pauta getPautaPorId(UUID idPauta) {
		log.info("[Start] PautaApplicationService - getPautaPorId");
		Pauta pauta = pautaRepository.getPautaPorId(idPauta);
		log.info("[Finish] PautaApllicationService - getPautaPorId");
		return pauta;
	}
}