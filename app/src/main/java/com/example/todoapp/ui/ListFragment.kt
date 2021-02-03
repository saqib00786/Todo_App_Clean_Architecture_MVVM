package com.example.todoapp.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
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

        mBinding!!.clickToTest.setOnClickListener {
            val action = ListFragmentDirections.actionListFragmentToUpdateFragment()
            findNavController().navigate(action)
        }
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.list_fragment_menu,menu)
    }

}