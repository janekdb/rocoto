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
package com.rocoto.simpleconfig;

import java.util.regex.Pattern;

/**
 * 
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public final class DefaultPropertiesFileFilter extends AbstractPropertiesFileFilter {

    private static final Pattern PROPERTIES_PATTERN = Pattern.compile(".*\\.properties", Pattern.CASE_INSENSITIVE);

    private static final Pattern XML_PROPERTIES_PATTERN = Pattern.compile(".*\\.xml", Pattern.CASE_INSENSITIVE);

    public DefaultPropertiesFileFilter() {
        super(PROPERTIES_PATTERN, XML_PROPERTIES_PATTERN);
    }

}
