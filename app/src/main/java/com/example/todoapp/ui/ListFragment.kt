package com.example.todoapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todoapp.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private var mBinding: FragmentListBinding? = null
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentListBinding.inflate(inflater,container,false)

        mBinding!!.addBtnId.setOnClickListener{
            val action = ListFragmentDirections.actionListFragmentToAddFragment()
            findNavController().navigate(action)
        }

        return binding.root
    }

}