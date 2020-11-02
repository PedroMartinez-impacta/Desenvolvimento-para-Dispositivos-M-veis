package br.com.murilonovelo.opeproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login.*
import kotlinx.android.synthetic.main.toolbar.*
import com.google.android.material.navigation.NavigationView


class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        val args = intent.extras
        val nomeUsuario = args?.getString("nome_user")
        Toast.makeText(this, "Usuário: $nomeUsuario", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar_view)

        supportActionBar?.title = "Menu Principal"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val intent = Intent(this, TelaBotoes::class.java)
        val params = Bundle()

        button_treinos.setOnClickListener{
            params.putString("nome_disciplina", "Treinos")
            intent.putExtras(params)
            startActivity(intent)
        }

        button_sair.setOnClickListener{
            finish()
        }

        configuraMenuLateral()

    }

    // configuração do navigation Drawer com a toolbar
    private fun configuraMenuLateral() {
        // ícone de menu1 (hamburger) para mostrar o menu1
        var toogle = ActionBarDrawerToggle(this, layoutMenuLateral, toolbar_view, R.string.navigation_drawer_open, R.string.navigation_drawer_close)

        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_sair -> {
                Toast.makeText(this, "Saindo...", Toast.LENGTH_SHORT).show()
                finish()
            }
            R.id.nav_treinos -> {
                Toast.makeText(this, "Acessando Treinos", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, TelaBotoes::class.java)
                val params = Bundle()
                params.putString("nome_disciplina", "Treinos")
                intent.putExtras(params)
                startActivity(intent)
            }
        }

        // fecha menu1 depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
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
}