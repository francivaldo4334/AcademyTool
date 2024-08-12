plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
    application
}

repositories {
    google {
        mavenContent {
            includeGroupAndSubgroups("androidx")
        }
    }
    mavenCentral()
}

dependencies {
    implementation(libs.guava)
    implementation(compose.desktop.currentOs)
    implementation(libs.exposed.core)
    implementation(libs.exposed.jdbc)
    implementation(libs.exposed.dao)
    implementation(libs.sqlite.jdbc)
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "br.com.academytool.AppKt"
}
tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
    manifest {
        attributes["Main-Class"] = application.mainClass.get()
        attributes["App-Name"] = "AcademyTool"
    }
    from(configurations.runtimeClasspath.get().map{ if (it.isDirectory()) it else zipTree(it)})
}
