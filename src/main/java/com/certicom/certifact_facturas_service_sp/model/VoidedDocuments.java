package com.certicom.certifact_facturas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VoidedDocuments {

    private Long idDocumentVoided;
    private Integer correlativoGeneracionDia;
    private String estado;
    private String fechaBajaDocs;
    private String fechaGeneracionBaja;
    private String idDocument;
    private String rucEmisor;
    private String ticketSunat;
    private String codigoRespuesta;
    private String descripcionRespuesta;
    private Timestamp fechaGeneracionResumen;
    private Timestamp fechaModificacion;
    private String userName;
    private String userNameModify;
    private String estadoComprobante;
    private Integer intentosGetStatus;

    private List<DetailsDocsVoided> detailBajaDocumentos;
    private List<VoidedFile> voidedFiles;

}
