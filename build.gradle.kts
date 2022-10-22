import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

java.sourceCompatibility = JavaVersion.VERSION_11

plugins {
    id("org.springframework.boot") version "2.6.7" apply false
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }
    apply {
        plugin("kotlin")
        plugin("io.spring.dependency-management")
        plugin("org.jetbrains.kotlin.plugin.spring")
    }
}

subprojects {
    dependencyManagement {
        imports {
            mavenBom("org.springframework.boot:spring-boot-dependencies:2.1.0.RELEASE") {
                bomProperty("kotlin.version", "1.6.0")
            }
            mavenBom("org.apache.logging.log4j:log4j-bom:2.17.2")
        }
        dependencies {
            dependency("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
            dependency("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.4")
        }
    }

    tasks.withType<Test> {
        useJUnitPlatform()
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "11"
        }
    }
}

tasks.withType<Jar>() {
    manifest {
        attributes["Main-Class"] = "com.mint.ecommerce.webservice.Application"
    }
}