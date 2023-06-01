package com.themakcym.gtd.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.themakcym.gtd.databinding.GroupFragmentBinding
import com.themakcym.gtd.presentation.adapters.GroupAdapter
import com.themakcym.gtd.presentation.viewmodels.GroupViewModel
import java.util.UUID


class GroupFragment(private val groupId: UUID) : Fragment() {

    private lateinit var binding: GroupFragmentBinding
    lateinit var viewModel: GroupViewModel
    private val rvAdapter = GroupAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {

        binding = GroupFragmentBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this)[GroupViewModel::class.java]
        viewModel.groupId = groupId
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tasksRecycler.adapter = rvAdapter
        binding.tasksRecycler.layoutManager = LinearLayoutManager(requireActivity())

        viewModel.tasks.observe(requireActivity()) {
            rvAdapter.submitList(it)
        }
        viewModel.selectTasksByGroup()
    }
}