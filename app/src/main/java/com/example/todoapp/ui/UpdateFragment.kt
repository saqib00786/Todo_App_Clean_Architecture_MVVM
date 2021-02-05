package com.example.todoapp.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.todoapp.R
import com.example.todoapp.data.models.Priority
import com.example.todoapp.databinding.FragmentUpdateBinding
import com.example.todoapp.viewModels.SharedViewModel

class UpdateFragment : Fragment() {
    private var mBinding : FragmentUpdateBinding?=null
    private val binding get() = mBinding!!

    private val navArgs by navArgs<UpdateFragmentArgs>()
    private val sharedViewModel : SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentUpdateBinding.inflate(inflater,container,false)

        mBinding!!.titleIdUpdate.setText(navArgs.currentItem.title)
        mBinding!!.descriptionIdUpdate.setText(navArgs.currentItem.description)
        mBinding!!.spinnerIdUpdate.setSelection(sharedViewModel.parsPriority(navArgs.currentItem.priority))
        mBinding!!.spinnerIdUpdate.onItemSelectedListener = sharedViewModel.listner
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu,menu)
    }
}