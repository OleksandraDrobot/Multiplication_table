package com.example.lab61

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.lab61.databinding.FragmentTableBinding

private const val ARG_PARAM1 = "parameter1"
private const val ARG_PARAM2 = "parameter2"

class TableFragment : Fragment(R.layout.fragment_table) {

    private var parameter1: Int? = 1
    private var parameter2: String? = "1"
    private var _binding: FragmentTableBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            parameter1 = it.getInt(ARG_PARAM1)
            parameter2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTableBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val view = binding.root
        val context = view.context
        for (i in 1..10) {
            val id1 = context.resources.getIdentifier("number$i", "id", context.packageName)
            val firstNumber = view.findViewById<TextView>(id1)
            val id2 = context.resources.getIdentifier("tvResult$i", "id", context.packageName)
            val result = view.findViewById<TextView>(id2)

            firstNumber.text = parameter1.toString()
            var a = parameter1?.times(i)
            result.text = a.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance(parameter1: Int, parameter2: String) =
            TableFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, parameter1)
                    putString(ARG_PARAM2, parameter2)
                }
            }
    }
}