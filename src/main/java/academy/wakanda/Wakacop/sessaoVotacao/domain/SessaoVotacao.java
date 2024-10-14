package academy.wakanda.Wakacop.sessaoVotacao.domain;

import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	private LocalDateTime dataAbertura;
	
	public SessaoVotacao(SessaoAberturaRequest sessaoAberturaRequest) {
		this.idPauta = sessaoAberturaRequest.getIdPauta();
		this.tempoDuracao = sessaoAberturaRequest.getTempoDuracao().orElse(1);
		this.dataAbertura = LocalDateTime.now();
	}
}