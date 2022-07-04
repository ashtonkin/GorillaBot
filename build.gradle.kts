import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.0"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("java")
    application
}

group = "code.itsash"
version = "0.1.0"

repositories {
    mavenCentral()
    maven("https://m2.dv8tion.net/releases")
}

dependencies {
    //JDA no audio
    implementation("net.dv8tion:JDA:5.0.0-alpha.13") {
        exclude(null, "opus-java")
    }

    //Logging
    implementation("ch.qos.logback:logback-classic:1.2.11")

    //Database
    implementation("com.zaxxer:HikariCP:5.0.1")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.0.5")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "16"
}

tasks.withType<Jar> {
    manifest {
        attributes(mapOf(
            "Main-Class" to "MainKt"
        ))
    }
}

application {
    mainClass.set("MainKt")
}