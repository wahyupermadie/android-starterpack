/**
 *
 * Created by Wahyu Permadi on 2020-02-20.
 * Android Engineer
 *
 **/

object ApplicationId {
    const val id = "com.godohdev.androidstarterkit"
}
object Release {
    const val versionCode = 1
    const val versionName = "1.0"
}

object Versions {
    const val minSdkVersion = 19
    const val targetSdkVersion = 29

    const val kotlinVersion = "1.3.61"

    const val appCompatVersion = "1.1.0"
    const val coreKtxVersion = "1.2.0"
    const val constraintLayoutVersion = "1.1.3"
    const val circleImageVersion = "3.1.0"
    const val shimmerVersion = "0.5.0"

    const val rxAndroid = "2.1.1"
    const val rxJavaVersion = "2.2.18"
    const val gsonVersion = "2.8.5"
    const val okHttpVersion = "4.3.1"
    const val retrofitVersion = "2.6.1"

    const val daggerVersion = "2.26"
    const val roomVersion = "2.2.3"
    const val multiDexVersion = "2.0.1"
    const val lifecycleVersion = "2.2.0"
    const val ankoVersion = "0.10.8"
    const val materialVersion = "1.0.0"

    const val espressoCoreVersion = "3.2.0"
    const val junitVersion = "4.12"
    const val junitExtVersion = "1.1.1"
    const val mockitoInlineVersion = "2.13.0"
    const val coreTestingVersion = "1.1.1"
    const val nhaarmanMockVersions = "1.5.0"

    const val glideVersion = "4.10.0"
}

object AndroidLibraries{
    const val ankoLibrary = "org.jetbrains.anko:anko:${Versions.ankoVersion}"

    const val kotlinStdlibary = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlinVersion}"
    const val appCompatLibrary = "androidx.appcompat:appcompat:${Versions.appCompatVersion}"
    const val coreKtxLibrary = "androidx.core:core-ktx:${Versions.coreKtxVersion}"
    const val constraintLayoutLibrary = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayoutVersion}"
    const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageVersion}"
    const val facebookShimmer = "com.facebook.shimmer:shimmer:${Versions.shimmerVersion}"

    const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
    const val daggerAndroid = "com.google.dagger:dagger-android:${Versions.daggerVersion}"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:${Versions.daggerVersion}"
    const val daggerAnnotation = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
    const val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.daggerVersion}"

    const val multiDexLib = "androidx.multidex:multidex:${Versions.multiDexVersion}"

    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
    const val gson = "com.google.code.gson:gson:${Versions.gsonVersion}"
    const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
    const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
    const val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttpVersion}"
    const val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofitVersion}"

    const val glide = "com.github.bumptech.glide:glide:${Versions.glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glideVersion}"

    const val roomRuntime = "android.arch.persistence.room:runtime:${Versions.roomVersion}"
    const val roomCompiler = "androidx.room:room-compiler:${Versions.roomVersion}"
    const val roomKtx = "androidx.room:room-ktx:${Versions.roomVersion}"
    const val roomtest = "androidx.room:room-testing:${Versions.roomVersion}"

    const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycleVersion}"
    const val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycleVersion}"

    const val materialLibrary = "com.google.android.material:material:${Versions.materialVersion}"
}

object TestingLibraries{
    const val jUnitLibrary = "junit:junit:${Versions.junitVersion}"
    const val jUnitExtLibrary = "androidx.test.ext:junit:${Versions.junitExtVersion}"
    const val espressoCoreLibrary = "androidx.test.espresso:espresso-core:${Versions.espressoCoreVersion}"
    const val nhaarmanMockLibrary = "com.nhaarman:mockito-kotlin:${Versions.nhaarmanMockVersions}"
    const val mockitoInlineLibrary = "org.mockito:mockito-inline:${Versions.mockitoInlineVersion}"
    const val coreTestingLibrary = "android.arch.core:core-testing:${Versions.coreTestingVersion}"
    const val mockwebserver = "com.squareup.okhttp3:mockwebserver:${Versions.okHttpVersion}"
}