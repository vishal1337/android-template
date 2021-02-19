# Android Template
[![CodeStyle](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
![Build](https://github.com/vishal1337/android-template/workflows/Build/badge.svg)
[![Kotlin Version](https://img.shields.io/badge/kotlin-1.4.30-blue.svg)](http://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/gradle-6.8.2-blue.svg)](https://lv.binarybabel.org/catalog/gradle/latest)
[![API](https://img.shields.io/badge/API-23%2B-blue.svg)](https://android-arsenal.com/api?level=23)
[![License](https://img.shields.io/badge/License-Apache%202.0-lightgrey.svg)](http://www.apache.org/licenses/LICENSE-2.0)

An Android project template, written completely in **Kotlin**, to help you kick start your next Android project in seconds.

This template has **Static Analysis** and **Continuous Integration** already set up.

## Table of Contents

  - [How to use](#how-to-use)
  - [Features](#features)
  - [Gradle Setup](#gradle-Setup)
  - [Git Hooks](#git-hooks)
  - [Static Analysis](#static-analysis)
  - [Code Formatting](#code-formatting)
  - [Dependency Updates](#dependency-updates)
  - [CI](#ci)
  - [Documentation](#documentation)
  - [Architecture](#architecture)
  - [Contributions](#contributions)
  - [License](#license)


## How to use

Just click on the [![Use this template](https://img.shields.io/badge/-Use%20this%20template-brightgreen)](https://github.com/vishal1337/android-template/generate) button to create a new repo starting from this template.

Once created don't forget to update the:
- [Android Configuration](buildSrc/src/main/kotlin/AndroidConfig.kt) for App ID and other required Information.
- App ID in [`app/src/main/AndroidManifest.xml`](app/src/main/AndroidManifest.xml) and [`core/src/main/AndroidManifest.xml`](core/src/main/AndroidManifest.xml).
- Package of the source files.
- [Copyright](.spotless/copyright.kt).
- Run `./gradlew spotlessApply` to update the copyright across the project.
- Run `./gradlew installGitHooks` task to install Git Hooks.

## Features

- **100% Kotlin-only template**.
- **100% Gradle Kotlin DSL setup**.
- Dependencies managed via [`buildSrc`](buildSrc).
- Common gradle scripts for [`android-library`](buildSrc/src/main/kotlin/commons/android-library.gradle.kts), [`kotlin-library`](buildSrc/src/main/kotlin/commons/kotlin-library.gradle.kts) & [`android-dynamic-feature`](buildSrc/src/main/kotlin/commons/android-dynamic-feature.gradle.kts).
- 3 Sample modules ([`Android app`](app), [`Android library`](core), [`Kotlin library`](library)).
- Product flavours. `dev`, `qa`, `prod`.
- Kotlin Static Analysis using [`ktlint`](https://github.com/pinterest/ktlint) & [`detekt`](https://github.com/detekt/detekt).
- Code formatting using [`spotless`](https://github.com/diffplug/spotless).
- Dependency updates management using [`gradle-versions`](https://github.com/ben-manes/gradle-versions-plugin).
- Git Hooks to make sure you commit the code that passes all the Static Analysis tests.
- CI setup with GitHub Actions.
- Issues Template (bug report + feature request).
- Pull Request Template.
<!--- MVVM Sample included. --->
<!--- Sample ViewModel Usage. --->
<!--- Sample Network API Calls, Room DB Usage. --->
<!--- Sample Espresso, Instrumentation & JUnit tests. --->
<!--- Publishing Ready. --->

## Gradle Setup

This template is using [**Gradle Kotlin DSL**](https://docs.gradle.org/current/userguide/kotlin_dsl.html) as well as the [Plugin DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block) to setup the build.

[Android Config](buildSrc/src/main/kotlin/AndroidConfig.kt) contains Android specific configurations.

Dependencies are centralized inside the [Dependencies.kt](buildSrc/src/main/kotlin/dependencies/Dependencies.kt) file in the [`buildSrc`](buildSrc) folder. This provides convenient auto-completion when writing your gradle files.

Common gradle scripts are placed inside the [commons](buildSrc/src/main/kotlin/commons) package to help reduce boilerplate code when creating a new module. Refer to [`core/build.gradle.kts`](core/build.gradle.kts) or [`library/build.gradle.kts`](library/build.gradle.kts) file for usage examples.

## Git Hooks

Git Hooks allow running a pre commit script to make sure the code complies with the coding style before making a commit. Run `./gradlew installGitHooks` task to install Git Hooks.

## Static Analysis

This template is using [**ktlint**](https://github.com/pinterest/ktlint) with the [ktlint-gradle](https://github.com/jlleitschuh/ktlint-gradle) plugin to format your code. To reformat all the source code as well as the buildscript you can run the `ktlintFormat` gradle task.

Run `./gradlew ktlintCheck` to check if the there are any lint issues.

Run `./gradlew ktlintFormat` to format the code across the project.

This template is using [**detekt**](https://github.com/detekt/detekt) to analyze the source code, with the configuration that is stored in the [config.yml](.detekt/config.yml) file (the file has been generated with the `detektGenerateConfig` task).

Run `./gradlew detekt` to analyze the code.

Alternatively, you can Run `scripts/process-code.sh` to fix the code style and update the copyright all at once.

## Code Formatting

This template is using [**spotless**](https://github.com/diffplug/spotless) to format the code, and apply [copyright.kt](.spotless/copyright.kt) header to all the files in the project.

Run `./gradlew spotlessCheck` to check if the copyright is up to date.

Run `./gradlew spotlessApply` to update the copyright across the project.

## Dependency Updates

This template is using [**gradle-versions**](https://github.com/ben-manes/gradle-versions-plugin) to generate dependency updates report.

Run `./gradlew dependencyUpdates` to generate dependency updates report.

## CI

This template is using [Github Actions](https://github.com/vishal1337/android-template/actions) for CI.

These are the workflows currently available.

- [Build](.github/workflows/build.yaml) - Will run the `build` task whenever there is a new push to any branch other than the master.
- [Deploy App](.github/workflows/deploy-app.yaml) - For every pull request merged to the master branch, it will run the `build` & `bundleRelease` tasks followed by signing the bundle and publishing it to the Play store.

Github Actions are integrated with Slack, you get the updates on Slack.

Add the following **SECRETS** to the repository

- `SLACK_WEBHOOK_URL`
- `SIGNING_KEY`
- `KEY_STORE_PASSWORD`
- `ALIAS`
- `KEY_PASSWORD`

Run the following command to generate Signing key string
```
openssl base64 < some_signing_key.jks | tr -d '\n' | tee some_signing_key.jks.base64.txt
```

## Documentation

This template is using [**dokka**](https://github.com/Kotlin/dokka) to generate Documentation for the codebase. Use gradle tasks in `documentation` to generate documentation in required format.

## Architecture

The architecture of the template is based, apply and strictly complies with each of the following 5 points:

-   A single-activity architecture, using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage fragment operations.
-   [Android architecture components](https://developer.android.com/topic/libraries/architecture/), part of Android Jetpack for give to project a robust design, testable and maintainable.
-   Pattern [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) (MVVM) facilitating a [separation](https://en.wikipedia.org/wiki/Separation_of_concerns) of development of the graphical user interface.
-   [S.O.L.I.D](https://en.wikipedia.org/wiki/SOLID) design principles intended to make software designs more understandable, flexible and maintainable.
-   [Modular app architecture](https://proandroiddev.com/build-a-modular-android-app-architecture-25342d99de82) allows to be developed features in isolation, independently from other features.

### Modules

Modules are collection of source files and build settings that allow you to divide a project into discrete units of functionality. In this case apart from dividing by functionality/responsibility, existing the following dependence between them:

-   `:app` depends on `:core`.
-   `:core` and `:library` don’t have any dependency.

### Build variants

The template has different product flavours: `Dev`, `QA`, `Prod`. Each variant has a specific target environment. Different flavours use different assets for `debug` and `release` build variant with descriptive app names.
For more information about build variant, check this [link](https://developer.android.com/studio/build/build-variants).

| Types   | DEV                                                                             | QA                                                                             | PROD                                                                         |
|---------|:-------------------------------------------------------------------------------:|:------------------------------------------------------------------------------:|:----------------------------------------------------------------------------:|
| Debug   | <p><img src="app/src/debug/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplateDEV</p> | <p><img src="app/src/debug/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplateQA</p> | <p><img src="app/src/debug/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplate</p> |
| Release | <p><img src="app/src/main/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplateDEV</p>  | <p><img src="app/src/main/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplateQA</p>  | <p><img src="app/src/main/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplate</p>  |

### Best practices

Avoid reinventing the wheel by following these guidelines:

-   [Google best practices](https://developer.android.com/distribute/best-practices)
-   [Android development best practices](https://github.com/futurice/android-best-practices)

### Codelabs

Google Developers Codelabs provide a guided, tutorial, hands-on coding experience. Most codelabs will step you through the process of building a small application, or adding a new feature to an existing application. They cover a wide range of android concepts to learn and practice:

-   [Android Developer Fundamentals](https://developer.android.com/courses/fundamentals-training/toc-v2)
-   [Android Developer Codelabs](https://codelabs.developers.google.com/?cat=Android)

## Contributions

In Future Maybe
<!-- All contributions are welcome! -->
<!-- Useful for Later Maybe -->

## License

```license
Copyright 2021 Vishal Choudhary

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
