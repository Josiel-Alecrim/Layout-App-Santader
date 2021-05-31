package com.josielsantos.santanderdevweek.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.josielsantos.santanderdevweek.R
import com.josielsantos.santanderdevweek.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()

        //throw RuntimeException("Teste Crash")// Force a crash
        }



    private fun buscarContaCliente() {
        mainViewModel.buscarContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }

    //criando função para exibir os resultados EX: EX01
    private fun bindOnView(conta : Conta){
        //EX01
        findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
        findViewById<TextView>(R.id.tv_conta_corente).text = conta.numero
        findViewById<TextView>(R.id.tv_saldo).text = conta.saldo
        findViewById<TextView>(R.id.tv_limite).text = conta.limite
        findViewById<TextView>(R.id.tv_cartao_final_value).text = conta.cartao.numeroCartao
    }

    // IMPORTANDO ACTIVITY MAIN_MENU
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    // QUANDO ALGUM ITEM DO MENU FOR CLICADO, GERENCIANDO CLIQUES NO MENU
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_1 -> {
                Log.d("CLIQUE", "Clique no item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}