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

package com.v15h4l.template.data.repository

import com.v15h4l.template.data.room.UsersDao
import com.v15h4l.template.model.User
import javax.inject.Inject

/**
 * Repository to access data of a [User]
 */
class UsersRepository @Inject constructor(private val usersDao: UsersDao) {

    /**
     * Fetch User by id
     */
    fun getUser(id: Int) = usersDao.getUser(id)

    /**
     * Fetch all the Users
     */
    fun getUsers() = usersDao.getUsers()

    /**
     * Add a new User
     */
    suspend fun addUser(user: User) {
        usersDao.insertUser(user)
    }

    /**
     * Update an existing User
     */
    suspend fun updateUser(user: User) {
        usersDao.update(user)
    }

    /**
     * Delete a User
     */
    suspend fun deleteUser(user: User) {
        usersDao.delete(user)
    }
}
