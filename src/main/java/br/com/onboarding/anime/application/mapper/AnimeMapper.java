package br.com.onboarding.anime.application.mapper;

import br.com.onboarding.anime.application.presentation.representation.AnimeRequestRepresentation;
import br.com.onboarding.anime.application.presentation.representation.AnimeResponseRepresentation;
import br.com.onboarding.anime.application.repository.jpa.entity.AnimeEntity;
import br.com.onboarding.anime.domain.domain.Anime;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.experimental.UtilityClass;
import org.apache.logging.log4j.util.Supplier;
import org.modelmapper.ModelMapper;

@UtilityClass
public class AnimeMapper {

    private final Supplier<ModelMapper> modelMapperSupplier = ModelMapper::new;


    public Anime deRepresentationParaDominio(AnimeRequestRepresentation body) {
        return modelMapperSupplier.get().map(body, Anime.class);
    }

    public Anime paraDominio(AnimeRequestRepresentation representation) {
        return modelMapperSupplier.get().map(representation, Anime.class);
    }

    public AnimeResponseRepresentation paraRepresentacao(Anime anime) {
        return modelMapperSupplier.get().map(anime, AnimeResponseRepresentation.class);
    }

    public AnimeEntity paraEntity(Anime anime) {
        return modelMapperSupplier.get().map(anime, AnimeEntity.class);
    }

    public Anime entityParaDominio(AnimeEntity entity) {
        return modelMapperSupplier.get().map(entity, Anime.class);
    }

}
