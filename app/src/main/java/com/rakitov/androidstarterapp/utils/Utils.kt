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
    //TODO("Обработку ошибок добавлю в блоке по обработке Retrofit")
    return runCatching {
        JSONObject(json).getJSONArray("films")
            .toList()
            .map {
                Film(
                    id = it.getInt("id"),
                    name = it.getString("name"),
                    photo = getResId(it.getString("photo"), R.drawable::class.java)!!,
                    date_publication = it.getString("date_publication"),
                    rating = it.getString("rating").toFloat(),
                    description = it.getString("description"),
                    actors = getActors(it.getJSONArray("actors"))
                )
            }
    }.mapSuccess(::getFieldOrThrowable)
}

private fun getActors(array: JSONArray): List<Actor> {
    //TODO("Обработку ошибок добавлю в блоке по обработке Retrofit")
    return runCatching {
        array
            .toList()
            .map {
                Actor(
                    name = it.getString("name"),
                    photo = getResId(it.getString("photo"), R.drawable::class.java)!!
                )
            }
    }.mapSuccess(::getFieldOrThrowable)
}

inline fun <reified T> getResId(resName: String, clazz: Class<T>): Int? {

    var result = 0

    runCatching {
        val field = clazz.getDeclaredField(resName)
        result = field.getInt(field)
    }.onFailure { return null }
    return result
}

private fun JSONArray.toList(): List<JSONObject> {
    val jSONObjects = mutableListOf<JSONObject>()
    for (i in 0 until length()) {
        jSONObjects.add(getJSONObject(i))
    }
    return jSONObjects
}

private inline fun <S, R : Any> Result<S>.mapSuccess(block: (Result<S>) -> R): R =
    when {
        isSuccess -> block(this)
        else -> throw IllegalStateException()
    }

private fun <T> getFieldOrThrowable(result: Result<T>): T {
    return result.getOrNull() ?: throw IllegalArgumentException()
}