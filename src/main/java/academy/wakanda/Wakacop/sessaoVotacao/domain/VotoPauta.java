package academy.wakanda.Wakacop.sessaoVotacao.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@NoArgsConstructor
public class VotoPauta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID id;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "sessao_votacao_id")
	private SessaoVotacao sessaoVotacao;
	private String cpfAssociado;
	private OpcaoVoto opcaoVoto;
	private LocalDateTime momentoVoto;
	
	public VotoPauta(SessaoVotacao sessaoVotacao, VotoRequest votoRequest) {
		this.sessaoVotacao = sessaoVotacao;
		this.cpfAssociado = votoRequest.getCpfAssociado();
		this.opcaoVoto = votoRequest.getOpcaoVoto();
		this.momentoVoto = LocalDateTime.now();
	}
	
	public UUID getIdSessao() {
		return this.sessaoVotacao.getId();
	}
	
	public boolean opcaoIgual(OpcaoVoto opcao) {
		return this.opcaoVoto.equals(opcao);
	}
}