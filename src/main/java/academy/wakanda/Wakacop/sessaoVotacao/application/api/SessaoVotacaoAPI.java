package academy.wakanda.Wakacop.sessaoVotacao.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RequestMapping("/sessao/abertura")
public interface SessaoVotacaoAPI {
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest);
}