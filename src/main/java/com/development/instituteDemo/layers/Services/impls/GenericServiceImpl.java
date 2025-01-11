package com.development.instituteDemo.layers.Services.impls;

import com.development.instituteDemo.layers.Services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class GenericServiceImpl<TDTO, ID> implements BaseService<TDTO, ID> {
    private JpaRepository<T, ID> jpaRepository;

    public GenericServiceImpl(JpaRepository<T, ID> jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public T save(T entity) {
        return jpaRepository.save(entity);
    }

    @Override
    public Optional<T> findById(ID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public T update(ID id, T entity) {
        Optional<T> foundT = jpaRepository.findById(id);
        if (!jpaRepository.existsById(id)) {
            throw new IllegalArgumentException("Entity with id:" + id + " does not exist.");
        }
        return jpaRepository.save(entity);
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }
}
