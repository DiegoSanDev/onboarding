package br.com.onboarding.anime.application.presentation.representation;

import br.com.onboarding.anime.application.presentation.representation.enums.TipoGeneroRepresentation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnimeResponseRepresentation {

    private Long id;
    private String nome;
    private String nomeAutor;
    private int anoPublicacao;
    private int numeroEpisodios;
    private String sinopse;
    private TipoGeneroRepresentation tipoGenero;

}
