package academy.wakanda.Wakacop.sessaoVotacao.application.service;

import academy.wakanda.Wakacop.sessaoVotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.Wakacop.sessaoVotacao.application.api.SessaoAberturaResponse;

public interface SessaoVotacaoService {
	SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
}