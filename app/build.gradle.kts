plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
}

application {
    mainClass.set("com.dglynch.xcom.App")
}

tasks.test {
    useJUnitPlatform()
}
