plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
    id("kotlin-kapt")
}

android {
    compileSdkVersion(Releases.targetSdkVersion)
    buildToolsVersion = Releases.buildToolsVersion

    defaultConfig {
        applicationId = ApplicationId.id
        minSdkVersion(Releases.minSdkVersion)
        targetSdkVersion(Releases.targetSdkVersion)
        versionCode = Releases.versionCode
        versionName = Releases.versionName
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "BASE_URL", "\"https://api.themoviedb.org/\"")
        buildConfigField("String", "API_KEY", "\"00fadd6af89412de4c1a3ecd7fe631f6/\"")
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    packagingOptions.exclude("META-INF/main.kotlin_module")
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Version.kotlin}")

    with(AndroidSupport) {
        implementation(v4)
        implementation(cardview)
        implementation(recyclerview)
        implementation(design)
        implementation(appCompat)
        implementation(constraintLayout)
        implementation(legacy)
    }

    with(Retrofit) {
        implementation(retrofit)
        implementation(gson)
        implementation(gsonConverter)
        implementation(okHttpLogging)
        implementation(rxAdapter)
    }

    with(Dagger) {
        implementation(dagger)
        kapt(compiler)
        implementation(android)
        implementation(androidSupport)
        kapt(processor)
    }

    with(Reactivex) {
        implementation(java)
        implementation(android)
    }

    with(Facebook) {
        implementation(shimmer)
    }

    with(Airbnb) {
        implementation(lottie)
    }

    with(Font) {
        implementation(calligraphy)
        implementation(viewPump)
    }

    with(Anko) {
        implementation(anko)
        implementation(common)
        implementation(design)
    }

    with(Testing) {
        testImplementation(junit)
        testImplementation(mockitoCore)
        androidTestImplementation(rules)
        androidTestImplementation(runner)
        androidTestImplementation(espressoCore)
        testImplementation(mockitoInline)
        implementation(Deps.kotlin_stdlib)
    }
}
