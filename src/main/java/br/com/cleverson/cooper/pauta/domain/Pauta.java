package br.com.cleverson.cooper.pauta.domain;

import br.com.cleverson.cooper.pauta.application.api.NovaPautaRequest;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@ToString
@Entity
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
