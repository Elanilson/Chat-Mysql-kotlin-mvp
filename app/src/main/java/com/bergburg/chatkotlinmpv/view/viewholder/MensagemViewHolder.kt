package com.bergburg.chatkotlinmpv.view.viewholder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bergburg.chatkotlinmpv.R
import com.bergburg.chatkotlinmpv.model.entities.Contato
import com.bergburg.chatkotlinmpv.model.entities.Conversa
import com.bergburg.chatkotlinmpv.model.entities.Mensagem
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class MensagemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private lateinit var nome : TextView
    private lateinit var data : TextView

    fun bind(mensagem: Mensagem){


        nome = itemView.findViewById(R.id.textMensagemTexto)
        data = itemView.findViewById(R.id.textViewData)

        nome.setText(mensagem.texto)
        data.setText(mensagem.data_create)



    }
}