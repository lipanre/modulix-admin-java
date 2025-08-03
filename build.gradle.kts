plugins {
    id("java")
    alias(libs.plugins.lombok)
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.boot.dependencies)
}

group = "io.github.lipanre"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    implementation(libs.modulix.framework.starter)
    implementation(libs.spring.boot.starter.test)
    implementation(libs.mysql.connector)
    implementation(libs.commons.collections)
    annotationProcessor(libs.mapstruct.plus.processor)
}

tasks.test {
    useJUnitPlatform()
}