plugins {
    java
}

allprojects {
    group = "ru.spbstu.shakhmin"
    apply(plugin = "java")

    repositories {
        jcenter()
    }

    configure<JavaPluginConvention> {
        sourceCompatibility = JavaVersion.VERSION_15
    }

    dependencies {
        // Google Guava
        implementation("com.google.guava:guava:30.1-jre")

        // JUnit Jupiter test framework
        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.0.0")
    }

    tasks {
        test {
            maxHeapSize = "256m"
            useJUnitPlatform()
        }
    }
}
