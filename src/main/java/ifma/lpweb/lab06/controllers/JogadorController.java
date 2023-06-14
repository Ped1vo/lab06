package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.services.JogadorService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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
}


