package com.liato.bankdroid.banking;

import com.liato.bankdroid.api.configuration.Field;
import com.liato.bankdroid.api.configuration.FieldBuilder;
import com.liato.bankdroid.api.configuration.FieldType;
import com.liato.bankdroid.api.configuration.ProviderConfiguration;

import java.util.HashMap;
import java.util.Map;

public class BasicProviderConfiguration implements ProviderConfiguration {

    public static final String FIELD_USERNAME = "username";
    public static final String FIELD_PASSWORD = "password";

    public static final String PROPERTY_USERNAME = "provider.default.config.label.username";
    public static final String PROPERTY_PASSWORD = "provider.default.config.label.password";
    private final Map<String, Field> mFields;

    public BasicProviderConfiguration() {
        mFields = createConfiguration();
    }

    @Override
    public Map<String, Field> getConfiguration() {
        return mFields;
    }

    private Map<String, Field> createConfiguration() {
        Map<String, Field> fields = new HashMap<>();

        fields.put(FIELD_USERNAME, new FieldBuilder(FIELD_USERNAME)
                .fieldType(FieldType.TEXT)
                .label(PROPERTY_USERNAME)
                .required(true)
                .build()
        );

        fields.put(FIELD_PASSWORD, new FieldBuilder(FIELD_PASSWORD)
                        .fieldType(FieldType.TEXT)
                        .label(PROPERTY_PASSWORD)
                        .encrypted(true)
                        .required(true)
                        .build()
        );
        return fields;
    }
}
