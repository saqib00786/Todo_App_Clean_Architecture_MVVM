package com.example.todoapp.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.todoapp.R
import com.example.todoapp.databinding.FragmentUpdateBinding

class UpdateFragment : Fragment() {
    private var mBinding : FragmentUpdateBinding?=null
    private val binding get() = mBinding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentUpdateBinding.inflate(inflater,container,false)


        setHasOptionsMenu(true)
        return binding.root
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.update_fragment_menu,menu)
    }
}