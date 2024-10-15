package academy.wakanda.Wakacop.sessaoVotacao.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class VotoRequest {
	private String cpfAssociado;
	private OpcaoVoto opcaoVoto;
}