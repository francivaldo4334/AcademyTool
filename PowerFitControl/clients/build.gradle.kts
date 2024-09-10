import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm")
    id("org.jetbrains.compose")
    id("org.jetbrains.kotlin.plugin.compose")
}

group = "br.com.powerfitctrl.clients"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    google()
}
java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }

dependencies {
    val exposedVersion = "0.54.0"
    implementation(compose.desktop.currentOs)
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.1")
    implementation("org.jetbrains.exposed:exposed-core:$exposedVersion")
    implementation("org.xerial:sqlite-jdbc:3.46.1.0")
    implementation(project(":core"))
}

