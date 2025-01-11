package com.development.instituteDemo.layers.validators;

public interface Validator<T> {
    void validateFields(T entity);
    default void additionalAccess(String accessType, Long validationKey, Long validationReference) {
        throw new RuntimeException("No such access type is defined!");
    }
}
