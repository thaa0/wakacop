package academy.wakanda.Wakacop.sessaoVotacao.application.service;

import java.util.UUID;

import academy.wakanda.Wakacop.sessaoVotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.Wakacop.sessaoVotacao.application.api.SessaoAberturaResponse;
import academy.wakanda.Wakacop.sessaoVotacao.application.api.VotoResponse;
import academy.wakanda.Wakacop.sessaoVotacao.domain.VotoRequest;

public interface SessaoVotacaoService {
	SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
	VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto);
}