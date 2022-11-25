package com.bergburg.chatkotlinmpv.view.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bergburg.chatkotlinmpv.R
import com.bergburg.chatkotlinmpv.databinding.FragmentConversasBinding
import com.bergburg.chatkotlinmpv.model.entities.Conversa
import com.bergburg.chatkotlinmpv.model.interfaces.APIListener
import com.bergburg.chatkotlinmpv.presenter.ConversaPresenter
import com.bergburg.chatkotlinmpv.view.activity.ChatActivity
import com.bergburg.chatkotlinmpv.view.adapter.ConversaAdapter
import com.bergburg.chatkotlinmpv.view.interfaces.ConversaView
import com.bergburg.chatkotlinmpv.view.listener.AcaoListener


class ConversasFragment : Fragment(), ConversaView{
    private lateinit var binding: FragmentConversasBinding
    private val presenter = ConversaPresenter(this)
    private val adapter = ConversaAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentConversasBinding.inflate(layoutInflater, container, false)
        configurarRecycleview();

        val listener = object : AcaoListener<Conversa>{
            override fun onClick(objeto: Conversa) {

                val bundle = Bundle()
               // bundle.putLong("idUsuario",5L) // teste
                bundle.putLong("idUsuario",objeto.idUsuario)
                bundle.putLong("idConversa",objeto.id)
                val intent = Intent(binding.root.context,ChatActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }

        adapter.attackListener(listener)
        return binding.root
    }

    private fun  configurarRecycleview(){
        binding.recyclerViewConversa.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerViewConversa.adapter = adapter
    }

    override fun exibirConversas(conversa: List<Conversa>) {
        adapter.attackConversas(conversa)
    }

    override fun mensagem(mensagem: String) {
        Toast.makeText(requireContext(), mensagem, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        presenter.exibirConversas()
    }


}