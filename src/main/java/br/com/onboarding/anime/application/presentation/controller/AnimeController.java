package br.com.onboarding.anime.application.presentation.controller;

import br.com.onboarding.anime.application.mapper.AnimeMapper;
import br.com.onboarding.anime.application.presentation.representation.AnimeRequestRepresentation;
import br.com.onboarding.anime.application.presentation.representation.AnimeResponseRepresentation;
import br.com.onboarding.anime.domain.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.Objects.nonNull;

@RestController
@RequestMapping("/v1/animes")
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService service;

    @PostMapping
    public ResponseEntity<AnimeResponseRepresentation> salvar(@RequestBody AnimeRequestRepresentation body) {
        var anime = service.salvar(AnimeMapper.paraDominio(body));
        if (nonNull(anime)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(AnimeMapper.paraRepresentacao(anime));
        }
        return ResponseEntity.badRequest().build();
    }

}
