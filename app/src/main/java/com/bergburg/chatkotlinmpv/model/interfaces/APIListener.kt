package com.bergburg.chatkotlinmpv.model.interfaces

interface APIListener <T> {
    fun onSuccess(result: T)
    fun onFailures(mensagem : String)
}