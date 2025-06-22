package com.douglas.desafiofinal.facade;

import com.douglas.desafiofinal.dto.ClienteDto;
import com.douglas.desafiofinal.service.ClienteService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClienteFacade {

    private final ClienteService clienteService;

    public ClienteFacade(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public List<ClienteDto> buscarClientesPorNomeOuTodos(String nome) {
        if (nome != null && !nome.isBlank())
            return clienteService.buscarPorNome(nome);
        return clienteService.listarTodos();
    }
 }
