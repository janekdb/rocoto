/*
 *    Copyright 2009-2010 The Rocoto Team
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.google.code.rocoto.converters;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Properties;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeConverter;

/**
 * Converter implementation for {@code java.util.Properties}.
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public final class PropertiesConverter implements TypeConverter {

    /**
     * Default properties encoding {@code ISO-8859-1}.
     *
     * Properties.load(stream) expects it.
     */
    private static final String PROPERTIES_ENCODING = "ISO-8859-1";

    /**
     * {@inheritDoc}
     */
    public Object convert(String value, TypeLiteral<?> toType) {
        Properties properties = new Properties();

        try {
            properties.load(new ByteArrayInputStream(value.getBytes(PROPERTIES_ENCODING)));
        } catch (IOException e) {
            // Should never happen.
            throw new IllegalArgumentException("Failed to parse "
                    + value
                    + "' into Properties", e);
        }

        return properties;
    }

    @Override
    public String toString() {
        return "TypeConverter<java.util.Properties>";
    }

}
