package com.certicom.certifact_facturas_service_sp.mapper;

import com.certicom.certifact_facturas_service_sp.model.UserModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.PathVariable;

@Mapper
public interface UserMapper extends BaseMapper<UserModel, Long> {

    UserModel findByUsername(@PathVariable("username") String username);
    String findUsernameById(@PathVariable("id") Long idUsuario);

}
