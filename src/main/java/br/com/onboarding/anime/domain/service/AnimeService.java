package br.com.onboarding.anime.domain.service;

import br.com.onboarding.anime.domain.domain.Anime;
import br.com.onboarding.anime.domain.port.AnimeRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(final AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Anime salvar(Anime anime) {
        try {
            return this.animeRepository.salvar(anime);
        } catch (Exception e) {
            log.error("Erro ao tentar salvar um anime. {}", anime, e);
            throw e;
        }
    }

    public Anime buscarPorId(Long id) {
        try {
            return this.animeRepository.buscarPorId(id);
        } catch (Exception e) {
            log.error("Erro ao tentar buscar o Anime. Por id: {}", id, e);
            throw e;
        }
    }

    public Anime atualizar(Anime anime) {
        try {
            return this.animeRepository.atualizar(anime);
        }catch (Exception e) {
            log.error("Erro ao tentar atualizar o anime: {}", anime, e);
            throw e;
        }
    }

}
