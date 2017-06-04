/**
 * Copyright (c) 2015-present, Peel Technologies, Inc.
 * All rights reserved.
 */

package abi16_0_0.host.exp.exponent.modules.api.components.oscilloscope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import abi16_0_0.com.facebook.react.ReactPackage;
import abi16_0_0.com.facebook.react.bridge.JavaScriptModule;
import abi16_0_0.com.facebook.react.bridge.NativeModule;
import abi16_0_0.com.facebook.react.bridge.ReactApplicationContext;
import abi16_0_0.com.facebook.react.uimanager.ViewManager;


public final class OscilloScopePackage implements ReactPackage {

    @Override
    public List<NativeModule> createNativeModules(
            ReactApplicationContext reactContext) {
        List<NativeModule> modules = new ArrayList<NativeModule>();

        modules.add(new OscilloScope(reactContext));

        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return Collections.emptyList();
    }

    @Override
    public List<ViewManager> createViewManagers(
            ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
