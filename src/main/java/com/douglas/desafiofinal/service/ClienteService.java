package com.douglas.desafiofinal.service;

import com.douglas.desafiofinal.dto.ClienteDto;

import java.util.List;

public interface ClienteService {
    List<ClienteDto> listarTodos();
    ClienteDto buscarPorId(Long id);
    List<ClienteDto> buscarPorNome(String nome);
    ClienteDto salvar(ClienteDto clienteDto);
    ClienteDto atualizar(Long id, ClienteDto clienteDto);
    void deletar(Long id);
    long contar();
}
