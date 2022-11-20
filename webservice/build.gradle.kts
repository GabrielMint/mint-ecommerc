import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":business"))
    implementation(project(":database"))
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.boot:spring-boot-starter-actuator:2.7.5")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
    implementation("io.github.microutils:kotlin-logging:2.1.23")
    implementation("io.micrometer:micrometer-registry-prometheus:1.10.1")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}

tasks.getByName<BootJar>("bootJar") {
    archiveFileName.set("${rootProject.name}-${project.parent?.name}-${project.parent?.version}.${archiveExtension.get()}")
}
tasks.jar {
    enabled = true
}
