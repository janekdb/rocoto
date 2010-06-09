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
package com.googlecode.rocoto.system;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.googlecode.rocoto.system.SystemPropertiesModule;
import com.googlecode.rocoto.system.SystemProperty;

/**
 * 
 *
 * @author Simone Tripodi
 * @version $Id$
 */
public final class SystemPropertiesModuleTestCase {

    @Inject
    @SystemProperty("user.home")
    private String home;

    public void setHome(String home) {
        this.home = home;
    }

    @BeforeTest
    public void setUp() {
        Injector injector = Guice.createInjector(new SystemPropertiesModule());
        injector.injectMembers(this);
    }

    @Test
    public void verifyNotNullJavaHome() {
        assert this.home != null;
    }

}
