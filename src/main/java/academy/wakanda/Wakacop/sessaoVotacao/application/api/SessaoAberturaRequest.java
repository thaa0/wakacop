package academy.wakanda.Wakacop.sessaoVotacao.application.api;

import java.util.Optional;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class SessaoAberturaRequest {
	@NotNull
	private UUID idPauta;
	private Integer tempoDuracao;
	
	public Optional<Integer> getTempoDuracao(){return Optional.ofNullable(this.tempoDuracao);}
}