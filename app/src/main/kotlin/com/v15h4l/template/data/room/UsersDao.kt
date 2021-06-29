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

package com.v15h4l.template.data.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.v15h4l.template.model.User

/**
 * Data Access Object for Users
 */
@Dao
interface UsersDao {

    /**
     * Insert a new User into the DB
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    /**
     * Fetch the User from the DB
     */
    @Query("SELECT * FROM users WHERE id = :id")
    fun getUser(id: Int): User

    /**
     * Fetch all the Users from the DB
     */
    @Query("SELECT * FROM users")
    fun getUsers(): LiveData<List<User>>

    /**
     * Update the details of an existing User in the DB
     */
    @Update
    suspend fun update(user: User)

    /**
     * Delete the User from the DB
     */
    @Delete
    suspend fun delete(user: User)

    /**
     * Delete all the Users from the DB
     */
    @Query("DELETE FROM users")
    suspend fun deleteAllUsers()
}
