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

package com.v15h4l.template.ui.addedituser

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.v15h4l.template.data.repository.UsersRepository
import com.v15h4l.template.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Implementation for the [IAddEditUserViewModel].
 */
@HiltViewModel
class AddEditUserViewModel @Inject constructor(private val usersRepository: UsersRepository) :
    ViewModel(), IAddEditUserViewModel {

    override fun addUser(user: User) {
        viewModelScope.launch {
            usersRepository.addUser(user)
        }
    }

    override fun updateUser(user: User) {
        viewModelScope.launch {
            usersRepository.updateUser(user)
        }
    }
}
