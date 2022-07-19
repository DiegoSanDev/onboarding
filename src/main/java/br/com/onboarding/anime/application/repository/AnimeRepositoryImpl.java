package br.com.onboarding.anime.application.repository;

import br.com.onboarding.anime.application.mapper.AnimeMapper;
import br.com.onboarding.anime.application.repository.jpa.AnimeJpa;
import br.com.onboarding.anime.domain.domain.Anime;
import br.com.onboarding.anime.domain.port.AnimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AnimeRepositoryImpl implements AnimeRepository {

    private final AnimeJpa animeJpa;

    @Override
    public Anime salvar(Anime anime) {
        try {
            var animeEntity = animeJpa.save(AnimeMapper.paraEntity(anime));
            return AnimeMapper.entityParaDominio(animeEntity);
        } catch (Exception e) {
            log.error("Erro ao tentar salvar o anime. {}", anime, e);
            throw e;
        }
    }
}
