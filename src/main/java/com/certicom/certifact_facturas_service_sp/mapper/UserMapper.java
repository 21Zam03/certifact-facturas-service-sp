package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface UserMapper {

    User findUserById(@PathVariable("idUsuario") Long idUsuario);
    User findUserByUsername(@PathVariable("username") String username);

}
