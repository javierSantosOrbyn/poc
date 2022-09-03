plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.jpa") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.4.1"
}

version = "0.0.1"
group = "com.example"

val kotlinVersion = project.properties["kotlinVersion"]
repositories {
    mavenCentral()
}

dependencies {
    implementation("org.mockito:mockito-core:4.7.0")
    implementation("io.micronaut.kafka:micronaut-kafka")
    implementation("io.projectreactor.netty:reactor-netty:1.0.22")
    kapt("io.micronaut:micronaut-http-validation")
    kapt("io.micronaut.openapi:micronaut-openapi")

    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut:micronaut-management")
    // Add Kotlin support
    implementation("io.micronaut.kotlin:micronaut-kotlin-extension-functions")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    // Liquibase
    implementation("io.micronaut.liquibase:micronaut-liquibase")
    implementation("org.slf4j:jul-to-slf4j:${project.properties["slf4jVersion"]}") // To force JUL logs to slf4j
    implementation("org.liquibase:liquibase-core:${project.properties["liquibaseVersion"]}")

    implementation("io.micronaut.micrometer:micronaut-micrometer-core")
    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-datadog")
    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-jmx")
    // JPA and data
    implementation("io.micronaut.sql:micronaut-hibernate-jpa")
    annotationProcessor("io.micronaut.data:micronaut-data-hibernate-jpa") // enable tx processing
    annotationProcessor("io.micronaut.data:micronaut-data-processor") // enable tx processing
    implementation("io.micronaut.data:micronaut-data-hibernate-jpa")
    implementation("io.micronaut.sql:micronaut-jdbc-hikari")
    implementation("jakarta.annotation:jakarta.annotation-api")

    implementation("io.swagger.core.v3:swagger-annotations")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    runtimeOnly("org.postgresql:postgresql")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:testcontainers")
    implementation("io.micronaut:micronaut-validation")

    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("com.typesafe:config:${project.properties["typesafeConfigVersion"]}")
}


application {
    mainClass.set("com.example.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("17")
    targetCompatibility = JavaVersion.toVersion("17")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("com.example.*")
    }
}

task("printVersion") {
    doLast {
        println(project.version)
    }
}

tasks.test {
    maxHeapSize = "1G"
    useJUnitPlatform {
        excludeTags("Integration")
    }
}