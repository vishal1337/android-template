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

package com.v15h4l.template.ui.users

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.v15h4l.template.databinding.BsUserItemOptionsBinding
import com.v15h4l.template.databinding.FragmentUsersBinding
import com.v15h4l.template.model.User
import dagger.hilt.android.AndroidEntryPoint

/**
 * Fragment to show a list of Users fetched from a local Database
 */
@AndroidEntryPoint
class UsersFragment : Fragment() {

    private var _binding: FragmentUsersBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UsersViewModel by viewModels()

    private val userAdapter by lazy { UserAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUsersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        viewModel.getUsers().observe(
            viewLifecycleOwner,
            { users ->
                userAdapter.submitList(users)
                binding.noUsersMessage.isVisible = users.isEmpty()
            }
        )
    }

    private fun initView() {
        binding.rvUsers.adapter = userAdapter.apply {
            onItemClicked = {
                showUserOptions(it)
            }
        }
        binding.btnAddUser.setOnClickListener {
            openAddUserScreen()
        }
    }

    private fun showUserOptions(user: User) {
        val dialog = BottomSheetDialog(requireContext())

        val binding = BsUserItemOptionsBinding.inflate(layoutInflater, null, false).apply {
            tvEdit.setOnClickListener { openEditUserScreen(user); dialog.dismiss() }
            tvDelete.setOnClickListener { viewModel.deleteUser(user); dialog.dismiss() }
        }
        dialog.setContentView(binding.root)
        dialog.show()
    }

    private fun openAddUserScreen() {
        val action = UsersFragmentDirections.actionUsersFragmentToAddEditFragment()
        findNavController().navigate(action)
    }

    private fun openEditUserScreen(user: User) {
        val action = UsersFragmentDirections.actionUsersFragmentToAddEditFragment(user)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
