package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.mapper.DetailsDocsVoidedMapper;
import com.certicom.certifact_facturas_service_sp.mapper.VoidedDocumentsMapper;
import com.certicom.certifact_facturas_service_sp.mapper.VoidedFileMapper;
import com.certicom.certifact_facturas_service_sp.model.VoidedDocuments;
import com.certicom.certifact_facturas_service_sp.service.VoidedDocumentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class VoidedDocumentsServiceImpl implements VoidedDocumentsService {

    private final VoidedDocumentsMapper voidedDocumentsMapper;
    private final DetailsDocsVoidedMapper detailsDocsVoidedMapper;
    private final VoidedFileMapper voidedFileMapper;

    @Override
    public Integer getCorrelativoGeneracionByDiaInVoidedDocuments(String ruc, String fechaGeneracionBaja) {
        return voidedDocumentsMapper.getCorrelativoGeneracionByDiaInVoidedDocuments(ruc, fechaGeneracionBaja);
    }

    @Transactional
    @Override
    public VoidedDocuments save(VoidedDocuments voidedDocuments) {

        int result;
        if(voidedDocuments.getIdDocumentVoided()!=null) {
            result = voidedDocumentsMapper.update(voidedDocuments);
        } else {
            result = voidedDocumentsMapper.save(voidedDocuments);
        }
        if(result == 0) {
            throw new RuntimeException("No se pudo registrar el comprobante");
        }
        System.out.println("ID CREATED: "+voidedDocuments.getIdDocumentVoided());
        for (int i=0; i<voidedDocuments.getDetailBajaDocumentos().size(); i++) {
            voidedDocuments.getDetailBajaDocumentos().get(i).setIdDocsVoided(voidedDocuments.getIdDocumentVoided());
            result = detailsDocsVoidedMapper.save(voidedDocuments.getDetailBajaDocumentos().get(i));
            if(result==0) {
                throw new RuntimeException("No se pudo registrar el voided document");
            }
        }

        for (int i=0; i<voidedDocuments.getVoidedFiles().size(); i++) {
            System.out.println("VOIDED FILE"+ voidedDocuments.getVoidedFiles().get(i));
            voidedDocuments.getVoidedFiles().get(i).setIdDocumentVoided(voidedDocuments.getIdDocumentVoided());
            result = voidedFileMapper.save(voidedDocuments.getVoidedFiles().get(i));
            if (result == 0) {
                throw new RuntimeException("No se pudo registrar el voided file");
            }
        }

        VoidedDocuments voided = voidedDocumentsMapper.findVoidedDocumentsById(voidedDocuments.getIdDocumentVoided());
        System.out.println("VOIDED: "+voided);
        if(voided == null) {
            throw new RuntimeException("Error al obtener documento anulado");
        }
        return voided;
    }

}
