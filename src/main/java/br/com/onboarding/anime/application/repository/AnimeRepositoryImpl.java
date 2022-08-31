package br.com.onboarding.anime.application.repository;

import br.com.onboarding.anime.application.mapper.AnimeMapper;
import br.com.onboarding.anime.application.repository.jpa.AnimeJpa;
import br.com.onboarding.anime.domain.domain.Anime;
import br.com.onboarding.anime.domain.port.AnimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

import static br.com.onboarding.anime.application.mapper.AnimeMapper.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AnimeRepositoryImpl implements AnimeRepository {

    private final AnimeJpa animeJpa;

    @Transactional(rollbackOn = Exception.class)
    @Override
    public Anime salvar(Anime anime) {
        try {
            var animeEntity = animeJpa.save(paraEntity(anime));
            return entityParaDominio(animeEntity);
        } catch (Exception e) {
            log.error("Erro ao tentar salvar o anime. {}", anime, e);
            throw e;
        }
    }

    @Override
    public Anime buscarPorId(Long id) {
        try {
            var animeEntity = animeJpa.findById(id);
            if(animeEntity.isPresent()) {
                return entityParaDominio(animeEntity.get());
            }
        } catch (Exception e) {
            log.error("Erro ao tentar buscar o anime. Por Id: {}", id, e);
            throw e;
        }
        return Anime.builder().build();
    }

    @Override
    public Anime atualizar(Anime anime) {
        try {
            var getAnimeEntity = animeJpa.findById(anime.getId());
            if(getAnimeEntity.isPresent()) {
                anime.setId(getAnimeEntity.get().getId());
                return entityParaDominio(animeJpa.save(paraEntity(anime)));
            }
        } catch (Exception e) {
            log.error("Erro ao tentar atulizar o anime: {}", anime, e);
            throw e;
        }
        return Anime.builder().build();
    }
}
