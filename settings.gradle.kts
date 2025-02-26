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
include(
    ":logic:appt_client:api",
    ":logic:appt_client:impl"
)
include(":utils")

project(":composeApp").projectDir = File("modules/composeApp")
project(":logic").projectDir = File("modules/logic")
project(":logic:appt_client:api").projectDir = File("modules/logic/appt-client/api")
project(":logic:appt_client:impl").projectDir = File("modules/logic/appt-client/impl")
project(":utils").projectDir = File("modules/utils")