plugins {
    kotlin("js") version "1.3.72"
    maven
}

group = "uk.co.renbinden"
version = "1.4.6"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js")
    testImplementation("org.jetbrains.kotlin:kotlin-test-js")
}

kotlin.target.browser { }

val repoPassword = file("$projectDir/repo_password.txt").readLines()[0]

tasks {
    "uploadArchives"(Upload::class) {
        repositories {
            withConvention(MavenRepositoryHandlerConvention::class) {
                mavenDeployer {
                    withGroovyBuilder {
                        "repository"("url" to uri("https://maven.pkg.github.com/alyphen/ilse")) {
                            "authentication"("userName" to "alyphen", "password" to repoPassword)
                        }
                    }

                    pom.version = project.version.toString()
                    pom.artifactId = project.name
                    pom.groupId = project.group.toString()
                }
            }
        }
    }
}
