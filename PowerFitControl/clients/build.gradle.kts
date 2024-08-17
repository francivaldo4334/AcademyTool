plugins { 
    alias(libs.plugins.jvm) 
    alias(libs.plugins.jetbrainsCompose)
    alias(libs.plugins.compose.compiler)
}

repositories {
    google { mavenContent { includeGroupAndSubgroups("androidx") } }
    mavenCentral()
}

dependencies {
    implementation(compose.desktop.currentOs)
} 

java { toolchain { languageVersion = JavaLanguageVersion.of(21) } }
