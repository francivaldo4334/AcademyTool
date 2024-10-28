import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
  kotlin("jvm")
  id("org.jetbrains.compose")
  id("org.jetbrains.kotlin.plugins.compose")
}

group = "br.com.pwrftctrl.schedule"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/plublic/p/compose/dev")
  google()
}

java {
  toolchain {
    languageVersion = JavaLanguageVersion.of(21)
  }
}

dependencies {
    val exposedVersion = "0.55.0"
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation(compose.desktop.currentOs)
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.1")
}
