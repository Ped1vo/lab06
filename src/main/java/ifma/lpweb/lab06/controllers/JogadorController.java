package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.services.JogadorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Jogador> cadastrar(@Valid @RequestBody Jogador jogador,
                                             UriComponentsBuilder builder) {
        final Object jogadorSalvo = jogadorService.cadastrar(jogador);
        final URI uri = builder.path("/jogadores/{idJogador}").buildAndExpand(jogador.getIdJogador()).toUri();
        return ResponseEntity.created(uri).body((Jogador) jogadorSalvo);
    }

    @GetMapping("/{idJogador}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable UUID idJogador) {
        return jogadorService.buscarPorId(idJogador)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{idJogador}")
    public ResponseEntity<Jogador> atualizar(@PathVariable UUID idJogador, @Valid @RequestBody Jogador jogador) {
        if(jogadorService.naoExisteJogadorCom(idJogador)) {
            return ResponseEntity.notFound().build();
        }else {
            jogador.setIdJogador(idJogador);
            Jogador jogadorAtualizado = jogadorService.atualizar(jogador);
            return ResponseEntity.ok(jogadorAtualizado);
        }
    }

    @DeleteMapping("/{idJogador}")
    public ResponseEntity<Jogador> deletar(@PathVariable UUID idJogador) {
        Optional<Jogador> jogadorOptional = jogadorService.buscarPorId(idJogador);
        if (jogadorOptional.isPresent()) {
            jogadorService.deletar(idJogador);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Jogador>> listar() {
        Iterable<Jogador> jogadores = jogadorService.listar();
        return ResponseEntity.ok(jogadores);
    }


    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public Iterable<Jogador> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        return jogadorService.listarPaginado(paginacao);
    }


    @GetMapping("/paginacao")
    public Page<Jogador> listarPaginado(@RequestParam(required = false)String nome, @PageableDefault(
                            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        if (nome == null) {
            return jogadorService.listarPaginado(paginacao);
        } else {
            return jogadorService.listarPorNome(nome, paginacao);
        }
    }
}


