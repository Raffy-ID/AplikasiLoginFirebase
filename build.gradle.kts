// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "7.1.2" apply false
}

buildscript {
    val agp_version by extra("7.1.2")
    repositories { //Make sure that you have following the two repositories
        google()
        mavenCentral()
    }
}
