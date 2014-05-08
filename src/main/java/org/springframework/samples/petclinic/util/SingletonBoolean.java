/* **********************************************************************
 * Copyright 2013 VMware, Inc. All rights reserved. VMware Confidential
 * **********************************************************************
 */

package org.springframework.samples.petclinic.util;

/**
 * @author akanchev
 */
public class SingletonBoolean {

    private boolean isSetUp = false;
    private static final SingletonBoolean INSTANCE = new SingletonBoolean();

    public static SingletonBoolean getInstance() {
        return INSTANCE;
    }

    public boolean getIsSetUp() {
        return this.isSetUp;
    }

    public void setUp() {
        if (!isSetUp) {
            this.isSetUp = true;
        }
    }

    private SingletonBoolean() {

    }
}
