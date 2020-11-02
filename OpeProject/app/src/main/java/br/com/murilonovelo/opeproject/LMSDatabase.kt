package br.com.murilonovelo.opeproject

import androidx.room.Database
import androidx.room.RoomDatabase


// anotação define a lista de entidades e a versão do banco
@Database(entities = arrayOf(Treinos::class), version = 1)
abstract class LMSDatabase: RoomDatabase() {
    abstract fun treinosDAO(): TreinosDAO
}