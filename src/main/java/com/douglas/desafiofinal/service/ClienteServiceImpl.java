package com.douglas.desafiofinal.service;

import com.douglas.desafiofinal.dto.ClienteDto;
import com.douglas.desafiofinal.mapper.ClienteMapper;
import com.douglas.desafiofinal.model.Cliente;
import com.douglas.desafiofinal.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteServiceImpl(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Override
    public List<ClienteDto> listarTodos() {
        return clienteRepository.findAll()
                .stream()
                .map(clienteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDto buscarPorId(Long id) {
        return clienteRepository.findById(id)
                .map(clienteMapper::toDto)
                .orElse(null);
    }

    @Override
    public List<ClienteDto> buscarPorNome(String nome) {
        return clienteRepository.findByNomeContainingIgnoreCase(nome)
                .stream()
                .map(clienteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDto salvar(ClienteDto clienteDto) {
        Cliente cliente = clienteMapper.toEntity(clienteDto);
        Cliente salvo = clienteRepository.save(cliente);
        return clienteMapper.toDto(salvo);
    }

    @Override
    public ClienteDto atualizar(Long id, ClienteDto clienteDto) {
        return clienteRepository.findById(id)
                .map(existing -> {
                    existing.setNome(clienteDto.getNome());
                    existing.setEmail(clienteDto.getEmail());
                    Cliente atualizado = clienteRepository.save(existing);
                    return clienteMapper.toDto(atualizado);
                })
                .orElse(null);
    }

    @Override
    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public long contar() {
        return clienteRepository.count();
    }
}
