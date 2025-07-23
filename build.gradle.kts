plugins {
    id("java")
    alias(libs.plugins.lombok)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.boot.dependencies)
}

group = "io.github.lipanre"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.modulix.framework.starter)
    implementation(libs.mysql.connector)
}