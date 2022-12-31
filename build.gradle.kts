plugins {
    id("java")
    id("com.diffplug.spotless") version "6.11.0"
    kotlin("jvm") version "1.7.10"
}

val javaVersion by extra { "17" }

allprojects {
    apply(plugin = "java")
    apply(plugin = "com.diffplug.spotless")
    apply(plugin = "kotlin")

    group = "io.github.shirohoo"
    java.sourceCompatibility = JavaVersion.VERSION_17

    repositories {
        mavenCentral()
        maven("https://plugins.gradle.org/m2/")
    }

    dependencies {
        testImplementation("com.google.truth:truth:1.1.3")
        testImplementation("org.assertj:assertj-core:3.23.1")
        testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
        testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    }

    tasks.withType<JavaCompile> {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "17"
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    spotless {
        java {
            // parser
            palantirJavaFormat()

            // options
            target("src/main/java/**/*.java", "src/main/test/**/*.java")
            formatAnnotations()
            importOrder()
            removeUnusedImports()
            trimTrailingWhitespace()
            indentWithSpaces(4)
        }
    }
}