package academy.wakanda.Wakacop.sessaoVotacao.application.api;

import java.util.UUID;

import academy.wakanda.Wakacop.sessaoVotacao.domain.SessaoVotacao;
import lombok.Getter;

@Getter
public class SessaoAberturaResponse {
	private UUID idSessao;
	
	public SessaoAberturaResponse(SessaoVotacao sessaoVotacao) {
		this.idSessao = sessaoVotacao.getId();
	}
}