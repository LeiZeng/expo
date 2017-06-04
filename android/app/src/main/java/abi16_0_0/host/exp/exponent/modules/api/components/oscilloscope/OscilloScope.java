package abi16_0_0.host.exp.exponent.modules.api.components.oscilloscope;

import android.support.annotation.Nullable;

import abi16_0_0.com.facebook.react.bridge.Callback;
import abi16_0_0.com.facebook.react.bridge.ReactApplicationContext;
import abi16_0_0.com.facebook.react.bridge.ReactContextBaseJavaModule;
import abi16_0_0.com.facebook.react.bridge.ReactMethod;

import static host.exp.exponent.oscilloscope.OscilloScope.*;

/**
 * The NativeModule acting as an api layer for {@link OscilloScope}
 */
public final class OscilloScope extends ReactContextBaseJavaModule {
    private static final String TAG = "OscilloScope";

    public OscilloScope(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return TAG;
    }

    @ReactMethod
    public void serverInfo(Callback callback) {
        callback.invoke("my native module");
    }

    @ReactMethod
    public void serverNative(String host, String port, Callback callback) {
        try {
            String ServerInfoFromNative = getOscilloscopeServer(host, port);
            callback.invoke(ServerInfoFromNative);
        } catch (Exception e) {
            callback.invoke(e.toString());
        }
    }
}
