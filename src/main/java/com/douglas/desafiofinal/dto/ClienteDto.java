package com.douglas.desafiofinal.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteDto {
    private Long id;
    private String nome;
    private String email;
}