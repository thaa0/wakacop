package academy.wakanda.Wakacop.sessaoVotacao.application.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import academy.wakanda.Wakacop.pauta.application.service.PautaService;
import academy.wakanda.Wakacop.pauta.domain.Pauta;
import academy.wakanda.Wakacop.sessaoVotacao.application.api.SessaoAberturaRequest;
import academy.wakanda.Wakacop.sessaoVotacao.application.api.SessaoAberturaResponse;
import academy.wakanda.Wakacop.sessaoVotacao.application.api.VotoResponse;
import academy.wakanda.Wakacop.sessaoVotacao.application.repository.SessaoVotacaoRepository;
import academy.wakanda.Wakacop.sessaoVotacao.domain.SessaoVotacao;
import academy.wakanda.Wakacop.sessaoVotacao.domain.VotoPauta;
import academy.wakanda.Wakacop.sessaoVotacao.domain.VotoRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@RequiredArgsConstructor
@Log4j2
public class SessaoVotacaoApplicationService implements SessaoVotacaoService {

	private final SessaoVotacaoRepository sessaoVotacaoRepository;
	private final PautaService pautaService;

	@Override
	public SessaoAberturaResponse abreSessao(SessaoAberturaRequest sessaoAberturaRequest) {
		log.info("[Start] SessaoVotacaoApplicationService  - abreSessao");
		log.info("ID da pauta recebido: {}", sessaoAberturaRequest.getIdPauta());
		Pauta pauta = pautaService.getPautaPorId(sessaoAberturaRequest.getIdPauta());
		SessaoVotacao sessaoVotacao = sessaoVotacaoRepository.salva(new SessaoVotacao(sessaoAberturaRequest,pauta));
		log.info("[Finish] SessaoVotacaoApplicationService  - abreSessao");
		return new SessaoAberturaResponse(sessaoVotacao);
	}

	@Override
	public VotoResponse recebeVoto(UUID idSessao, VotoRequest novoVoto) {
		log.info("[Start] SessaoVotacaoApplicationService  - recebeVoto");
		SessaoVotacao sessao = sessaoVotacaoRepository.buscaPorId(idSessao);
		VotoPauta voto =  sessao.recebeVoto(novoVoto);
		sessaoVotacaoRepository.salva(sessao);
		log.info("[Finish] SessaoVotacaoApplicationService  - recebeVoto");
		return new VotoResponse(voto);
	}
}