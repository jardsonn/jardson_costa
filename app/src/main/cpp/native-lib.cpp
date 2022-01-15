#include <jni.h>
#include <string>

extern "C" JNIEXPORT jstring JNICALL
Java_com_jcsapps_jardson_1costa_ui_MainActivity_calcular(
        JNIEnv *env,
        jobject,
        int value) {
    std::string sum = std::to_string(value + 5);
    return env->NewStringUTF(sum.c_str());
}