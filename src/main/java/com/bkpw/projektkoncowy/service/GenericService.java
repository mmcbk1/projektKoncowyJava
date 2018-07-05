package com.bkpw.projektkoncowy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface GenericService<T> {


    T create(T t);

    T getOne(Long id);

    Page<T> getAll(Pageable pageable);

    void delete(Long id);

    T update(T t, Long id, BindingResult bindingResult);

}
