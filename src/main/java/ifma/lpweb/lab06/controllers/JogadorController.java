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

import java.util.Optional;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;

    @PostMapping
    public ResponseEntity<Jogador> cadastrar(@Valid @RequestBody Jogador jogador) {
        final var jogadorCadastrado = jogadorService.cadastrar(jogador);
        return ResponseEntity.ok((Jogador) jogadorCadastrado);
    }

    @GetMapping("/{idJogador}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable UUID idJogador) {
        Optional<Jogador> jogadorOptional = jogadorService.buscarPorId(idJogador);
        if (jogadorOptional.isPresent()) {
            Jogador jogador = jogadorOptional.get();
            return ResponseEntity.ok(jogador);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("/{idJogador}")
    public ResponseEntity<Jogador> atualizar(@PathVariable UUID idJogador, @Valid @RequestBody Jogador jogador) {
        Optional<Jogador> jogadorOptional = jogadorService.buscarPorId(idJogador);
        if (jogadorOptional.isPresent()) {
            Jogador jogadorAtualizado = jogadorService.atualizar(jogador);
            return ResponseEntity.ok(jogadorAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{idJogador}")
    public ResponseEntity<Jogador> deletar(@PathVariable UUID idJogador) {
        Optional<Jogador> jogadorOptional = jogadorService.buscarPorId(idJogador);
        if (jogadorOptional.isPresent()) {
            jogadorService.deletar(idJogador);
            return ResponseEntity.ok().build();
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


