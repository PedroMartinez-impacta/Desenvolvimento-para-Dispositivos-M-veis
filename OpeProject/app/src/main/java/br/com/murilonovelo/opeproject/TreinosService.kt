package br.com.murilonovelo.opeproject

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONArray
import org.json.JSONObject
import java.net.URL


val host = "https://api-gerenciamento-personal.herokuapp.com"
val TAG = "WS_LMSApp"
object TreinosService {
    fun getTreinos (context: Context): List<Treinos> {
        /*val treinos = mutableListOf<Treinos>()

        for (i in 1..2) {
            val d = Treinos()

            if(i == 1){
                d.nome = "Supino Reto"
                d.foto = "https://anilhasfitness.com.br/wp-content/uploads/supino-reto-anilhas.jpg"
            }else if(i == 2){
                d.nome = "Rosca Direta"
                d.foto = "https://dicasdemusculacao.org/wp-content/uploads/2017/07/rosca-direta.jpg"
            }
            d.series = "3 x 10"
            treinos.add(d)
        }
        return treinos*/

        if (AndroidUtils.isInternetDisponivel(context)){
            val url = "$host/treinos/112"
            val json = URL(url).readText()
            Log.d(TAG, json)
            //return ArrayList()

            val jsonObj = JSONObject(json)
            val ja: JSONArray = jsonObj.getJSONArray("exercises")
            val len = ja.length()

            val treinos = mutableListOf<Treinos>()
            for (j in 0 until len) {
                val t = Treinos()
                val json_aux = ja.getJSONObject(j)
                t.exerciseId = json_aux.getLong("exerciseId")
                t.exerciseName = json_aux.getString("exerciseName")
                t.day = json_aux.getString("day")
                t.series = json_aux.getString("series")
                t.duration = json_aux.getString("duration")
                treinos.add(t)
            }

            for (t in treinos) {
                saveOffline(t)
            }

            return treinos

        } else {
            val dao = DatabaseManager.getTreinosDAO()
            val treinos = dao.findAll()
            return treinos
        }

    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }

    fun saveOffline(treino: Treinos) : Boolean {
        val dao = DatabaseManager.getTreinosDAO()
        if (! existeTreino(treino)) {
            dao.insert(treino)
        }
        return true
    }
    fun existeTreino(treino: Treinos): Boolean {
        val dao = DatabaseManager.getTreinosDAO()
        return dao.getById(treino.exerciseId) != null
    }
}
