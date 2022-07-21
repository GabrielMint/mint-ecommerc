import org.springframework.boot.gradle.tasks.bundling.BootJar

plugins {
    id("org.springframework.boot")
}

dependencies {
    implementation(project(":api"))
    implementation(project(":business"))
    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
}

tasks.getByName<BootJar>("bootJar") {
    archiveFileName.set("${rootProject.name}-${project.parent?.name}-${project.parent?.version}.${archiveExtension.get()}")
}
tasks.jar {
    enabled = true
}