package academy.wakanda.Wakacop.pauta.domain;

import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import academy.wakanda.Wakacop.pauta.application.api.NovaPautaRequest;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Pauta {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
	private UUID id;
	private String titulo;
	private String descricao;
	private UUID idAssociadoAutor;
	private LocalDateTime dataCriacao;

	
	public Pauta(NovaPautaRequest novaPauta) {
		this.titulo = novaPauta.getTitulo();
		this.descricao = novaPauta.getDescricao();
		this.idAssociadoAutor = novaPauta.getIdAssociadoAutor();
		this.dataCriacao = LocalDateTime.now();
	}
}