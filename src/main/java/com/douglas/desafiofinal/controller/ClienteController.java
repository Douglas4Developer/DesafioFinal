package com.douglas.desafiofinal.controller;

import com.douglas.desafiofinal.dto.ClienteDto;
import com.douglas.desafiofinal.service.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping
    public List<ClienteDto> listarTodos() {
        return clienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDto> buscarPorId(@PathVariable Long id) {
        ClienteDto dto = clienteService.buscarPorId(id);
        return dto != null
                ? ResponseEntity.ok(dto)
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/nome/{nome}")
    public List<ClienteDto> buscarPorNome(@PathVariable String nome) {
        return clienteService.buscarPorNome(nome);
    }

    @GetMapping("/contar")
    public long contar() {
        return clienteService.contar();
    }

    @PostMapping
    public ResponseEntity<ClienteDto> salvar(@RequestBody ClienteDto clienteDto) {
        ClienteDto criado = clienteService.salvar(clienteDto);
        return ResponseEntity.ok(criado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDto> atualizar(
            @PathVariable Long id,
            @RequestBody ClienteDto clienteDto) {
        ClienteDto atualizado = clienteService.atualizar(id, clienteDto);
        return atualizado != null
                ? ResponseEntity.ok(atualizado)
                : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        clienteService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
