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

import java.util.Locale;

import org.testng.annotations.Test;

import com.google.inject.AbstractModule;
import com.google.inject.Inject;
import com.google.inject.Module;
import com.google.inject.name.Named;
import com.google.inject.name.Names;

/**
 * 
 *
 * @version $Id$
 */
public final class LocaleConverterTestCase extends AbstractTestCase<Locale> {

    @Override
    @Inject
    public void setConvertedField(@Named("locale") Locale convertedField) {
        super.setConvertedField(convertedField);
    }

    @Override
    protected Module[] getModules() {
        return new Module[] { new LocaleConverter(), new AbstractModule() {
            protected void configure() {
                this.bindConstant()
                    .annotatedWith(Names.named("locale"))
                    .to("en_US");
            };
        } };
    }

    @Test
    public void locale() {
        this.verifyConversion(new Locale("en", "US"));
    }

}
