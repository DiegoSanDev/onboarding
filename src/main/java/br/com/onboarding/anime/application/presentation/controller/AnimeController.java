package br.com.onboarding.anime.application.presentation.controller;

import br.com.onboarding.anime.application.mapper.AnimeMapper;
import br.com.onboarding.anime.application.presentation.representation.AnimeRequestRepresentation;
import br.com.onboarding.anime.application.presentation.representation.AnimeResponseRepresentation;
import br.com.onboarding.anime.domain.service.AnimeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

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

    @GetMapping("/{id}")
    public ResponseEntity<AnimeResponseRepresentation> buscarPorId(@PathVariable Long id) {
        var animeDomain = service.buscarPorId(id);
        if (Objects.nonNull(animeDomain) && Objects.nonNull(animeDomain.getId())) {
            return ResponseEntity.ok(AnimeMapper.paraRepresentacao(animeDomain));
        }
        return ResponseEntity.noContent().build();
    }

}
