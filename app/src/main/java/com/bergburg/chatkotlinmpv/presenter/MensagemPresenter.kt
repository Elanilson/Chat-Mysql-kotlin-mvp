package com.bergburg.chatkotlinmpv.presenter

import com.bergburg.chatkotlinmpv.model.entities.Contato
import com.bergburg.chatkotlinmpv.model.entities.Conversa
import com.bergburg.chatkotlinmpv.model.entities.Dados
import com.bergburg.chatkotlinmpv.model.entities.Mensagem
import com.bergburg.chatkotlinmpv.model.interfaces.APIListener
import com.bergburg.chatkotlinmpv.model.repositorio.ContatoRepositorio
import com.bergburg.chatkotlinmpv.model.repositorio.ConversaRepositorio
import com.bergburg.chatkotlinmpv.model.repositorio.MensagensRepositorio
import com.bergburg.chatkotlinmpv.view.interfaces.ContatoView
import com.bergburg.chatkotlinmpv.view.interfaces.ConversaView
import com.bergburg.chatkotlinmpv.view.interfaces.MensagemView

    class MensagemPresenter {
    private val view : MensagemView
    private val repositorio = MensagensRepositorio()

    constructor(view : MensagemView){
        this.view = view
    }

    fun exibirConversas(idUSuario : Long){
        val listener = object : APIListener<List<Mensagem>>{
            override fun onSuccess(result: List<Mensagem>) {
                view.exibirMensagens(result)
            }

            override fun onFailures(mensagem: String) {
                view.mensagem(mensagem)
            }
        }

        repositorio.carregarConversas(listener,idUSuario)

    }

    fun enviarMensagem(idUsuario : Long, idConversa : Long, texto : String){
        if(texto.isNotBlank() && texto.isNotEmpty()){
            if(idUsuario != null){
                if(idConversa != null){
                    val listener = object : APIListener<Dados>{
                        override fun onSuccess(result: Dados) {
                           if(result.status){
                               view.mensagem("Sucesso")
                           }else{
                               view.mensagem("Não foi possível enviar")
                           }
                        }

                        override fun onFailures(mensagem: String) {
                            view.mensagem(mensagem)
                        }
                    }
                    repositorio.enviarMensagem(listener,idUsuario,texto,idConversa)
                }else{
                    view.mensagem("Falta o ID da conversa")
                }
            }else{
                view.mensagem("Falta o ID do usuário")
            }
        }else{
            view.mensagem("Sem texto")
        }
    }
}