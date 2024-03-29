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
package com.googlecode.rocoto.configuration.readers;

import java.util.Iterator;
import java.util.Map.Entry;

import com.googlecode.rocoto.configuration.ConfigurationReader;

/**
 * Environment variable reader.
 *
 * @author Simone Tripodi
 * @since 4.0
 * @version $Id$
 */
public final class EnvironmentVariablesReader implements ConfigurationReader {

    /**
     * The environment variable prefix, {@code env.}
     */
    private static final String ENV_PREFIX = "env.";

    /**
     * {@inheritDoc}
     */
    public Iterator<Entry<String, String>> readConfiguration() throws Exception {
        return PropertiesIterator.createNew(ENV_PREFIX, System.getenv());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "System.env";
    }

}
