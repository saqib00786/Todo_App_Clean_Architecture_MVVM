package com.example.todoapp.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentListBinding
import com.example.todoapp.ui.adapter.TodoAdapter
import com.example.todoapp.viewModels.TodoViewModel

class ListFragment : Fragment() {
    private var mBinding: FragmentListBinding? = null
    private val binding get() = mBinding!!

    private val adapter : TodoAdapter by lazy { TodoAdapter()}
    private val mviewModel : TodoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentListBinding.inflate(inflater,container,false)

        mBinding!!.addBtnId.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToAddFragment()
            findNavController().navigate(action)
        }

        val recyclerView = mBinding!!.recyclerViewId
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireActivity())

        mviewModel.getAllData.observe(viewLifecycleOwner, {
            adapter.setList(it)
        })


        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu,menu)
    }

}