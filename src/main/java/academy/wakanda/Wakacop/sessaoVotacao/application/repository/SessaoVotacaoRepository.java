package academy.wakanda.Wakacop.sessaoVotacao.application.repository;

import java.util.UUID;

import academy.wakanda.Wakacop.sessaoVotacao.domain.SessaoVotacao;

public interface SessaoVotacaoRepository {
	SessaoVotacao salva(SessaoVotacao sessaoVotacao);
	SessaoVotacao buscaPorId(UUID idSessao);
}