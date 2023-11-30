plugins {
    id("com.android.application")
}

android {
    namespace = "devandroid.paulo.appgaseta"
    compileSdk = 33

    defaultConfig {
        applicationId = "devandroid.paulo.appgaseta"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

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

}

dependencies {

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.8.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //biblioteca de mascara telefone - https://github.com/santalu/maskara
    implementation("com.github.santalu:maskara:1.0.0")

    //biblioteca para imagem gif //https://github.com/bumptech/glide
    implementation ("com.github.bumptech.glide:glide:4.16.0")

}