package com.example.todoapp.ui

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.todoapp.R
import com.example.todoapp.TodoUtils
import com.example.todoapp.data.models.TodoData
import com.example.todoapp.databinding.FragmentAddBinding
import com.example.todoapp.viewModels.SharedViewModel
import com.example.todoapp.viewModels.TodoViewModel


class AddFragment : Fragment() {
    private var mBinding: FragmentAddBinding? = null
    private val binding get() = mBinding!!

    private val viewModel : TodoViewModel by viewModels()
    private val sharedViewModel : SharedViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentAddBinding.inflate(inflater, container, false)

        mBinding?.spinnerIdAdd?.onItemSelectedListener = sharedViewModel.listner

        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.add_fragment_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.addTodoId_menu){
            insertDB()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun insertDB() {

        val mTitle = mBinding?.titleIdAdd?.text.toString()
        val mPriority = mBinding?.spinnerIdAdd?.selectedItem.toString()
        val mDescription = mBinding?.descriptionIdAdd?.text.toString()

        if(!(mTitle.isEmpty() || mDescription.isEmpty())) {
            val todoItem = TodoData(
                0,
                mTitle,
                mDescription,
                sharedViewModel.parsPriority(mPriority)
            )
            viewModel.insertData(todoItem)
            Toast.makeText(requireContext(),"Added Successfully",Toast.LENGTH_SHORT)
                .show()
            val action = AddFragmentDirections.actionAddFragmentToListFragment()
            findNavController().navigate(action)
        }else{
            Toast.makeText(requireContext(),"Fill all the fields",Toast.LENGTH_SHORT)
                .show()
        }
    }
}