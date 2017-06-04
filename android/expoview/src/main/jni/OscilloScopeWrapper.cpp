#include <string.h>
#include <jni.h>
#include "OscilloScope.h"

extern "C" {

JNIEXPORT jstring JNICALL
Java_host_exp_exponent_oscilloscope_OscilloScope_getOscilloscopeServer
(JNIEnv* env, jobject thiz, jstring ip, jstring port) {
    return (env)->NewStringUTF(getOscilloscopeServer(
      env->GetStringUTFChars(ip, JNI_FALSE),
      env->GetStringUTFChars(port, JNI_FALSE)
    ));
}

}
