package com.example.demo.service.base;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBaseService<ENTITY, PK> {

    List<ENTITY> findAll();
    Page<ENTITY> findAll(Pageable pageable);
    ENTITY findById(PK id);
    ENTITY save(ENTITY data);
    List<ENTITY> saveAll(List<ENTITY> list);
    void deleteById(PK id);
    void deleteInBatch(List<ENTITY> objects);

}
