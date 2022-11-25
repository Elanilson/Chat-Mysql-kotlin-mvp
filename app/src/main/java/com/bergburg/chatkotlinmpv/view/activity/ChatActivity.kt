package com.bergburg.chatkotlinmpv.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.SystemClock
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bergburg.chatkotlinmpv.R
import com.bergburg.chatkotlinmpv.databinding.ActivityChatBinding
import com.bergburg.chatkotlinmpv.model.entities.Mensagem
import com.bergburg.chatkotlinmpv.presenter.MensagemPresenter
import com.bergburg.chatkotlinmpv.view.adapter.MensagemAdapter
import com.bergburg.chatkotlinmpv.view.interfaces.MensagemView
import java.util.*

class ChatActivity : AppCompatActivity(), MensagemView {
    private lateinit var binding: ActivityChatBinding
    private var presenter = MensagemPresenter(this)
    private  var adapter = MensagemAdapter()
    private var idUsuario  : Long  = 1L
    private var idRemetente  : Long  = 1L
    private  var idConversa : Long = 0
    private lateinit var texto : String
    private lateinit var runnable : Runnable
    private var ticker  : Boolean = false
    private var handle = Handler()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageButtonEnviar.setOnClickListener {
            texto = binding.editTextMensagem.text.toString()
            presenter.enviarMensagem(idRemetente,idConversa,texto)
            binding.editTextMensagem.setText("")
        }

        configurarRecycleview()
    }

    private fun  configurarRecycleview(){
        binding.recyclerViewChat.layoutManager = LinearLayoutManager(binding.root.context)
        binding.recyclerViewChat.adapter = adapter

    }
    private fun startClock(){
        var calendar = Calendar.getInstance()
        runnable = Runnable {
            kotlin.run {
                if(!ticker){
                    return@run
                }

                presenter.exibirConversas(idUsuario)

                var now = SystemClock.uptimeMillis()
                var next = now + (1000 - (now % 1000))
                println(now)
                handle.postAtTime(runnable,next)
            }
        }
        runnable.run()

    }

    override fun exibirMensagens(mensagem: List<Mensagem>) {
        adapter.attackMensagens(mensagem)
    }


    override fun mensagem(mensagem: String) {
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
    }


    override fun onResume() {
        super.onResume()

        val bundle = intent.extras
        if(bundle != null){
               idUsuario =  bundle.getLong("idUsuario")
              idConversa =  bundle.getLong("idConversa")
              presenter.exibirConversas(idUsuario)
             ticker = true
             startClock()
        }
    }

    override fun onStop() {
        super.onStop()
        ticker = false
    }
}