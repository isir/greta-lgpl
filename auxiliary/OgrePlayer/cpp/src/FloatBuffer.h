/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class vib_auxiliary_player_ogre_natives_FloatBuffer */

#ifndef _Included_vib_auxiliary_player_ogre_natives_FloatBuffer
#define _Included_vib_auxiliary_player_ogre_natives_FloatBuffer
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     vib_auxiliary_player_ogre_natives_FloatBuffer
 * Method:    _instanciate
 * Signature: (I)J
 */
JNIEXPORT jlong JNICALL Java_vib_auxiliary_player_ogre_natives_FloatBuffer__1instanciate
  (JNIEnv *, jclass, jint);

/*
 * Class:     vib_auxiliary_player_ogre_natives_FloatBuffer
 * Method:    _updateJavaBuffer
 * Signature: (J[FI)V
 */
JNIEXPORT void JNICALL Java_vib_auxiliary_player_ogre_natives_FloatBuffer__1updateJavaBuffer
  (JNIEnv *, jclass, jlong, jfloatArray, jint);

/*
 * Class:     vib_auxiliary_player_ogre_natives_FloatBuffer
 * Method:    _setIndex
 * Signature: (JIF)V
 */
JNIEXPORT void JNICALL Java_vib_auxiliary_player_ogre_natives_FloatBuffer__1setIndex
  (JNIEnv *, jobject, jlong, jint, jfloat);

/*
 * Class:     vib_auxiliary_player_ogre_natives_FloatBuffer
 * Method:    delete
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_vib_auxiliary_player_ogre_natives_FloatBuffer_delete
  (JNIEnv *, jobject, jlong);

#ifdef __cplusplus
}
#endif
#endif