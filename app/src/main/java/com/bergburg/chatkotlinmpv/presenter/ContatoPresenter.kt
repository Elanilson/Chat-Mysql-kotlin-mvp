package com.bergburg.chatkotlinmpv.presenter

import com.bergburg.chatkotlinmpv.model.entities.Contato
import com.bergburg.chatkotlinmpv.model.interfaces.APIListener
import com.bergburg.chatkotlinmpv.model.repositorio.ContatoRepositorio
import com.bergburg.chatkotlinmpv.view.interfaces.ContatoView

class ContatoPresenter {
    private val view : ContatoView
    private val repositorio = ContatoRepositorio()

    constructor(view : ContatoView){
        this.view = view
    }

    fun exibirContatos(){
        val listener = object : APIListener<List<Contato>>{
            override fun onSuccess(result: List<Contato>) {
                view.exibirContatos(result)
            }

            override fun onFailures(mensagem: String) {
                view.mensagem(mensagem)
            }
        }

        repositorio.carregarContatos(listener)

    }
}