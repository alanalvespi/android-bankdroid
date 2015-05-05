package com.liato.bankdroid.banking;
import com.liato.bankdroid.api.configuration.Field;
import com.liato.bankdroid.api.configuration.FieldBuilder;
import com.liato.bankdroid.api.configuration.ProviderConfiguration;
import com.liato.bankdroid.utils.FieldTypeMapper;

import java.util.HashMap;
import java.util.Map;

public class LegacyProviderConfiguration implements ProviderConfiguration {

    public static final String USERNAME = "legacy.username";

    public static final String PASSWORD = "legacy.password";

    public static final String EXTRAS = "legacy.extras";

    private Map<String, Field> mConfiguration;

    private Bank mLegacyBank;

    public LegacyProviderConfiguration(Bank legacyBank) {
        mLegacyBank = legacyBank;
    }

    @Override
    public Map<String, Field> getConfiguration() {
        if (mConfiguration == null) {
            mConfiguration = createConfiguration();
        }
        return mConfiguration;
    }

    private Map<String, Field> createConfiguration() {
        Map<String, Field> configuration = new HashMap<>();
        configuration.put(USERNAME, new FieldBuilder(USERNAME)
                .label(mLegacyBank.getContext().getString(mLegacyBank.getInputTitleUsername()))
                .placeholder(mLegacyBank.getInputHintUsername())
                .hidden(mLegacyBank.isInputUsernameHidden())
                .required(true)
                .fieldType(FieldTypeMapper.toFieldType(mLegacyBank.getInputTypeUsername()))
                .build());

        configuration.put(PASSWORD, new FieldBuilder(PASSWORD)
                .label(mLegacyBank.getContext().getString(mLegacyBank.getInputTitlePassword()))
                .hidden(mLegacyBank.isInputPasswordHidden())
                .encrypted(true)
                .required(true)
                .fieldType(FieldTypeMapper.toFieldType(mLegacyBank.getInputTypePassword()))
                .build());

        configuration.put(EXTRAS, new FieldBuilder(EXTRAS)
                .label(mLegacyBank.getContext().getString(mLegacyBank.getInputTitleExtras()))
                .hidden(mLegacyBank.isInputExtrasHidden())
                .fieldType(FieldTypeMapper.toFieldType(mLegacyBank.getInputTypeExtras()))
                .build());

        return configuration;
    }
}