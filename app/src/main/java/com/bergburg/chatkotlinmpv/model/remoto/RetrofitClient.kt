package com.bergburg.chatkotlinmpv.model.remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor(){

    companion object{
        private lateinit var INSTACE : Retrofit
        private fun getRetrofitInstace() : Retrofit{
            if(!::INSTACE.isInitialized){
                synchronized(RetrofitClient::class){
                    INSTACE = Retrofit.Builder()
                        .baseUrl("https://apkdoandroidonline.com/appChat/api/")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build()
                }
            }
            return INSTACE
        }

        fun <T> classService(classService : Class<T>) : T {
            return getRetrofitInstace().create(classService)
        }
    }
}