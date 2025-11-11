package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.exceptions.ServiceException;
import com.certicom.certifact_facturas_service_sp.model.PaymentVoucherFileModel;
import com.certicom.certifact_facturas_service_sp.mapper.PaymentVoucherFileMapper;
import com.certicom.certifact_facturas_service_sp.service.PaymentVoucherFileService;
import com.certicom.certifact_facturas_service_sp.util.LogHelper;
import com.certicom.certifact_facturas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentVoucherFileServiceImpl implements PaymentVoucherFileService {

    private final PaymentVoucherFileMapper paymentVoucherFileMapper;

    @Override
    public int save(PaymentVoucherFileModel paymentVoucherFileModel) {
        return paymentVoucherFileMapper.save(paymentVoucherFileModel);
    }

    @Override
    public Long findActiveXMLIdRegisterFileSendByIdPaymentVoucher(Long id) {
        if(id == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "El parametro id es nulo");
            throw new ServiceException("El parametro id es nulo");
        }
        try {
            Long idRegisterFileSend =paymentVoucherFileMapper.findActiveXMLIdRegisterFileSendByIdPaymentVoucher(id);
            if(idRegisterFileSend == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "Variable idRegisterFileSend es nulo");
            } else {
                LogHelper.infoLog(LogMessages.currentMethod(), "La consulta se realizo exitosamente");
            }
            return idRegisterFileSend;
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }


}
