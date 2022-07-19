package br.com.onboarding.anime.application.repository;

import br.com.onboarding.anime.domain.domain.Anime;
import br.com.onboarding.anime.domain.port.AnimeRepository;
import org.springframework.stereotype.Repository;

@Repository
public class AnimeRepositoryImpl implements AnimeRepository {

    @Override
    public Anime salvar(Anime anime) {
        return null;
    }

}
