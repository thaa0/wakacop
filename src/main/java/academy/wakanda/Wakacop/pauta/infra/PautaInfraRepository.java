package academy.wakanda.Wakacop.pauta.infra;

import org.springframework.stereotype.Repository;

import academy.wakanda.Wakacop.pauta.application.repository.PautaRepository;
import academy.wakanda.Wakacop.pauta.domain.Pauta;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Repository
@Log4j2
@RequiredArgsConstructor
public class PautaInfraRepository implements PautaRepository {

	private final PautaSpringDataJPARepository pautaSpringDataJPARepository;

	@Override
	public Pauta salva(Pauta pauta) {
		log.info("[Start] PautaInfraRepository - salva");
		pautaSpringDataJPARepository.save(pauta);
		log.info("[Finish] PautaInfraRepository - salva");
		return pauta;
	}
}