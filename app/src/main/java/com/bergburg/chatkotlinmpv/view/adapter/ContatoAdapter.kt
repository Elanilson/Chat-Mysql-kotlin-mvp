package com.bergburg.chatkotlinmpv.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bergburg.chatkotlinmpv.R
import com.bergburg.chatkotlinmpv.model.entities.Contato
import com.bergburg.chatkotlinmpv.view.viewholder.ContatoViewHolder

class ContatoAdapter : RecyclerView.Adapter<ContatoViewHolder>() {
    private var contatos : List<Contato> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContatoViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.layout_contato,parent,false)
        return  ContatoViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ContatoViewHolder, position: Int) {
        holder.bind(contatos[position])
    }

    override fun getItemCount(): Int {
        return contatos.size
    }

    fun attackContatos(contatos : List<Contato>){
        this.contatos = contatos
        notifyDataSetChanged()
    }
}