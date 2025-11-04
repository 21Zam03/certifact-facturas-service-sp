package com.certicom.certifact_facturas_service_sp.mapper;

import java.util.List;

public interface BaseMapper<T, ID>  {

    int insert(T entity);
    int update(T entity);
    int deleteById(ID id);
    T findById(ID id);
    List<T> findAll();
    int updateAll(List<T> list);
    int deleteAll(List<T> list);
    int insertAll(List<T> list);

}
