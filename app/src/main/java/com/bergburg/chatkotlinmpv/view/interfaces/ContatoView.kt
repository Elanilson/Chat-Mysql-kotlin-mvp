package com.bergburg.chatkotlinmpv.view.interfaces

import com.bergburg.chatkotlinmpv.model.entities.Contato

interface ContatoView {
    fun exibirContatos(contatos : List<Contato>)
    fun mensagem(mensagem : String)
}