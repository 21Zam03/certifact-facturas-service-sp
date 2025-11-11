package com.certicom.certifact_facturas_service_sp.service.impl;

import com.certicom.certifact_facturas_service_sp.converter.UserConverter;
import com.certicom.certifact_facturas_service_sp.dto.others.UserDto;
import com.certicom.certifact_facturas_service_sp.enums.LogTitle;
import com.certicom.certifact_facturas_service_sp.exceptions.ServiceException;
import com.certicom.certifact_facturas_service_sp.mapper.UserMapper;
import com.certicom.certifact_facturas_service_sp.model.UserModel;
import com.certicom.certifact_facturas_service_sp.service.AbstractGenericService;
import com.certicom.certifact_facturas_service_sp.service.UsuarioService;
import com.certicom.certifact_facturas_service_sp.util.LogHelper;
import com.certicom.certifact_facturas_service_sp.util.LogMessages;
import jakarta.persistence.PersistenceException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UsuarioServiceImpl extends AbstractGenericService<UserModel, Long, UserMapper>
        implements UsuarioService {

    protected UsuarioServiceImpl(UserMapper mapper) {
        super(mapper);
    }

    @Override
    public UserDto findUserById(Long idUsuario) {
        UserModel userModel = findById(idUsuario).orElseThrow(() -> new ServiceException("No se encontro usuario con id: "+idUsuario));
        return UserConverter.modelToDto(userModel);
    }

    @Override
    public UserDto findUserByUsername(String username) {
        if(username == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "El parametro username es nulo");
            throw new ServiceException(String.format("%s: el username es nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            UserModel user = mapper.findByUsername(username);
            if(user == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "La variable user es nulo");
                return null;
            } else {
                UserDto userDto = UserConverter.modelToDto(user);
                LogHelper.infoLog(LogMessages.currentMethod(), "La consulta se realizo exitosamente, idUser:"+user.getIdUser());
                return userDto;
            }
        } catch (DataAccessException | PersistenceException e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error en la base de datos", e);
            throw new ServiceException(LogMessages.ERROR_DATABASE, e);
        }
        catch (Exception e) {
            LogHelper.errorLog(LogMessages.currentMethod(), "Ocurrio un error inesperado", e);
            throw new ServiceException(LogMessages.ERROR_UNEXPECTED, e);
        }
    }

    @Override
    public String findUsernameById(Long idUsuario) {
        if(idUsuario == null) {
            LogHelper.warnLog(LogMessages.currentMethod(), "El parametro idUsuario es nulo");
            throw new ServiceException(String.format("%s: el id es nulo", LogMessages.ERROR_VALIDATION));
        }
        try {
            String username = mapper.findUsernameById(idUsuario);
            if(username == null) {
                LogHelper.warnLog(LogMessages.currentMethod(), "La variable username es nulo");
                return null;
            } else {
                LogHelper.infoLog(LogMessages.currentMethod(), "La consulta se realizo exitosamente, username:"+username);
                return username;
            }
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
