package com.douglas.desafiofinal.mapper;

import com.douglas.desafiofinal.dto.ClienteDto;
import com.douglas.desafiofinal.model.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteDto toDto(Cliente cliente) {
        if (cliente == null) {
            return null;
        }
        return ClienteDto.builder()
                .id(cliente.getId())
                .nome(cliente.getNome())
                .email(cliente.getEmail())
                .build();
    }

    public Cliente toEntity(ClienteDto dto) {
        if (dto == null) {
            return null;
        }
        return Cliente.builder()
                .id(dto.getId())
                .nome(dto.getNome())
                .email(dto.getEmail())
                .build();
    }
}
