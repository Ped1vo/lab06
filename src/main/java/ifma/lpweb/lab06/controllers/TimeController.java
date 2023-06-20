package ifma.lpweb.lab06.controllers;

import ifma.lpweb.lab06.dtos.TimeDTO;
import ifma.lpweb.lab06.models.Jogador;
import ifma.lpweb.lab06.models.Time;
import ifma.lpweb.lab06.services.TimeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@AllArgsConstructor
@RestController
@RequestMapping("/times")
public class TimeController {

    private final TimeService timeService;

    @PostMapping
    public ResponseEntity<TimeDTO> cadastrar(@Valid @RequestBody TimeDTO timeDTO,
                                             UriComponentsBuilder builder) {
        Time time = new Time();
        time.setNome(timeDTO.getNome());
        time.setVitorias(timeDTO.getVitorias());
        time.setSaldoGols(timeDTO.getSaldoGols());
        time.setCampeonato(timeDTO.getCampeonato());
        time.setJogadores(timeDTO.getJogadores());
        time.setPartidasMandante(timeDTO.getPartidasMandante());
        time.setPartidasVisitante(timeDTO.getPartidasVisitante());
        final Object timeSalvo = timeService.cadastrar(time);
        final URI uri = builder.path("/times/{id}").buildAndExpand(time.getId()).toUri();
        return ResponseEntity.created(uri).body(convertToDTO((Time) timeSalvo));
    }

    @GetMapping("/por-id/{id}")
    public ResponseEntity<TimeDTO> buscarPorId(@PathVariable Long id) {
        return timeService.buscarPorId(id)
                .map(time -> ResponseEntity.ok(convertToDTO(time)))
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<TimeDTO> atualizar(@PathVariable Long id, @Valid @RequestBody TimeDTO timeDTO) {
        if (timeService.naoExisteTimeCom(id)) {
            return ResponseEntity.notFound().build();
        } else {
            Time time = new Time();
            time.setNome(timeDTO.getNome());
            time.setVitorias(timeDTO.getVitorias());
            time.setSaldoGols(timeDTO.getSaldoGols());
            time.setCampeonato(timeDTO.getCampeonato());
            time.setJogadores(timeDTO.getJogadores());
            time.setPartidasMandante(timeDTO.getPartidasMandante());
            time.setPartidasVisitante(timeDTO.getPartidasVisitante());

            Time timeAtualizado = timeService.atualizar(time);
            return ResponseEntity.ok(convertToDTO(timeAtualizado));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Time> timeOptional = timeService.buscarPorId(id);
        if (timeOptional.isPresent()) {
            timeService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<TimeDTO>> listar() {
        Iterable<Time> times = timeService.listar();
        List<TimeDTO> timeDTOs = new ArrayList<>();

        for (Time time : times) {
            TimeDTO timeDTO = convertToDTO(time);
            timeDTOs.add(timeDTO);
        }

        return ResponseEntity.ok(timeDTOs);
    }



    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public ResponseEntity<List<TimeDTO>> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        Page<Time> pagina = timeService.listarPaginado(paginacao);
        List<TimeDTO> timeDTOs = pagina.getContent().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(timeDTOs);
    }

    @GetMapping("/paginacao")
    public Page<TimeDTO> listarPaginado(@RequestParam(required = false) String nome, @PageableDefault(
            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao) {
        if (nome == null) {
            Page<Time> pagina = timeService.listarPaginado(paginacao);
            return pagina.map(this::convertToDTO);
        } else {
            Page<Time> pagina = timeService.listarPorNome(nome, paginacao);
            return pagina.map(this::convertToDTO);
        }
    }

    @GetMapping("timesporcampeonato/{campeonatoId}")
    public ResponseEntity<List<TimeDTO>> findByCampeonatoId(@PathVariable Long campeonatoId) {
        List<Time> times = timeService.findByCampeonatoId(campeonatoId);
        List<TimeDTO> timeDTOs = times.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());

        return ResponseEntity.ok(timeDTOs);
    }

    // Implemente as outras operações do controlador (delete, listar, etc.) seguindo o mesmo padrão

    // Método utilitário para converter um objeto Time em TimeDTO
    private TimeDTO convertToDTO(Time time) {
        TimeDTO timeDTO = new TimeDTO();
        timeDTO.setId(time.getId());
        timeDTO.setNome(time.getNome());
        timeDTO.setEndereco(String.valueOf(time.getVitorias()));
        timeDTO.setVitorias(time.getVitorias());
        timeDTO.setSaldoGols(time.getSaldoGols());
        timeDTO.setCampeonato(time.getCampeonato());
        timeDTO.setJogadores(time.getJogadores());
        timeDTO.setPartidasMandante(time.getPartidasMandante());
        timeDTO.setPartidasVisitante(time.getPartidasVisitante());

        return timeDTO;
    }

    /*
    @PostMapping
    public ResponseEntity<Time> cadastrar(@Valid @RequestBody Time time,
                                          UriComponentsBuilder builder) {
        final Object timeSalvo = timeService.cadastrar(time);
        final URI uri = builder.path("/times/{id}").buildAndExpand(time.getId()).toUri();
        return ResponseEntity.created(uri).body((Time) timeSalvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Time> buscarPorId(@PathVariable Long id) {
        return timeService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}")
    public ResponseEntity<Time> atualizar(@PathVariable Long id, @Valid @RequestBody Time time) {
        if(timeService.naoExisteTimeCom(id)) {
            return ResponseEntity.notFound().build();
        }else {
            time.setId(id);
            Time timeAtualizado = timeService.atualizar(time);
            return ResponseEntity.ok(timeAtualizado);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Time> deletar(@PathVariable Long id) {
        Optional<Time> jogadorOptional = timeService.buscarPorId(id);
        if (jogadorOptional.isPresent()) {
            timeService.deletar(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Time>> listar() {
        Iterable<Time> times = timeService.listar();
        return ResponseEntity.ok(times);
    }


    @GetMapping("pagina/{numeroPagina}/{quantidadePagina}")
    public Iterable<Time> listarPaginado(@PathVariable Integer numeroPagina, @PathVariable Integer quantidadePagina) {
        if (quantidadePagina > 5) quantidadePagina = 5;
        PageRequest paginacao = PageRequest.of(numeroPagina, quantidadePagina, Sort.by("nome"));
        return timeService.listarPaginado(paginacao);
    }


    @GetMapping("/paginacao")
    public Page<Time> listarPaginado(@RequestParam(required = false)String nome, @PageableDefault(
            sort = "nome", direction = Sort.Direction.ASC, page = 0, size = 5) Pageable paginacao){
        if (nome == null) {
            return timeService.listarPaginado(paginacao);
        } else {
            return timeService.listarPorNome(nome, paginacao);
        }
    }
    @GetMapping("timesporcampeonato/{campeonatoId}")
    public List<Time> findByCampeonatoId(@PathVariable Long campeonatoId) {
        return timeService.findByCampeonatoId(campeonatoId);
    }
     */
}
