package br.com.murilonovelo.opeproject

import android.content.Intent
import android.icu.util.TimeUnit
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        imgLogin.setImageResource(R.drawable.academia)
        messageLogin.setText(R.string.msg_login)

        buttonLogin.setOnClickListener{

            progress.visibility = View.VISIBLE

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

                progress.visibility = View.GONE
            } else {
                Toast.makeText(this, "Usuário ou senha incorreto", Toast.LENGTH_LONG).show()
            }
        }

    }
}