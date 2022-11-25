package com.bergburg.chatkotlinmpv.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bergburg.chatkotlinmpv.R
import com.bergburg.chatkotlinmpv.model.entities.Contato
import com.bergburg.chatkotlinmpv.model.entities.Conversa
import com.bergburg.chatkotlinmpv.view.listener.AcaoListener
import com.bergburg.chatkotlinmpv.view.viewholder.ContatoViewHolder
import com.bergburg.chatkotlinmpv.view.viewholder.ConversaViewHolder

class ConversaAdapter : RecyclerView.Adapter<ConversaViewHolder>() {
    private var conversas : List<Conversa> = listOf()
    private lateinit var listener: AcaoListener<Conversa>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConversaViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.layout_conversa,parent,false)
        return  ConversaViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ConversaViewHolder, position: Int) {
        holder.bind(conversas[position],listener)
    }

    override fun getItemCount(): Int {
        return conversas.size
    }

    fun attackConversas(conversas : List<Conversa>){
        this.conversas = conversas
        notifyDataSetChanged()
    }
    fun attackListener(listener: AcaoListener<Conversa>){
        this.listener = listener
    }
}