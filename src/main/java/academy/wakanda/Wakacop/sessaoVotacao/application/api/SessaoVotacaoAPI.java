package academy.wakanda.Wakacop.sessaoVotacao.application.api;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import academy.wakanda.Wakacop.sessaoVotacao.domain.VotoRequest;

@RequestMapping("/sessao")
public interface SessaoVotacaoAPI {
	@PostMapping("/abertura")
	@ResponseStatus(HttpStatus.CREATED)
	SessaoAberturaResponse abreSessao(@RequestBody SessaoAberturaRequest sessaoAberturaRequest);
	
	@PostMapping("/{idSessao}/voto")
	@ResponseStatus(HttpStatus.CREATED)
	VotoResponse recebeVoto(@PathVariable UUID idSessao, @RequestBody VotoRequest novoVoto);
}