package br.com.onboarding.anime.domain.domain;

import br.com.onboarding.anime.domain.enums.TipoGenero;
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
public class Anime {

    private Long id;
    private String nome;
    private String nomeAutor;
    private int anoPublicacao;
    private int numeroEpisodios;
    private String sinopse;
    private TipoGenero tipoGenero;

}
