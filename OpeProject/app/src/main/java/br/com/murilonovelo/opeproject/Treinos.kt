package br.com.murilonovelo.opeproject

import java.io.Serializable
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "treinos")
class Treinos : Serializable {

    @PrimaryKey
    var exerciseId:Long = 0
    var exerciseName = ""
    var duration = ""
    var series = ""
    var day = ""

    override fun toString(): String {
        return "Exercicio(Nome: $exerciseName, Dia: $day, Séries: $series, Duração: $duration)"
    }
}