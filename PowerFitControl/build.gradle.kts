import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
    // implementation("org.jetbrains.androidx.navigation:navigation-compose:2.7.0-alpha03")
    implementation(project(":core"))
    implementation(project(":students"))
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

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
        freeCompilerArgs = listOf("-Xjsr305=strict")
    }
}

tasks.register<Jar>("fatJar") {
    from(sourceSets.main.get().output)
    dependsOn(configurations.runtimeClasspath)
    from({
        configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) }
    })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
    manifest {
        attributes["Main-Class"] = "br.com.pwrftctrl.app.presenter.MainKt"
    }
}
