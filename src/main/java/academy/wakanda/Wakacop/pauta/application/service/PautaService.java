package academy.wakanda.Wakacop.pauta.application.service;

import java.util.UUID;

import academy.wakanda.Wakacop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.Wakacop.pauta.application.api.PautaCadastradaResponse;
import academy.wakanda.Wakacop.pauta.domain.Pauta;

public interface PautaService {
	PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta);
	Pauta getPautaPorId(UUID idPauta);
}