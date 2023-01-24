import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.project
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

object appConfig {
    const val compileSdkVersion = 33
    const val buildToolsVersion = "33"

    const val applicationId = "com.example.mangaread"
    const val minSdkVersion = 21
    const val targetSdkVersion = 33

    private const val MAJOR = 1
    private const val MINOR = 0
    private const val PATCH = 0
    const val versionCode = MAJOR * 10000 + MINOR * 100 + PATCH
    const val versionName = "$MAJOR.$MINOR.$PATCH"
}

object deps {

    object androidx {
        /** Доступ к компонуемым API, созданным поверх Activity.
         * Предоставляет базовый подкласс Activity
         * и соответствующие хуки(крючки) для создания компонуемой(составной) структуры поверх него.**/
        const val activity = "androidx.activity:activity:1.4.0@aar"

        /**
        Основная идея AppCompat в том, чтобы на старых устройствах поддерживать фичи введенные в более свежих API **/
        const val appCompat = "androidx.appcompat:appcompat:1.6.0"

        /** Расширения Kotlin для «основного» артефакта. **/
        const val coreKtx = "androidx.core:core-ktx:1.9.0"

        /** ConstraintLayout for Android. **/
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:2.1.4"

        /**  Android Support RecyclerView. **/
        const val recyclerView = "androidx.recyclerview:recyclerview:1.2.1"

        /** Модульные и настраиваемые компоненты пользовательского интерфейса Material Design для Android **/
        const val material = "com.google.android.material:material:1.7.0"
    }

    object lifecycle {
        private const val version = "2.5.1"

        /** Компоненты, поддерживающие жизненный цикл **/
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$version"
        const val runtimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:$version"
        const val liveDataKtx = ("androidx.lifecycle:lifecycle-livedata-ktx:$version")
    }

    object squareup {
        /** Типобезопасный HTTP-клиент для Android и Java. **/
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:2.1.0"

        //перехватчик логов
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2"
    }

    object coroutines {
        /**  Coroutines support libraries for Kotlin **/
        private const val version = "1.5.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val cAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object jetpackNavigation {
        private const val version = "2.5.2"

        /** Android Navigation-Fragment **/
        const val fragmentNavigation = "androidx.navigation:navigation-fragment-ktx:$version"
        const val uiNavigation = "androidx.navigation:navigation-ui-ktx:$version"
    }

    object koin {
        private const val koin_version = "3.3.2"
        private const val koin_android_version = "3.3.2"

        // Koin Core features
        const val koinCore = "io.insert-koin:koin-core:$koin_version"

        // Koin main features for Android
        const val koinAndroid = "io.insert-koin:koin-android:$koin_android_version"

        // Navigation Graph
        const val koinNav = "io.insert-koin:koin-androidx-navigation:$koin_android_version"
    }

    object room {
        private const val room_version = "2.4.3"

        const val room = "androidx.room:room-runtime:$room_version"
        const val compiler = "androidx.room:room-compiler:$room_version"
        const val coroutinesSupport = "androidx.room:room-ktx:$room_version"
        const val common = "androidx.room:room-common:2.3.0"
    }

    /** Содержит: большая часть функциональности: коллекции, диапазоны, математика, регулярное выражение,
     *  расширения файлов, блокировки и т. д. Большая часть того, что вы используете ежедневно,
     *  находится в kotlin-stdlib. **/
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.31"

    const val javaxInject = "javax.inject:javax.inject:1"

    const val glide = "com.github.bumptech.glide:glide:4.12.0"

    const val flow = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4"
}

private typealias PDsS = PluginDependenciesSpec
private typealias PDS = PluginDependencySpec

inline val PDsS.androidApplication: PDS get() = id("com.android.application")
inline val PDsS.kotlinAndroid: PDS get() = id("kotlin-android")
inline val PDsS.jetbrainKotlinAndroid: PDS get() = id("org.jetbrains.kotlin.android")
inline val PDsS.kotlinKapt: PDS get() = id("kotlin-kapt")
inline val PDsS.androidLibrary: PDS get() = id("com.android.library")
inline val PDsS.kotlin: PDS get() = id("kotlin")

inline val DependencyHandler.core: Dependency get() = project(":core")
inline val DependencyHandler.core_ui: Dependency get() = project(":core_ui")