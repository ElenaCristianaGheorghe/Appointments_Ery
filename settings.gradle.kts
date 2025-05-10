rootProject.name = "Appt_Ery"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
    }
}

include(":composeApp")
include(":core:database")
include(":core:domain")
include(":core")
include(":core:data")
include(":utils")

project(":core").projectDir = File("modules/core")
project(":composeApp").projectDir = File("modules/composeApp")
project(":core:database").projectDir = File("modules/core/database")
project(":core:domain").projectDir = File("modules/core/domain")
project(":core:data").projectDir = File("modules/core/data")
project(":utils").projectDir = File("modules/utils")