package com.josielsantos.santanderdevweek.data.local

import com.josielsantos.santanderdevweek.data.Cartao
import com.josielsantos.santanderdevweek.data.Cliente
import com.josielsantos.santanderdevweek.data.Conta

class FakeData{

    fun getLocalData(): Conta {
        val cliente = Cliente("Olá, Sr.Josiel Alecrim")
        val cartao = Cartao("1234-5678-9000")

        return Conta(
            "123456-7",
            "1234",
            "5.555,50",
            "10.000,00",
            cliente,
            cartao
        );
    }
}