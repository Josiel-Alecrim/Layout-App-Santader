package com.josielsantos.santanderdevweek.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.josielsantos.santanderdevweek.data.Conta
import com.josielsantos.santanderdevweek.data.local.FakeData

class MainViewModel : ViewModel() {

    //RESPONSÁVEL POR SETAR OS VALORES
    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscarContaCliente() : LiveData<Conta> {
        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData
    }

}