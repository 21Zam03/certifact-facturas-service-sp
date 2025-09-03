package com.certicom.certifact_facturas_service_sp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailsDocsVoided {

    private Long idDetailDocsSummary;
    private Integer numeroItem;
    private String serieDocumento;
    private Integer numeroDocumento;
    private String tipoComprobante;
    private String motivoBaja;
    private String estado;
    private Long idDocsVoided;

    private VoidedDocuments voidedDocument;

}
