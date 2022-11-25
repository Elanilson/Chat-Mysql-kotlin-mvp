package com.bergburg.chatkotlinmpv.view.interfaces


import com.bergburg.chatkotlinmpv.model.entities.Conversa

interface ConversaView {
    fun exibirConversas(conversa : List<Conversa>)
    fun mensagem(mensagem : String)
}