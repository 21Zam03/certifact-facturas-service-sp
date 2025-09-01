package com.certicom.certifact_facturas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterFileUpload {

    private Long idRegisterFileSend;
    private String extension;
    private Timestamp fechaUpload;
    private String bucket;
    private String nombreOriginal;
    private String nombreGenerado;
    private String rucCompany;
    private String tipoArchivo;
    private String usuarioUpload;
    private String uuid;
    private Integer codCompany;
    private String estado;
    private Timestamp fechaModificacion;
    private String userNameModify;
    private Boolean isOld;

}
