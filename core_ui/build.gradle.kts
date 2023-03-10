plugins {
    androidLibrary
    jetbrainKotlinAndroid
}

android {
    compileSdk = appConfig.compileSdkVersion

    defaultConfig {
        minSdk = appConfig.minSdkVersion
        targetSdk = appConfig.targetSdkVersion

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
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
        jvmTarget = "1.8"
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(core)

    implementation(deps.androidx.coreKtx)
    implementation(deps.androidx.appCompat)
    implementation(deps.androidx.material)

    /** Glide **/
    implementation(deps.glide)

    /** Nav **/
    implementation(deps.jetpackNavigation.uiNavigation)
}