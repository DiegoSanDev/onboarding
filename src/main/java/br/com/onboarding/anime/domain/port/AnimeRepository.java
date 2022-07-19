package br.com.onboarding.anime.domain.port;

import br.com.onboarding.anime.domain.domain.Anime;

public interface AnimeRepository {

    Anime salvar(Anime anime);

}
