#include <string>
#include <android/log.h>
#include <android_native_app_glue.h>

using std::string;

const string TAG = "nativeactivity";

/**
 * This is the main entry point of a native application that is using
 * android_native_app_glue.  It runs in its own thread, with its own
 * event loop for receiving input events and doing other things.
 */
void android_main(struct android_app* state)
{
    __android_log_print(ANDROID_LOG_INFO, TAG.c_str(), "Hello NDK!");
}
