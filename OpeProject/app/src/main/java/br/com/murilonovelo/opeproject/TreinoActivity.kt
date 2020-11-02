package br.com.murilonovelo.opeproject

import android.os.Bundle
import android.util.Log
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_treinos.*
import kotlinx.android.synthetic.main.toolbar.*

class TreinoActivity: DebugActivity() {

    var treino: Treinos? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treinos)

        treino = intent.getSerializableExtra("nome_treino") as Treinos

        Log.d("LMSAPP", treino.toString())
        setSupportActionBar(toolbar_view)

        supportActionBar?.title = treino?.exerciseName
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nomeTreino.text = treino?.exerciseName
    }


}