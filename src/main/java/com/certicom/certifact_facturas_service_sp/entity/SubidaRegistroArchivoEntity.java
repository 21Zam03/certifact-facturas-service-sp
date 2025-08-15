package com.certicom.certifact_facturas_service_sp.entity;

import lombok.*;

import java.sql.Timestamp;

/*table= register_file_upload*/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class SubidaRegistroArchivoEntity {

    private static final long serialVersionUID = 1L;

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
