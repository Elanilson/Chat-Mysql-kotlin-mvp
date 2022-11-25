package com.bergburg.chatkotlinmpv.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bergburg.chatkotlinmpv.R
import com.bergburg.chatkotlinmpv.databinding.FragmentContatosBinding
import com.bergburg.chatkotlinmpv.model.entities.Contato
import com.bergburg.chatkotlinmpv.presenter.ContatoPresenter
import com.bergburg.chatkotlinmpv.view.adapter.ContatoAdapter
import com.bergburg.chatkotlinmpv.view.interfaces.ContatoView

class ContatosFragment : Fragment() ,ContatoView {
    private lateinit var binding: FragmentContatosBinding
    private val presenter = ContatoPresenter(this)
    private val adapter = ContatoAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentContatosBinding.inflate(layoutInflater,container,false)

        configurarRecycleview()

        return  binding.root
    }

    private fun  configurarRecycleview(){
        binding.recyclerViewContatos.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerViewContatos.adapter = adapter

    }

    override fun exibirContatos(contatos: List<Contato>) {
        adapter.attackContatos(contatos)
    }

    override fun mensagem(mensagem: String) {
        Toast.makeText(requireContext(), mensagem, Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        presenter.exibirContatos()
    }

}