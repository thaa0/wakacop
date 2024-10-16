package academy.wakanda.Wakacop.sessaoVotacao.application.api;

import java.time.LocalDateTime;
import java.util.UUID;
import academy.wakanda.Wakacop.sessaoVotacao.domain.SessaoVotacao;
import academy.wakanda.Wakacop.sessaoVotacao.domain.StatusSessaoVotacao;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ResultadoSessaoResponse {
	private UUID id;
	private UUID idPauta;
	private StatusSessaoVotacao status;
	private LocalDateTime momentoAbertura;
	private LocalDateTime momentoEncerramento;
	private long totalVotos;
	private long totalSim;
	private long totalNao;
	
	public ResultadoSessaoResponse(SessaoVotacao sessao) {
		this.id = sessao.getId();
		this.idPauta = sessao.getIdPauta();
		this.status = sessao.getStatus();
		this.momentoAbertura = sessao.getMomentoAbertura();
		this.momentoEncerramento = sessao.getMomentoEncerramento();
		this.totalVotos = sessao.getTotalVotos();
		this.totalSim = sessao.getTotalSim();
		this.totalNao = sessao.getTotalNao();
	}
	
}