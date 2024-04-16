cmake_minimum_required(VERSION 3.4.1)
#project(pdfplugin)

message(WARNING "Looking for native_app_glue in ${ANDROID_NDK}/sources/android/native_app_glue/android_native_app_glue.c")

set(${CMAKE_C_FLAGS}, "${CMAKE_C_FLAGS}")
add_library(native_app_glue STATIC
        ${ANDROID_NDK}/sources/android/native_app_glue/android_native_app_glue.c)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=gnu++11 -Wall -Werror")

# Include header files
include_directories(include)

set(PDFIUM_LIB_PATH "libs/${CMAKE_ANDROID_ARCH_ABI}")

# Link with the required libraries
find_library(PDFIUM_LIB NAMES pdfium libpdfium libpdfium.cr pdfium.cr PATHS ${PDFIUM_LIB_PATH} NO_DEFAULT_PATH)

set(CMAKE_SHARED_LINKER_FLAGS
        "${CMAKE_SHARED_LINKER_FLAGS} -u ANativeActivity_onCreate")

add_library(native-activity SHARED main.cpp)

target_include_directories(native-activity PRIVATE
        ${ANDROID_NDK}/sources/android/native_app_glue)

target_link_libraries(native-activity
        android
        native_app_glue
        EGL
        GLESv1_CM
        log)
