# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.
set(distribution_DIR ${CMAKE_SOURCE_DIR}/../../../../libs)
add_library( # Sets the name of the library.
             decoder-lib

             # Sets the library as a shared library.
             SHARED

             # Provides a relative path to your source file(s).
             src/main/cpp/native-lib.cpp )
add_library( # Sets the name of the library.
             avcodec-56

             # Sets the library as a shared library.
             SHARED

             IMPORTED)
set_target_properties(
             avcodec-56
             PROPERTIES IMPORTED_LOCATION
             ../../../../imported_libs/armeabi/libavcodec-56.so)

add_library( # Sets the name of the library.
             avdevice-56

             # Sets the library as a shared library.
             SHARED

             IMPORTED)
set_target_properties(
             avdevice-56
             PROPERTIES IMPORTED_LOCATION
             ../../../../imported_libs/armeabi/libavdevice-56.so)
add_library( # Sets the name of the library.
             avfilter-5
             # Sets the library as a shared library.
             SHARED
             IMPORTED)
set_target_properties(
             avfilter-5
             PROPERTIES IMPORTED_LOCATION
             ../../../../imported_libs/armeabi/libavfilter-5.so)

add_library( # Sets the name of the library.
             avformat-56
             # Sets the library as a shared library.
             SHARED
             IMPORTED)
set_target_properties(
             avformat-56
             PROPERTIES IMPORTED_LOCATION
             ../../../../imported_libs/armeabi/libavformat-56.so)

add_library( # Sets the name of the library.
             avutil-54
             # Sets the library as a shared library.
             SHARED
             IMPORTED)
set_target_properties(
             avutil-54
             PROPERTIES IMPORTED_LOCATION
             ../../../../imported_libs/armeabi/libavutil-54.so)

add_library( # Sets the name of the library.
             postproc-53
             # Sets the library as a shared library.
             SHARED
             IMPORTED)
set_target_properties(
             postproc-53
             PROPERTIES IMPORTED_LOCATION
             ../../../../imported_libs/armeabi/libpostproc-53.so)

add_library( # Sets the name of the library.
             swresample-1
             # Sets the library as a shared library.
             SHARED
             IMPORTED)
set_target_properties(
             swresample-1
             PROPERTIES IMPORTED_LOCATION
             ../../../../imported_libs/armeabi/libswresample-1.so)

add_library( # Sets the name of the library.
             swscale-3
             # Sets the library as a shared library.
             SHARED
             IMPORTED)
set_target_properties(
             swscale-3
             PROPERTIES IMPORTED_LOCATION
             ../../../../imported_libs/armeabi/libswscale-3.so)

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
              log-lib

              # Specifies the name of the NDK library that
              # you want CMake to locate.
              log )
include_directories(imported_libs/include)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
                       decoder-lib avcodec-56 avdevice-56 avfilter-5 avformat-56 avutil-54 postproc-53 swresample-1 swscale-3
                        # Links the target library to the log library
                       # included in the NDK.
                       ${log-lib}  )