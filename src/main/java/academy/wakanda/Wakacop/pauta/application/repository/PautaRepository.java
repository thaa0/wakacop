package academy.wakanda.Wakacop.pauta.application.repository;

import java.util.UUID;

import academy.wakanda.Wakacop.pauta.domain.Pauta;

public interface PautaRepository {
	Pauta salva(Pauta pauta);
	Pauta getPautaPorId(UUID idPauta);
}