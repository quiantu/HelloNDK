#include <jni.h>
#include <string>

extern "C"
{
JNIEXPORT jstring JNICALL
Java_com_example_hh_myapplication_MainActivity_stringFromJNI2(JNIEnv *env, jobject instance,
                                                              jstring obcc_) {
    const char *obcc = env->GetStringUTFChars(obcc_, 0);

    // TODO
    env->ReleaseStringUTFChars(obcc_, obcc);
    const char *returnValue;
    return env->NewStringUTF(returnValue);
}
JNIEXPORT jstring JNICALL
Java_com_example_hh_myapplication_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
}
