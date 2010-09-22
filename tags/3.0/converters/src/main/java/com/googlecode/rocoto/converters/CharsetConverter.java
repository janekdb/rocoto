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
package com.googlecode.rocoto.converters;

import java.nio.charset.Charset;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeConverter;

/**
 * Converter implementation for {@code java.nio.charset.Charset}.
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public final class CharsetConverter implements TypeConverter {

    /**
     * {@inheritDoc}
     */
    public Object convert(String value, TypeLiteral<?> toType) {
        if (value.length() == 0) {
            throw new IllegalArgumentException("Impossible to convert an empty value to a Charset");
        }
        return Charset.forName(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TypeConverter<java.nio.charset.Charset>";
    }

}