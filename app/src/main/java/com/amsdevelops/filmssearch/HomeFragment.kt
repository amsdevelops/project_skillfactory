package com.amsdevelops.filmssearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*

class HomeFragment : Fragment() {
    private lateinit var filmsAdapter: FilmListRecyclerAdapter
    private val filmsDataBase = listOf(
        Film("The Shawshank Redemption", R.drawable.shawshank, "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency."),
        Film("The Godfather", R.drawable.god_father, "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son."),
        Film("The Dark Knight", R.drawable.dark_knight, "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests of his ability to fight injustice."),
        Film("Pulp Fiction", R.drawable.pulp, "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption."),
        Film("Inception", R.drawable.inception, "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O."),
        Film("Hamilton", R.drawable.hamilton, "The real life of one of America's foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from the Richard Rodgers Theater with the original Broadway cast."),
        Film("Gisaengchung", R.drawable.parasites, "Greed and class discrimination threaten the newly formed symbiotic relationship between the wealthy Park family and the destitute Kim clan."),
        Film("Interstellar", R.drawable.interstellar, "A team of explorers travel through a wormhole in space in an attempt to ensure humanity's survival."),
        Film("Joker", R.drawable.joker, "In Gotham City, mentally troubled comedian Arthur Fleck is disregarded and mistreated by society. He then embarks on a downward spiral of revolution and bloody crime. This path brings him face-to-face with his alter-ego: the Joker."),
        Film("1917", R.drawable.seventy, "April 6th, 1917. As a regiment assembles to wage war deep in enemy territory, two soldiers are assigned to race against time and deliver a message that will stop 1,600 men from walking straight into a deadly trap.")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        search_view.setOnClickListener {
            search_view.isIconified = false
        }

        //Подключаем слушателя изменений введенного текста в поиска
        search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            //Этот метод отрабатывает при нажатии кнопки "поиск" на софт клавиатуре
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }
            //Этот метод отрабатывает на каждое изменения текста
            override fun onQueryTextChange(newText: String): Boolean {
                //Если ввод пуст то вставляем в адаптер всю БД
                if (newText.isEmpty()) {
                    filmsAdapter.addItems(filmsDataBase)
                    return true
                }
                //Фильтруем список на поискк подходящих сочетаний
                val result = filmsDataBase.filter {
                    //Чтобы все работало правильно, нужно и запроси и имя фильма приводить к нижнему регистру
                    it.title.toLowerCase(Locale.getDefault()).contains(newText.toLowerCase(Locale.getDefault()))
                }
                //Добавляем в адаптер
                filmsAdapter.addItems(result)
                return true
            }
        })

        //находим наш RV
        initRecyckler()
        //Кладем нашу БД в RV
        filmsAdapter.addItems(filmsDataBase)
    }

    private fun initRecyckler() {
        main_recycler.apply {
            filmsAdapter =
                FilmListRecyclerAdapter(object : FilmListRecyclerAdapter.OnItemClickListener {
                    override fun click(film: Film) {
                        (requireActivity() as MainActivity).launchDetailsFragment(film)
                    }
                })
            //Присваиваем адаптер
            adapter = filmsAdapter
            //Присвои layoutmanager
            layoutManager = LinearLayoutManager(requireContext())
            //Применяем декоратор для отступов
            val decorator = TopSpacingItemDecoration(8)
            addItemDecoration(decorator)
        }
    }

}