package com.rakitov.androidstarterapp.utils

import android.annotation.SuppressLint
import android.content.Context
import com.rakitov.androidstarterapp.R
import com.rakitov.androidstarterapp.model.Actor
import com.rakitov.androidstarterapp.model.Film
import org.json.JSONArray
import org.json.JSONObject

object Constants {
    const val ID = "Id"
}

fun loadJson(context: Context): List<Film> {
    val json = loadJsonFromAssets(context)

    return mapJsonToFilm(json)
}

// =================================================================================================
// = Implementation
// =================================================================================================

private fun loadJsonFromAssets(context: Context): String {
    var result = ""

    runCatching {
        val input = context.assets.open("films.json")
        val size = input.available()
        val bytes = ByteArray(size)
        input.read(bytes)
        input.close()
        result = String(bytes)
    }.onFailure {
        it.printStackTrace()
    }

    return result
}

@SuppressLint("ResourceType")
private fun mapJsonToFilm(json: String): List<Film> {
    val films = mutableListOf<Film>()
    runCatching {
        val filmJson = JSONObject(json).getJSONArray("films")

        for (i in 0 until filmJson.length()) {
            val filmJson = filmJson.getJSONObject(i)
            val film = Film(
                id = filmJson.getInt("id"),
                name = filmJson.getString("name"),
                photo = getResId(filmJson.getString("photo"), R.drawable::class.java)!!,
                date_publication = filmJson.getString("date_publication"),
                rating = filmJson.getString("rating").toFloat(),
                description = filmJson.getString("description"),
                actors = getActors(filmJson.getJSONArray("actors"))
            )
            films.add(film)
        }
    }.onFailure {
        it.printStackTrace()
    }

    return films
}

private fun getActors(array: JSONArray): List<Actor> {
    val actors = mutableListOf<Actor>()

    for (i in 0 until array.length()) {
        val actorsArray = array.getJSONObject(i)
        val actor = Actor(
            name = actorsArray.getString("name"),
            photo = getResId(actorsArray.getString("photo"), R.drawable::class.java)!!
        )
        actors.add(actor)
    }

    return actors
}

inline fun <reified T> getResId(resName: String, clazz: Class<T>): Int? {

    var result: Int = 0

    runCatching {
        val field = clazz.getDeclaredField(resName)
        result = field.getInt(field)
    }.onFailure { return null }
    return result
}