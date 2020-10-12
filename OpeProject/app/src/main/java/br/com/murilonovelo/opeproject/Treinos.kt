package br.com.murilonovelo.opeproject

import java.io.Serializable

class Treinos : Serializable {

    var id:Long = 0
    var nome = ""
    var foto = ""
    var series = ""

    override fun toString(): String {
        return "Exercicio(nome='$nome')"
    }
}