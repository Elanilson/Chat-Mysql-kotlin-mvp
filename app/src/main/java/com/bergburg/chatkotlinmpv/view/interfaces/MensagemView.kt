package com.bergburg.chatkotlinmpv.view.interfaces



import com.bergburg.chatkotlinmpv.model.entities.Mensagem

interface MensagemView {
    fun exibirMensagens(mensagem : List<Mensagem>)
    fun mensagem(mensagem : String)
}