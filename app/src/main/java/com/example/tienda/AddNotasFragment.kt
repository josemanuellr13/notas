package com.example.tienda

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tienda.databinding.FragmentAddNotasBinding
import com.example.tienda.databinding.FragmentNotasBinding


class AddNotasFragment : Fragment(R.layout.fragment_add_notas) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentAddNotasBinding.bind(view)

        binding.btnAddNote.setOnClickListener(){
            val transiction = requireActivity().supportFragmentManager.beginTransaction()
            transiction.replace(R.id.fragment,NotasFragment())
            transiction.commit()
        }



    }


}