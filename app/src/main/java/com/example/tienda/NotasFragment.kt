package com.example.tienda

import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.tienda.databinding.FragmentNotasBinding
import java.time.LocalDate



class NotasFragment : Fragment(R.layout.fragment_notas) {
    private var listaNotas = listOf(Nota("RecyclerView","RecyclerView facilita que se muestren de manera eficiente grandes conjuntos de datos. Tú proporcionas los datos y defines el aspecto de cada elemento, y la biblioteca RecyclerView creará los elementos de forma dinámica cuando se los necesite."),
        Nota("Compatibilidad","Android 11 introdujo nuevas herramientas para desarrolladores que permiten probar y depurar una app en función de cambios de comportamiento en las versiones más recientes de la plataforma de Android. Estas herramientas forman parte de un marco de compatibilidad que permite a los desarrolladores de apps activar y desactivar cambios rotundos de manera individual desde las opciones para desarrolladores o ADB. Usa esta flexibilidad durante la etapa de preparación para orientar tu contenido a la última versión estable de la API y probar la app con la versión preliminar del próximo lanzamiento de Android."),
        Nota("Intents","Una intent permite iniciar una actividad en otra app mediante la descripción de una acción simple que desees realizar (como \"ver un mapa\" o \"tomar una foto\") en un objeto Intent. Este tipo de intent se conoce como intent implícita porque no especifica el componente de la app que se iniciará, sino una acción, y brinda algunos datos con los que debe realizarse la acción. Al llamar a startActivity() o startActivityForResult() y pasarle una intent implícita, el sistema resuelve la intent en una aplicación que puede manejarla e iniciar su Activity correspondiente. Si existe más de una app que puede manejar la intent, el sistema presenta al usuario un cuadro de diálogo para que elija la app que desea usar."),
        Nota("Widgets","Los widgets son un aspecto esencial de la personalización de la pantalla principal. Piensa que son como vistas rápidas de los datos y las funcionalidades más importantes de una app, a los que se puede acceder de forma directa desde la pantalla principal del usuario. Los usuarios pueden mover widgets en los paneles de la pantalla principal y, si la función es compatible, cambiarles el tamaño para adaptar la cantidad de información que se debe incluir en un widget según sus preferencias. En esta página, se proporciona una introducción a los diferentes tipos de widgets que puedes crear y algunos principios de diseño que debes seguir. Para comenzar a crear el widget de una app"),
        Nota("RecyclerView","RecyclerView facilita que se muestren de manera eficiente grandes conjuntos de datos. Tú proporcionas los datos y defines el aspecto de cada elemento, y la biblioteca RecyclerView creará los elementos de forma dinámica cuando se los necesite."),
        Nota("Compatibilidad","Android 11 introdujo nuevas herramientas para desarrolladores que permiten probar y depurar una app en función de cambios de comportamiento en las versiones más recientes de la plataforma de Android. Estas herramientas forman parte de un marco de compatibilidad que permite a los desarrolladores de apps activar y desactivar cambios rotundos de manera individual desde las opciones para desarrolladores o ADB. Usa esta flexibilidad durante la etapa de preparación para orientar tu contenido a la última versión estable de la API y probar la app con la versión preliminar del próximo lanzamiento de Android."),
        Nota("Intents","Una intent permite iniciar una actividad en otra app mediante la descripción de una acción simple que desees realizar (como \"ver un mapa\" o \"tomar una foto\") en un objeto Intent. Este tipo de intent se conoce como intent implícita porque no especifica el componente de la app que se iniciará, sino una acción, y brinda algunos datos con los que debe realizarse la acción. Al llamar a startActivity() o startActivityForResult() y pasarle una intent implícita, el sistema resuelve la intent en una aplicación que puede manejarla e iniciar su Activity correspondiente. Si existe más de una app que puede manejar la intent, el sistema presenta al usuario un cuadro de diálogo para que elija la app que desea usar."),
        Nota("Widgets","Los widgets son un aspecto esencial de la personalización de la pantalla principal. Piensa que son como vistas rápidas de los datos y las funcionalidades más importantes de una app, a los que se puede acceder de forma directa desde la pantalla principal del usuario. Los usuarios pueden mover widgets en los paneles de la pantalla principal y, si la función es compatible, cambiarles el tamaño para adaptar la cantidad de información que se debe incluir en un widget según sus preferencias. En esta página, se proporciona una introducción a los diferentes tipos de widgets que puedes crear y algunos principios de diseño que debes seguir. Para comenzar a crear el widget de una app"),
        Nota("RecyclerView","RecyclerView facilita que se muestren de manera eficiente grandes conjuntos de datos. Tú proporcionas los datos y defines el aspecto de cada elemento, y la biblioteca RecyclerView creará los elementos de forma dinámica cuando se los necesite."),
        Nota("Compatibilidad","Android 11 introdujo nuevas herramientas para desarrolladores que permiten probar y depurar una app en función de cambios de comportamiento en las versiones más recientes de la plataforma de Android. Estas herramientas forman parte de un marco de compatibilidad que permite a los desarrolladores de apps activar y desactivar cambios rotundos de manera individual desde las opciones para desarrolladores o ADB. Usa esta flexibilidad durante la etapa de preparación para orientar tu contenido a la última versión estable de la API y probar la app con la versión preliminar del próximo lanzamiento de Android."),
        Nota("Intents","Una intent permite iniciar una actividad en otra app mediante la descripción de una acción simple que desees realizar (como \"ver un mapa\" o \"tomar una foto\") en un objeto Intent. Este tipo de intent se conoce como intent implícita porque no especifica el componente de la app que se iniciará, sino una acción, y brinda algunos datos con los que debe realizarse la acción. Al llamar a startActivity() o startActivityForResult() y pasarle una intent implícita, el sistema resuelve la intent en una aplicación que puede manejarla e iniciar su Activity correspondiente. Si existe más de una app que puede manejar la intent, el sistema presenta al usuario un cuadro de diálogo para que elija la app que desea usar."),
        Nota("Widgets","Los widgets son un aspecto esencial de la personalización de la pantalla principal. Piensa que son como vistas rápidas de los datos y las funcionalidades más importantes de una app, a los que se puede acceder de forma directa desde la pantalla principal del usuario. Los usuarios pueden mover widgets en los paneles de la pantalla principal y, si la función es compatible, cambiarles el tamaño para adaptar la cantidad de información que se debe incluir en un widget según sus preferencias. En esta página, se proporciona una introducción a los diferentes tipos de widgets que puedes crear y algunos principios de diseño que debes seguir. Para comenzar a crear el widget de una app"))

    // Inicializamos la variable anterior
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentNotasBinding.bind(view)
        binding.recview.adapter = NotasAdapter(listaNotas){
            Toast.makeText(requireContext(), it.titulo, Toast.LENGTH_SHORT).show()
        }


    }


}