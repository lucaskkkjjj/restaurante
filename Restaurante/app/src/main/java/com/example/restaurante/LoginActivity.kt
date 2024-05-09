package com.example.restaurante

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    //É usado para vincular elementos da interface do usuário em algum lugar do código.
    private lateinit var binding:ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        /*Cria uma instância da classe gerada pelo View binding que chama ActivityLoginBinding,e vincula
        com o layout do "xml" permitindo o fácil acesso nos códigos xml.*/
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
    /*Esse código define a visualização de tela para um layout especificado no arquivo de layout,
    essa linha de código basicamente exibe a interface do usuário correspondente com o layout
    vinculado.*/
        setContentView(binding.root)
        /*Esse código lida com a entrada de dados do usuário relacionada a um formulário
        de login ou algo semelhante.*/
        binding.buttonEntrar.setOnClickListener {
            val username = binding.editUsername.text.toString().trim()
            val password = binding.editPassword.text.toString().trim()
        /*Esse código verifica se o nome de usuário (username) é “abc” e a senha (password) é “123”.
         Se ambas as condições forem verdadeiras, ele abre uma nova tela chamada MainActivity e
         envia o nome de usuário como um extra. Caso contrário, ele executa o código dentro do bloco
          else.*/

            if (username.equals("abc") && password.equals("123")) {
                val i = Intent(this, MainActivity::class.java)
                i.putExtra("username", username)
                startActivity(i)
                finish()
            } else {
                /*Esse código em uma única linha exibe um **toast** (uma pequena notificação
                temporária) com o texto "Errou" e duração longa (definida por `Toast.LENGTH_LONG`)
                 no contexto da aplicação. O método `makeText()` cria o toast e o método `show()`
                 o exibe na tela.*/

                Toast.makeText(applicationContext, "Errou", Toast.LENGTH_LONG).show()
            }
        }

    }
}