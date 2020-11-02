package br.com.murilonovelo.opeproject

import android.content.Intent
import android.icu.util.TimeUnit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*
import android.content.Context

class MainActivity : AppCompatActivity() {
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imgLogin.setImageResource(R.drawable.home1)
        messageLogin.setText(R.string.msg_login)

        /*buttonLogin.setOnClickListener{

            val user = userEditControl.text.toString()
            val password = userPasswordEditControl.text.toString()
            if(user == "aluno" && password == "impacta") {
                Toast.makeText(this, "Bem-Vindo $user, Você logou utilizando a senha $password!", Toast.LENGTH_LONG).show()
                val intent = Intent(this, TelaInicialActivity::class.java)
                val params = Bundle()
                params.putString("nome_user", user)
                params.putString("senha", password)

                intent.putExtras(params)

                startActivity(intent)
            } else {
                Toast.makeText(this, "Usuário ou senha incorreto", Toast.LENGTH_LONG).show()
            }
        }*/


        buttonLogin.setOnClickListener {onClickLogin() }

        // procurar pelas preferências, se pediu para guardar usuário e senha
        var lembrar = Prefs.getBoolean("lembrar")
        if (lembrar) {
            var lembrarNome  = Prefs.getString("lembrarNome")
            var lembrarSenha  = Prefs.getString("lembrarSenha")
            userEditControl.setText(lembrarNome)
            userPasswordEditControl.setText(lembrarSenha)
            checkLembrar.isChecked = lembrar

        }

    }

    fun onClickLogin(){

        val valorUsuario = userEditControl.text.toString()
        val valorSenha = userPasswordEditControl.text.toString()
        if(valorUsuario == "aluno" && valorSenha == "impacta") {
            // armazenar valor do checkbox
            Prefs.setBoolean("lembrar", checkLembrar.isChecked)
            // verificar se é para pembrar nome e senha
            if (checkLembrar.isChecked) {
                Prefs.setString("lembrarNome", valorUsuario)
                Prefs.setString("lembrarSenha", valorSenha)
            } else{
                Prefs.setString("lembrarNome", "")
                Prefs.setString("lembrarSenha", "")
            }

            Toast.makeText(this, "Bem-Vindo $valorUsuario, Você logou utilizando a senha $valorSenha!", Toast.LENGTH_LONG).show()
            val intent = Intent(this, TelaInicialActivity::class.java)
            val params = Bundle()
            params.putString("nome_user", valorUsuario)
            params.putString("senha", valorSenha)

            intent.putExtras(params)

            startActivity(intent)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1) {
            val result = data?.getStringExtra("result")
            Toast.makeText(context, "$result", Toast.LENGTH_LONG).show()
        }
    }
}