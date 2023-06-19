package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.dtos.request.JogadorRequest;
import ifma.lpweb.lab06.dtos.response.JogadorResponse;
import ifma.lpweb.lab06.mapper.JogadorMapper;
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

@AllArgsConstructor
@RestController
@RequestMapping("/jogadores")
public class JogadorController {
    private final JogadorService jogadorService;
    private final JogadorMapper jogadorMapper;

    @PostMapping
    public ResponseEntity<JogadorResponse> cadastrarJogador(@Valid @RequestBody JogadorRequest jogadorRequest,
                                                            UriComponentsBuilder builder) {
        Jogador jogador = jogadorMapper.toJogador(jogadorRequest);
        Jogador jogadorSalvo = jogadorService.cadastrar(jogador);
        JogadorResponse jogadorResponse = jogadorMapper.toJogadorResponse(jogadorSalvo);

        URI uri = builder.path("/jogadores/{id}").buildAndExpand(jogadorSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(jogadorResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogadorResponse> buscarPorId(@PathVariable Long id) {
        Jogador jogador = jogadorService.buscarPorId(id);
        if (jogador != null) {
            JogadorResponse jogadorResponse = jogadorMapper.toJogadorResponse(jogador);
            return ResponseEntity.ok(jogadorResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizar(@PathVariable Long id, @Valid @RequestBody JogadorRequest jogadorRequest) {
        if(jogadorService.naoExisteJogadorCom(id)) {
            return ResponseEntity.notFound().build();
        } else {
            Jogador jogador = JogadorMapper.toEntity(jogadorRequest);
            jogador.setId(id);
            Jogador jogadorAtualizado = jogadorService.atualizar(jogador);
            return ResponseEntity.ok(jogadorAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (jogadorService.naoExisteJogadorCom(id)) {
            return ResponseEntity.notFound().build();
        } else {
            jogadorService.delete(id);
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<JogadorResponse>> listar() {
        Iterable<Jogador> jogadores = jogadorService.listar();
        Iterable<JogadorResponse> jogadoresResponse = jogadorMapper.toResponseList(jogadores);
        return ResponseEntity.ok(jogadoresResponse);
    }


    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public Iterable<JogadorResponse> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        Page<Jogador> jogadoresPaginados = jogadorService.listarPaginado(paginacao);
        return jogadorMapper.toResponseList(jogadoresPaginados);
    }


    @GetMapping("/paginacao")
    public Page<JogadorResponse> listarPaginado(@RequestParam(required = false) String nome, @PageableDefault(
            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        if (nome == null) {
            Page<Jogador> jogadoresPaginados = jogadorService.listarPaginado(paginacao);
            return jogadorMapper.toResponsePage(jogadoresPaginados);
        } else {
            Page<Jogador> jogadoresPaginadosPorNome = jogadorService.listarPorNome(nome, paginacao);
            return jogadorMapper.toResponsePage(jogadoresPaginadosPorNome);
        }
    }





    /*
    @PostMapping
    public ResponseEntity<Jogador> cadastrar(@Valid @RequestBody Jogador jogador,
                                             UriComponentsBuilder builder) {
        final Object jogadorSalvo = jogadorService.cadastrar(jogador);
        final URI uri = builder.path("/jogadores/{idJogador}").buildAndExpand(jogador.getId()).toUri();
        return ResponseEntity.created(uri).body((Jogador) jogadorSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarPorId(@PathVariable Long id) {
        return jogadorService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizar(@PathVariable Long id, @Valid @RequestBody Jogador jogador) {
        if(jogadorService.naoExisteJogadorCom(id)) {
            return ResponseEntity.notFound().build();
        }else {
            jogador.setId(id);
            Jogador jogadorAtualizado = jogadorService.atualizar(jogador);
            return ResponseEntity.ok(jogadorAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Jogador> deletar(@PathVariable Long id) {
        Optional<Jogador> jogadorOptional = jogadorService.buscarPorId(id);
        if (jogadorOptional.isPresent()) {
            jogadorService.deletar(id);
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

     */
}


