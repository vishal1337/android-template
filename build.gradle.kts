/*
 * Copyright 2021 Vishal Choudhary
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask
import extensions.applyDefault

plugins {
    id(Plugins.DETEKT) version PluginVersions.DETEKT
    id(Plugins.DOKKA) version PluginVersions.DOKKA
    id(Plugins.GIT_HOOKS)
    id(Plugins.KTLINT) version PluginVersions.KTLINT
    id(Plugins.UPDATE_DEPENDENCIES) version PluginVersions.VERSIONS_PLUGIN
}

allprojects {
    repositories.applyDefault()

    apply {
        plugin(Plugins.SPOTLESS)
        plugin(Plugins.DETEKT)
        plugin(Plugins.DOKKA)
        plugin(Plugins.KTLINT)
    }

    detekt {
        config = rootProject.files("$rootDir/.detekt/config.yml")
        reports {
            html {
                enabled = true
                destination = file("build/reports/detekt/report.html")
            }
        }
    }

    ktlint {
        debug.set(false)
        version.set(DependencyVersions.KTLINT)
        verbose.set(true)
        android.set(false)
        outputToConsole.set(true)
        ignoreFailures.set(false)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
        }
    }
}

tasks.withType<DependencyUpdatesTask> {
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

fun isNonStable(version: String): Boolean =
    listOf("alpha", "beta", "rc", "cr", "m", "preview", "b", "ea")
        .map { qualifier -> Regex("(?i).*[.-]$qualifier[.\\d-+]*") }
        .any { it.matches(version) }
