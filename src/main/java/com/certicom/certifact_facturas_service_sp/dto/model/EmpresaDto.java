package com.certicom.certifact_facturas_service_sp.dto.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class EmpresaDto {

    private Integer Id;

    private String ruc;
    private Boolean viewCode;
    private String razon;
    private String email;
    private String telefono;
    private String cadena;
    private Boolean rubroHoreal;
    private String nombreComer;
    private String ublVersion;
    private Integer oseId;
    private String bucket;
    private Boolean envioAutomaticoSunat;
    private Boolean envioAutomaticoGuia;
    private Boolean envioAutomaticoReteperse;
    private Boolean envioDirecto;
    private String direccion;
    private Boolean simultaneo;
    private Boolean allowSaveOficina;
    private Integer cantComproDina;
    private BigDecimal idRegisterFileSend;
    private Integer format;

}
