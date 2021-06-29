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

package com.v15h4l.template.di

import android.content.Context
import androidx.room.Room
import com.v15h4l.template.data.room.AppDatabase
import com.v15h4l.template.data.room.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * Provides Database dependencies.
 */
@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    /**
     * Provides User Database Object.
     */
    @Provides
    fun provideUsersDao(appDatabase: AppDatabase): UsersDao = appDatabase.usersDao()

    /**
     * Provides User Database.
     */
    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase =
        Room.databaseBuilder(
            appContext,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()

    companion object {
        const val DATABASE_NAME = "users-db"
    }
}
