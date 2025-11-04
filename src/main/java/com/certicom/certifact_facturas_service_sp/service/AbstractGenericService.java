package com.certicom.certifact_facturas_service_sp.service;

import com.certicom.certifact_facturas_service_sp.enums.LogTitle;
import com.certicom.certifact_facturas_service_sp.exceptions.ServiceException;
import com.certicom.certifact_facturas_service_sp.mapper.BaseMapper;
import com.certicom.certifact_facturas_service_sp.util.LogHelper;
import com.certicom.certifact_facturas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import org.springframework.dao.DataAccessException;

import java.util.Optional;

public abstract class AbstractGenericService<T, ID, M extends BaseMapper<T, ID>> implements GenericService<T, ID> {

    protected final M mapper;

    protected AbstractGenericService(M mapper) {
        this.mapper = mapper;
    }

    @Override
    public Optional<T> findById(ID id) {
        if(id == null) {
            LogHelper.warnLog(LogTitle.WARN_VALIDATION.getType(), LogMessages.currentMethod(), "parametro id es nulo");
            throw new ServiceException(String.format("%s: el id no puede ser nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            T entity = mapper.findById(id);
            if(entity == null) {
                LogHelper.warnLog(LogTitle.WARN_NOT_RESULT.getType(), LogMessages.currentMethod(), "variable entity es nulo");
            } else {
                LogHelper.infoLog(LogTitle.INFO.getType(), LogMessages.currentMethod(), "La consulta se realizo exitosamente");
            }
            return Optional.ofNullable(entity);
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogTitle.ERROR_DATABASE.getType(), LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogTitle.ERROR_UNEXPECTED.getType(), LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

}
