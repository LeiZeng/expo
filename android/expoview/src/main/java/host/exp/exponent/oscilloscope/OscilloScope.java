package host.exp.exponent.oscilloscope;

import com.facebook.soloader.SoLoader;

// Java bindings for OscilloScope.h interface
public class OscilloScope {
  static {
    SoLoader.loadLibrary("exponent");
  }

  public static native String getOscilloscopeServer(String host, String port);
}
