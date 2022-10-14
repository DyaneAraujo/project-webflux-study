package br.com.webflux.controller;

import br.com.webflux.domain.Anime;
import br.com.webflux.repository.AnimeRepository;
import br.com.webflux.service.AnimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/animes")
@RequiredArgsConstructor
public class AnimeController {

    private final AnimeService animeService;

    //o Spring faz o subscriber através da class interna ServletHttpHandlerAdapter,
    // por isso os endpoints Publisher funcionam

    @GetMapping
    public Flux<Anime> listAll(){
        return animeService.findAll();
    }

    @GetMapping(path = "{id}")
    public Mono<Anime> findById(@PathVariable int id){
        return animeService.findById(id);
    }
}
