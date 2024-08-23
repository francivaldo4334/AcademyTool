import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "br.com.powerfitctrl.app"

version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}

dependencies {
    implementation(compose.desktop.currentOs)
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.4")
    // implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    // implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha03")
    implementation(project(":core"))
}

java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }

compose.desktop {
    application {
        mainClass = "br.com.pwrftctrl.app.presenter.MainKt"

        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "PowerFitControl"
            packageVersion = "1.0.0"
        }
    }
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions {
        jvmTarget = "21"
    }
}
