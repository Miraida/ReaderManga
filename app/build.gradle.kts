plugins {
    androidApplication
    jetbrainKotlinAndroid
}

android {
    compileSdk = appConfig.compileSdkVersion

    defaultConfig {
        applicationId = "com.example.readermanga"
        minSdk = appConfig.minSdkVersion
        targetSdk = appConfig.targetSdkVersion
        versionCode = appConfig.versionCode
        versionName = appConfig.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
    buildFeatures { viewBinding = true }
}

dependencies {

    /** UI **/
    implementation(deps.androidx.coreKtx)
    implementation (deps.androidx.material)
    implementation (deps.androidx.appCompat)
    implementation (deps.androidx.recyclerView)
    implementation(deps.androidx.constraintLayout)

    /** Coroutines **/
    implementation(deps.coroutines.core)

    /** Koin **/
    implementation(deps.koin.koinCore)
    implementation(deps.koin.koinAndroid)

    /** Retrofit**/
    implementation(deps.squareup.retrofit)
    implementation(deps.squareup.loggingInterceptor)
    implementation(deps.squareup.retrofitConverterGson)

    /** Navigation **/
    implementation(deps.jetpackNavigation.fragmentNavigation)

    /** Lifecycle **/
    implementation(deps.lifecycle.viewModelKtx)
    implementation(deps.lifecycle.runtimeKtx)
}