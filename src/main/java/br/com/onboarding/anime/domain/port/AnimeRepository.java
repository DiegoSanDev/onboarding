package br.com.onboarding.anime.domain.port;

import br.com.onboarding.anime.domain.domain.Anime;

public interface AnimeRepository {

    Anime salvar(Anime anime);
    Anime buscarPorId(Long id);
    Anime atualizar(Anime anime);

}
