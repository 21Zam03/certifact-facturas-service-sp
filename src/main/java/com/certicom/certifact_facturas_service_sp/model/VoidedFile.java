package com.certicom.certifact_facturas_service_sp.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
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
