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

import java.util.BitSet;
import java.util.StringTokenizer;

import com.google.inject.TypeLiteral;
import com.google.inject.spi.TypeConverter;

/**
 * Converter implementation for {@code java.util.UUID}.
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public final class BitSetConverter implements TypeConverter {

    private static final String DEFAULT_SEPARATOR = ",";

    private static final int CHAR_LENGTH = 1;

    /**
     * {@inheritDoc}
     */
    public Object convert(String value, TypeLiteral<?> toType) {
        BitSet bitSet = new BitSet();

        int currentIndex = 0;
        StringTokenizer tokenizer = new StringTokenizer(value, DEFAULT_SEPARATOR);
        while (tokenizer.hasMoreTokens()) {
            String current = tokenizer.nextToken().trim();

            if (current.length() == 0) {
                throw new RuntimeException("Input '"
                        + value
                        + "' is not a valid java.util.BitSet, fragment at position "
                        + currentIndex
                        + " is empty");
            }

            if (CHAR_LENGTH == current.length() && !Character.isDigit(current.charAt(0))) {
                bitSet.set(current.charAt(0));
            } else {
                for (int i = 0; i < current.length(); i++) {
                    if (!Character.isDigit(current.charAt(i))) {
                        throw new RuntimeException("Input '"
                                + value
                                + "' is not a valid java.util.BitSet, fragment '"
                                + current
                                + "' at position "
                                + currentIndex
                                + " is not a valid integer");
                    }
                }
                bitSet.set(Integer.parseInt(current));
            }

            currentIndex++;
        }

        return bitSet;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "TypeConverter<java.util.BitSet>";
    }

}