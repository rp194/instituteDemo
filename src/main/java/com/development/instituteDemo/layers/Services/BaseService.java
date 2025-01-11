package com.development.instituteDemo.layers.Services;

import java.util.List;
import java.util.Optional;

public interface BaseService <TDTO, ID> {
    private Mappe
    TDTO save(TDTO entity);
    Optional<TDTO> findById(ID id);
    List<TDTO> findAll();
    TDTO update(ID id, TDTO entity);
    void deleteById(ID id);

}
