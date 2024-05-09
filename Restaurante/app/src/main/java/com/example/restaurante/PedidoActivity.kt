package com.example.restaurante

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.restaurante.databinding.ActivityPedidoBinding

class PedidoActivity : AppCompatActivity() {
    //É usado para vincular elementos da interface do usuário em algum lugar do código.
    private lateinit var binding: ActivityPedidoBinding
/*O onCreate é responsável por configurar a atividade quando ela é criada ou
recriada, e o savedInstanceState permite restaurar o estado anterior da atividade, evitando
a perda de informações importantes.*/

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityPedidoBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
// O código está processando informações da intenção e convertendo strings em valores numéricos.
        val i = intent
        val quantidadePizza = i.getStringExtra("quantidadePizza").toString().toInt()
        val quantidadeSalada = i.getStringExtra("quantidadeSalada").toString().toInt()
        val quantidadeHamburguer = i.getStringExtra("quantidadeHamburguer").toString().toInt()
//Esse código em Kotlin está criando uma string chamada texto que contém um resumo de um pedido
        val texto = "Resumo do pedido\n" +
        "Pizza: $quantidadePizza Preço: ${quantidadePizza*8}\n" +
        "Salada: $quantidadeSalada Preço: ${quantidadeSalada*10}\n" +
        "Hamburguer: $quantidadeHamburguer Preço: ${quantidadeHamburguer*12}\n"
/*Esse código está atribuindo o valor da string texto à propriedade textResumo de algum objeto
chamado binding. Basicamente, ele está atualizando o conteúdo exibido em algum elemento de interface
 do usuário (UI) com o texto contido na variável texto.*/
        binding.textResumo.text = texto

    }
}