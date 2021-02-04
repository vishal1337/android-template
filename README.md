# Android Boilerplate 🤖
[![CodeStyle](https://img.shields.io/badge/code%20style-%E2%9D%A4-FF4081.svg)](https://ktlint.github.io/)
[![Kotlin Version](https://img.shields.io/badge/kotlin-1.4.30-blue.svg)](http://kotlinlang.org/)
[![Gradle](https://img.shields.io/badge/gradle-6.8.1-blue.svg)](https://lv.binarybabel.org/catalog/gradle/latest)
[![API](https://img.shields.io/badge/API-23%2B-blue.svg)](https://android-arsenal.com/api?level=23)
[![License](https://img.shields.io/badge/License-Apache%202.0-lightgrey.svg)](http://www.apache.org/licenses/LICENSE-2.0)

A simple Android project template that lets you create an **Android/Kotlin** project and be up and running in a **few seconds**.

This template is focused on delivering a project with **static analysis** and **continuous integration** already in place.

## How to use 👣

Just click on [![Use this template](https://img.shields.io/badge/-Use%20this%20template-brightgreen)](https://github.com/vishal1337/android-boilerplate/generate) button to create a new repo starting from this template.

Once created don't forget to update the:
- [App ID](buildSrc/src/main/kotlin/AndroidConfig.kt)
- AndroidManifest ([here](app/src/main/AndroidManifest.xml) and [here](core/src/main/AndroidManifest.xml))
- Package of the source files

## Features 🎨

- **100% Kotlin-only template**.
- 3 Sample modules (Android app, Android library, Kotlin library).
<!--- Sample Espresso, Instrumentation & JUnit tests. --->
- 100% Gradle Kotlin DSL setup.
- Dependency versions managed via `buildSrc`.
<!--- CI Setup with GitHub Actions. --->
- Kotlin Static Analysis via `ktlint` and `detekt`.
<!--- Publishing Ready. --->
- Issues Template (bug report + feature request).
- Pull Request Template.

## Gradle Setup 🐘

This template is using [**Gradle Kotlin DSL**](https://docs.gradle.org/current/userguide/kotlin_dsl.html) as well as the [Plugin DSL](https://docs.gradle.org/current/userguide/plugins.html#sec:plugins_block) to setup the build.

Dependencies are centralized inside the [Dependencies.kt](buildSrc/src/main/kotlin/dependencies/Dependencies.kt) file in the `buildSrc` folder. This provides convenient auto-completion when writing your gradle files.

## Static Analysis 🔍

This template is using [**ktlint**](https://github.com/pinterest/ktlint) with the [ktlint-gradle](https://github.com/jlleitschuh/ktlint-gradle) plugin to format your code. To reformat all the source code as well as the buildscript you can run the `ktlintFormat` gradle task.

This template is also using [**detekt**](https://github.com/detekt/detekt) to analyze the source code, with the configuration that is stored in the [detekt.yml](config/detekt/detekt.yml) file (the file has been generated with the `detektGenerateConfig` task).

## Development

### Environment setup

First off, you require the latest Android Studio 4.1.2 (or newer) to be able to build the app.

Secondly, to sign your app for release you should generate an upload key and keystore following the [official documentation](https://developer.android.com/studio/publish/app-signing#sign-apk). Append the information used to generate it into `local.properties` project root file following the structure:

```properties
#Signing Config
signing.key.alias = <insert>
signing.key.password = <insert>
signing.store.file = <insert>
signing.store.password = <insert>
```

## Architecture

The architecture of the application is based, apply and strictly complies with each of the following 5 points:

-   A single-activity architecture, using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage fragment operations.
-   [Android architecture components](https://developer.android.com/topic/libraries/architecture/), part of Android Jetpack for give to project a robust design, testable and maintainable.
-   Pattern [Model-View-ViewModel](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93viewmodel) (MVVM) facilitating a [separation](https://en.wikipedia.org/wiki/Separation_of_concerns) of development of the graphical user interface.
-   [S.O.L.I.D](https://en.wikipedia.org/wiki/SOLID) design principles intended to make software designs more understandable, flexible and maintainable.
-   [Modular app architecture](https://proandroiddev.com/build-a-modular-android-app-architecture-25342d99de82) allows to be developed features in isolation, independently from other features.

### Modules

Modules are collection of source files and build settings that allow you to divide a project into discrete units of functionality. In this case apart from dividing by functionality/responsibility, existing the following dependence between them:

<!---
TODO Update module dependencies here
-   `:app` depends on `:core` and indirectly depends on `:features` by dynamic-features.
-   `:features` modules depends on `:commons`, `:core`, `:libraries` and `:app`.
-   `:core` and `:commons` only depends for possible utils on `:libraries`.
-   `:libraries` don’t have any dependency.
--->

#### App module

The `:app` module is a [com.android.application](https://developer.android.com/studio/build/) module, which is needed to create the app bundle.  It is also responsible for initiating the [dependency graph](https://dagger.dev/hilt) and another project global libraries, differentiating especially between different app environments.

#### Core module

The `:core` module is a [com.android.library](https://developer.android.com/studio/projects/android-library) module for serving the core features of the app like network requests or accessing to the database etc.

#### Library module

The `:library` module is a [com.android.library](https://developer.android.com/studio/projects/android-library) module, which basically contains different utilities that can be used by the different modules.

<!---
### Build variants

The application has different product flavours: `Dev`, `QA`, `Prod`. Each variant has a specific target environment and to make easier to distinguish them the app uses a specific icon colour for `debug` and `release` build variant with descriptive app name. In this case and given that it's a sample, all variants have the same Marvel API endpoint.
But the idea is to have different environments target for Development and QA respectively, what doesn't affect the production environment. This is applicable to any tool, platform, service what is being used. For more information about build variant, check this [link](https://developer.android.com/studio/build/build-variants).

| Types   | DEV                                                                             | QA                                                                             | PROD                                                                         |
|---------|:-------------------------------------------------------------------------------:|:------------------------------------------------------------------------------:|:----------------------------------------------------------------------------:|
| Debug   | <p><img src="app/src/debug/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplateDEV</p> | <p><img src="app/src/debug/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplateQA</p> | <p><img src="app/src/debug/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplate</p> |
| Release | <p><img src="app/src/main/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplateDEV</p>  | <p><img src="app/src/main/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplateQA</p>  | <p><img src="app/src/main/res/mipmap-xhdpi/ic_launcher.png"><br>AndroidTemplate</p>  |

--->

## Todo

- Add Static Analysis tools
- Add Product Flavours
- Add CI
- Add Issues Template (bug report + feature request).
- Add Pull Request Template.
- Add Sample Espresso, Instrumentation & JUnit tests.

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
