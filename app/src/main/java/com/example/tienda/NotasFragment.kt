package com.example.tienda

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import com.example.tienda.databinding.FragmentNotasBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDate



class NotasFragment : Fragment(R.layout.fragment_notas) {
    private val adapter = NotasAdapter(){ Toast.makeText(requireContext(), it.titulo, Toast.LENGTH_SHORT).show() }
    private lateinit var binding : FragmentNotasBinding

    /* Inicializamos la variable anterior
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentNotasBinding.bind(view)

        binding.recview.adapter = adapter

        if(adapter.itemCount == 0) {
            loadItems()
        }


    }

    private fun loadItems(){
        Log.i("LOG ----", "holaaa")

        // Nos permite iniciar una corrutina
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            binding.progress.visibility = View.VISIBLE

            //Obtenemos la lista de notas GRACIAS A CORRUTINA
            val notas = withContext(Dispatchers.IO){
                NotasProvider.getNotas()
            }
            Log.i("LOG ----", notas.toString())
            adapter.notas = notas

            // Actualizamos datos
            adapter.notifyDataSetChanged()
            binding.progress.visibility = View.GONE
        }
    }


}