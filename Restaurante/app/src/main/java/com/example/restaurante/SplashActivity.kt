package com.example.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.core.os.postDelayed

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    /*Essa linha de código está dizendo ao sistema Android para usar o layout definido no
     arquivo activity_splash.xml como a interface de usuário para a atividade de splash.
     Quando o aplicativo é iniciado, a tela de splash é exibida com base nesse layout específico.*/
        setContentView(R.layout.activity_splash)
    /*esse código aguarda 200 milissegundos e, em seguida, inicia a atividade PedidoActivity com os
     dados da intent original. Isso é útil para realizar transições suaves entre diferentes telas
      em um aplicativo Android.*/

       Handler(Looper.getMainLooper()).postDelayed({
           val i =  intent
           val j = Intent(this,PedidoActivity::class.java)
           j.putExtras(i)
           startActivity(j)
           finish()
       },200)

        }
}