package br.com.onboarding.anime.application.repository;

import br.com.onboarding.anime.application.mapper.AnimeMapper;
import br.com.onboarding.anime.application.repository.jpa.AnimeJpa;
import br.com.onboarding.anime.domain.domain.Anime;
import br.com.onboarding.anime.domain.port.AnimeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Slf4j
@Repository
@RequiredArgsConstructor
public class AnimeRepositoryImpl implements AnimeRepository {

    private final AnimeJpa animeJpa;

    @Transactional(rollbackOn = Exception.class)
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

    @Override
    public Anime buscarPorId(Long id) {
        try {
            var animeEntity = animeJpa.findById(id);
            if(animeEntity.isPresent()) {
                return AnimeMapper.entityParaDominio(animeEntity.get());
            }
        } catch (Exception e) {
            log.error("Erro ao tentar buscar o anime. Por Id: {}", id, e);
            throw e;
        }
        return Anime.builder().build();
    }

}
