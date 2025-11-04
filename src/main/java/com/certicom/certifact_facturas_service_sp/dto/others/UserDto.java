package com.certicom.certifact_facturas_service_sp.dto.others;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long idUser;
    private Integer idOficina;
    private String nombreUsuario;
    private String contrasena;
    private String nombreCompleto;
    private String dni;
    private String estado;
    private Boolean activo;
    private String ruc;

}
