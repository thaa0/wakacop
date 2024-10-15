package academy.wakanda.Wakacop.sessaoVotacao.domain;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import academy.wakanda.Wakacop.pauta.domain.Pauta;
import academy.wakanda.Wakacop.sessaoVotacao.application.api.SessaoAberturaRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class SessaoVotacao {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID id;
	private UUID idPauta;
	private Integer tempoDuracao;
	@Enumerated(EnumType.STRING)
	private StatusSessaoVotacao status;
	private LocalDateTime dataAbertura;
	private LocalDateTime dataEncerramento;
	
	@OneToMany(mappedBy = "sessaoVotacao", cascade = CascadeType.ALL, orphanRemoval = true)
	@LazyCollection(LazyCollectionOption.FALSE)
	@MapKey(name = "cpfAssociado")
	private Map<String, VotoPauta> votos;
	
	public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest, Pauta pauta) {
		this.idPauta = pauta.getId();
		this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
		this.dataAbertura = LocalDateTime.now();
		this.dataEncerramento = dataAbertura.plusMinutes(this.tempoDuracao);
		this.status = StatusSessaoVotacao.ABERTA;
		this.votos = new HashMap<>();
	}
	
	public VotoPauta recebeVoto(VotoRequest votoRequest) {
		validaAssociado(votoRequest.getCpfAssociado());
		VotoPauta voto = new VotoPauta(this, votoRequest);
		votos.put(votoRequest.getCpfAssociado(), voto);
		return voto;
	}

	private void validaAssociado(String cpfAssociado) {
		if(this.votos.containsKey(cpfAssociado)) {
			new RuntimeException("Associado já votou nessa Sessão");
		}
		
	}
}