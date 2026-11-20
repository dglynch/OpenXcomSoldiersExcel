plugins {
    application
    kotlin("jvm") version "2.4.21"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.yaml:snakeyaml:1.29")
    implementation("org.apache.poi:poi:5.0.0")
    implementation("org.apache.poi:poi-ooxml:5.0.0")

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:1.7.1")
}

application {
    mainClass.set("com.dglynch.xcom.App")
}

tasks.test {
    useJUnitPlatform()
}
