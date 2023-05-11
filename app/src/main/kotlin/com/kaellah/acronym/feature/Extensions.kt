package com.kaellah.acronym.feature


/**
 * Invokes appropriate code when it matches appropriate condition
 *
 * @param onRelease called when build is for end users
 * @param onDebug called when build is for developers
 */
@Suppress("KotlinConstantConditions")
inline fun whenBuildType(
    onRelease: () -> Unit,
    onDebug: () -> Unit,
) {
    when (BuildConfig.BUILD_TYPE) {
        "debug" -> onDebug()
        "release" -> onRelease()
    }
}
