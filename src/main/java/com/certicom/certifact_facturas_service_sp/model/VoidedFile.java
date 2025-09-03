package com.certicom.certifact_facturas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoidedFile {

    private Long id;
    private String tipoArchivo;
    private String estadoArchivo;
    private Integer orden;
    private Long idRegisterFileSend;
    private Long idDocumentVoided;

    private RegisterFileUpload registerFileUpload;
    private VoidedDocuments voidedDocument;

}
