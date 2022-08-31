package br.com.onboarding.anime.application.presentation.controller;

import br.com.onboarding.anime.application.presentation.representation.AnimeRequestRepresentation;
import br.com.onboarding.anime.application.presentation.representation.AnimeResponseRepresentation;
import br.com.onboarding.anime.domain.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static br.com.onboarding.anime.application.mapper.AnimeMapper.deRepresentationParaDominio;
import static br.com.onboarding.anime.application.mapper.AnimeMapper.paraDominio;
import static br.com.onboarding.anime.application.mapper.AnimeMapper.paraRepresentacao;
import static java.util.Objects.nonNull;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.http.ResponseEntity.unprocessableEntity;

@RestController
@RequestMapping("/v1/animes")
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService service;

    @PostMapping
    public ResponseEntity<AnimeResponseRepresentation> salvar(@RequestBody AnimeRequestRepresentation body) {
        var anime = service.salvar(paraDominio(body));
        if (nonNull(anime)) {
            return status(HttpStatus.CREATED).body(paraRepresentacao(anime));
        }
        return badRequest().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AnimeResponseRepresentation> buscarPorId(@PathVariable Long id) {
        var animeDomain = service.buscarPorId(id);
        if (nonNull(animeDomain) && nonNull(animeDomain.getId())) {
            return ok(paraRepresentacao(animeDomain));
        }
        return noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<AnimeResponseRepresentation> atualizar(@PathVariable("id") Long id, @RequestBody AnimeRequestRepresentation body) {
        var anime = deRepresentationParaDominio(body);
        anime.setId(id);
        var animeAtualizado = service.atualizar(anime);
        if (nonNull(animeAtualizado)) {
            return ok(paraRepresentacao(anime));
        }
        return unprocessableEntity().build();
    }

}
