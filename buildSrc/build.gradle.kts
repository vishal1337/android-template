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

plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    google()
    gradlePluginPortal()
    jcenter()
    mavenCentral()
}

object PluginVersions {
    const val AGP = "4.1.2"
    const val KOTLIN = "1.4.30"
    const val SPOTLESS = "3.26.1"
}

dependencies {
    implementation("com.android.tools.build:gradle:${PluginVersions.AGP}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${PluginVersions.KOTLIN}")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:${PluginVersions.SPOTLESS}")
}
