package academy.wakanda.Wakacop.sessaoVotacao.application.api;

import java.time.LocalDateTime;
import java.util.UUID;

import academy.wakanda.Wakacop.sessaoVotacao.domain.VotoPauta;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoResponse {
	private UUID id;
	private UUID idSessao;
	private String cpfAssociado;
	private LocalDateTime momentoVoto;
	
	public VotoResponse(VotoPauta voto) {
		this.id = voto.getId();
		this.idSessao = voto.getIdSessao();
		this.cpfAssociado = voto.getCpfAssociado();
		this.momentoVoto = voto.getMomentoVoto();
	}

}
