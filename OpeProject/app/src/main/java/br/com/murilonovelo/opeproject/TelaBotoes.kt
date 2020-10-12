package br.com.murilonovelo.opeproject

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_tela_botoes.*
import kotlinx.android.synthetic.main.toolbar.*

class TelaBotoes : DebugActivity() {
    private val context: Context get() = this
    private var treino = listOf<Treinos>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_botoes)

        val args = intent.extras
        val nomeTreinos = args?.getString("nome_treino")

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = nomeTreinos
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerTreinos?.layoutManager = LinearLayoutManager(context)
        recyclerTreinos?.itemAnimator = DefaultItemAnimator()
        recyclerTreinos?.setHasFixedSize(true)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val itemId = item?.itemId

        if (itemId == R.id.action_buscar){
            Toast.makeText(this, "Botão Buscar", Toast.LENGTH_LONG).show()
        } else if (itemId == R.id.action_atualizar){
            Toast.makeText(this, "Botão Atualizar", Toast.LENGTH_LONG).show()
        } else if (itemId == R.id.action_config){
            Toast.makeText(this, "Botão Configurar", Toast.LENGTH_LONG).show()
        } else if (itemId == android.R.id.home){
            finish()
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        taskTreinos()
    }

    fun taskTreinos() {
        treino = TreinosService.getTreinos(context)
        // atualizar lista
        recyclerTreinos?.adapter = TreinoAdapter(treino) {onClickDisciplina(it)}
    }

    fun onClickDisciplina(treino: Treinos) {
        Toast.makeText(context, "Clicou Treino ${treino.nome}", Toast.LENGTH_SHORT).show()
        val intent = Intent(context, TreinoActivity::class.java)
        intent.putExtra("nome_treino", treino)
        startActivity(intent)
    }
}