package com.liato.bankdroid.api.configuration;

public interface FieldValidator {

    void validate(String field) throws IllegalArgumentException;

}
