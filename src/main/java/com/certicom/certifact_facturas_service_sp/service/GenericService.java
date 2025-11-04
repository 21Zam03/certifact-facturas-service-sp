package com.certicom.certifact_facturas_service_sp.service;

import java.util.Optional;

public interface GenericService<T, ID> {

    Optional<T> findById(ID id);

}
