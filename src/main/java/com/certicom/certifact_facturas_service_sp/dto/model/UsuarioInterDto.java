package com.certicom.certifact_facturas_service_sp.dto.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UsuarioInterDto {

    private Long idUsuario;
    private Integer idOficina;
    private String nombreUsuario;
    private String contrasena;
    private String nombreCompleto;
    private String dni;
    private String estado;
    private Boolean activo;
    private String ruc;

}
