package br.com.murilonovelo.opeproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface TreinosDAO {
    @Query("SELECT * FROM treinos where exerciseId = :exerciseId")
    fun getById(exerciseId: Long) : Treinos?

    @Query("SELECT * FROM treinos")
    fun findAll(): List<Treinos>

    @Insert
    fun insert(disciplina: Treinos)

    @Delete
    fun delete(disciplina: Treinos)

}