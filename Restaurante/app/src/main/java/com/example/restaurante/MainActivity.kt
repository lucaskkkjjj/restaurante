package com.example.restaurante

import android.content.Intent
import android.os.Build.VERSION_CODES.O
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.restaurante.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//É usado para vincular elementos da interface do usuário em algum lugar do código.
    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        /*Cria uma instância da classe gerada pelo View binding que chama ActivityLoginBinding,e vincula
        com o layout do "xml" permitindo o fácil acesso nos códigos xml.*/
        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
    /*Esse código define a visualização de tela para um layout especificado no arquivo de layout,
    essa linha de código basicamente exibe a interface do usuário correspondente com o layout
    vinculado.*/
        setContentView(binding.root)

    /*Esse código cria uma variável chamada username e atribui a ela o valor da string extra com a
    chave "username" da intenção (intent). Em seguida, ele verifica se username não é nulo ou vazio.
     */
        val username = intent.extras?.getString("username")

        if(!username.isNullOrEmpty()){
            binding.textOla.setText("Olá $username")
        }
        /*O código binding.buttonFechar.setOnClickListener { finishAffinity() } define um listener
                para o botão chamado buttonFechar.*/
        binding.buttonFechar.setOnClickListener {
            finishAffinity()
        }
        /*Define um listener para o botão chamado buttonPedir. Quando o botão é clicado, a
         função dentro das chaves { ... } é executada. Cria uma nova intenção (ou intent) chamada
         i que aponta para a classe SplashActivity. Adiciona informações extras à intenção: o valor
         do campo de texto editQuantidadePizza é colocado na intenção com a chave "quantidadePizza",
          o valor do campo de texto editQuantidadeSalada é colocado com a chave "quantidadeSalada",
          e o valor do campo de texto editQuantidadeHamburguer é colocado com a chave
          "quantidadeHamburguer". Em seguida, a atividade associada à intenção é iniciada usando
          startActivity(i), e a atividade atual é finalizada com finish().*/

        binding.buttonPedir.setOnClickListener {
            val i = Intent(this, SplashActivity::class.java)
            i.putExtra("quantidadePizza", binding.editQuantidadePizza.text.toString())
            i.putExtra("quantidadeSalada", binding.editQuantidadeSalada.text.toString())
            i.putExtra("quantidadeHamburguer", binding.editQuantidadeHamburguer.text.toString())
            startActivity(i)
            finish()
        }

//O mesmo do código anterior com nomes de código diferente
        binding.checkPizza.setOnClickListener {
            if(binding.checkPizza.isChecked()){
                binding.editQuantidadePizza.setText("1")
                binding.textPrecoPizza.visibility = View.VISIBLE
            }else{
                binding.editQuantidadePizza.setText("0")
                binding.textPrecoPizza.visibility = View.GONE
            }
        }
//O mesmo do código anterior com nomes de código diferente
        binding.checkSalada.setOnClickListener {
            if(binding.checkSalada.isChecked()){
                binding.editQuantidadeSalada.setText("1")
                binding.textPrecoSalada.visibility = View.VISIBLE
            }else{
//esse código define o texto de um campo de edição e oculta um elemento na interface do usuário.
                binding.editQuantidadeSalada.setText("0")
                binding.textPrecoSalada.visibility = View.GONE
            }
        }
/*esse código controla a visibilidade de um campo de edição e um elemento na interface do usuário
com base no estado do botão checkHamburger*/
        binding.checkHamburger.setOnClickListener {
            if(binding.checkHamburger.isChecked()){
                binding.editQuantidadeHamburguer.setText("1")
                binding.textPrecoHamburguer.visibility = View.VISIBLE
            }else{
/*Este código define o texto do campo de edição de quantidade de hambúrguer para
                "0" e torna invisível o texto de preço do hambúrguer.*/
                binding.editQuantidadeHamburguer.setText("0")
                binding.textPrecoHamburguer.visibility = View.GONE
            }
        }

    }
}