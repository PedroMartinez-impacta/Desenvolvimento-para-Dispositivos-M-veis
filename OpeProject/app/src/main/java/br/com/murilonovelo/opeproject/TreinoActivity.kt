package br.com.murilonovelo.opeproject

import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_treinos.*
import kotlinx.android.synthetic.main.toolbar.*

class TreinoActivity: DebugActivity() {

    var treino: Treinos? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_treinos)

        treino = intent.getSerializableExtra("nome_treino") as Treinos

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = treino?.nome
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nomeTreino.text = treino?.nome
        Picasso.with(this).load(treino?.foto).fit().into(imagemTreino,
            object: com.squareup.picasso.Callback{
                override fun onSuccess() {}
                override fun onError() { }
            })
    }


}