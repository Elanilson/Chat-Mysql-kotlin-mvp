package com.bergburg.chatkotlinmpv.presenter

import com.bergburg.chatkotlinmpv.model.entities.Contato
import com.bergburg.chatkotlinmpv.model.entities.Conversa
import com.bergburg.chatkotlinmpv.model.interfaces.APIListener
import com.bergburg.chatkotlinmpv.model.repositorio.ContatoRepositorio
import com.bergburg.chatkotlinmpv.model.repositorio.ConversaRepositorio
import com.bergburg.chatkotlinmpv.view.interfaces.ContatoView
import com.bergburg.chatkotlinmpv.view.interfaces.ConversaView

class ConversaPresenter {
    private val view : ConversaView
    private val repositorio = ConversaRepositorio()

    constructor(view : ConversaView){
        this.view = view
    }

    fun exibirConversas(){
        val listener = object : APIListener<List<Conversa>>{
            override fun onSuccess(result: List<Conversa>) {
                view.exibirConversas(result)
            }

            override fun onFailures(mensagem: String) {
                view.mensagem(mensagem)
            }
        }

        repositorio.carregarConversas(listener)

    }
}