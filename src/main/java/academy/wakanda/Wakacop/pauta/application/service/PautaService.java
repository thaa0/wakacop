package academy.wakanda.Wakacop.pauta.application.service;

import academy.wakanda.Wakacop.pauta.application.api.NovaPautaRequest;
import academy.wakanda.Wakacop.pauta.application.api.PautaCadastradaResponse;

public interface PautaService {
	PautaCadastradaResponse cadastraPauta(NovaPautaRequest novaPauta);
}