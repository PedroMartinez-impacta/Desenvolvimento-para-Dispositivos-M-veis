package br.com.murilonovelo.opeproject

import android.content.Context

object TreinosService {
    fun getTreinos (context: Context): List<Treinos> {
        val treinos = mutableListOf<Treinos>()

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
        return treinos
    }
}