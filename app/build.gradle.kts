plugins {
    application
    id("com.diffplug.spotless") version "8.10.2"
    id("dev.openjavaformat.java-format") version "21.0.2"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.yaml:snakeyaml:2.7")
    implementation("org.apache.poi:poi:6.0.0")
    implementation("org.apache.poi:poi-ooxml:6.0.0")
    implementation("org.apache.logging.log4j:log4j-core:2.26.1")

    testImplementation("org.junit.jupiter:junit-jupiter:6.1.3")
    testImplementation("org.hamcrest:hamcrest:3.0")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:6.1.3")
}

application {
    mainClass.set("com.dglynch.xcom.App")
}

spotless {
    java {
        target("src/**/*.java")
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.addAll(listOf("-Xlint:all", "-Werror"))
}

tasks.test {
    useJUnitPlatform()
}
