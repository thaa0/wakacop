package academy.wakanda.Wakacop.pauta.application.api;

import java.util.UUID;

import academy.wakanda.Wakacop.pauta.domain.Pauta;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PautaCadastradaResponse {
	private UUID id;
	public PautaCadastradaResponse(Pauta pauta) {
		this.id = pauta.getId();
	}
}