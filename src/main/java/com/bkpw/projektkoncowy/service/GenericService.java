package com.bkpw.projektkoncowy.service;

import java.util.List;

public interface GenericService<T> {


    T create(T t);

    T getOne(Long id);

    List<T> getAll();

    void delete(Long id);

    T update(T t,Long id);

}
