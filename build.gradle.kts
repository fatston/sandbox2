plugins {
    kotlin("jvm") version "2.1.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("io.kotest:kotest-runner-junit5:5.9.1")  // for running tests
    testImplementation("io.kotest:kotest-assertions-core:5.9.1") // for shouldBe, shouldNotBe, etc.
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(18)
}