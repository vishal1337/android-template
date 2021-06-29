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

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.v15h4l.template.R
import com.v15h4l.template.databinding.FragmentAddEditUserBinding
import com.v15h4l.template.model.User
import com.v15h4l.template.utils.hideKeyboard
import com.v15h4l.template.utils.isEmail
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment to show add/edit User form
 */
@AndroidEntryPoint
class AddEditUserFragment : Fragment() {

    private var _binding: FragmentAddEditUserBinding? = null
    private val binding get() = _binding!!

    private val viewModel: AddEditUserViewModel by viewModels()

    private val userArg: User?
        get() = arguments?.let { AddEditUserFragmentArgs.fromBundle(it).user }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddEditUserBinding.inflate(inflater, container, false).apply {
            user = userArg ?: User()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        with(binding) {
            toolbar.title =
                userArg?.let { getString(R.string.title_edit) } ?: getString(R.string.title_add)

            toolbar.setNavigationOnClickListener {
                navigateUp()
            }

            etName.doOnTextChanged { _, _, _, _ ->
                validateFields()
            }

            etEmail.doOnTextChanged { _, _, _, _ ->
                validateFields()
            }

            btnSave.setOnClickListener {
                user?.let {
                    if (it.id == 0) {
                        viewModel.addUser(it)
                    } else {
                        viewModel.updateUser(it)
                    }
                }
                hideKeyboard()
                navigateUp()
            }
        }
    }

    private fun validateFields() {
        with(binding) {
            binding.btnSave.isEnabled = etName.text.toString().isNotBlank() &&
                etEmail.text.toString().isNotBlank() &&
                etEmail.text.toString().isEmail()
        }
    }

    private fun navigateUp() {
        findNavController().navigateUp()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
