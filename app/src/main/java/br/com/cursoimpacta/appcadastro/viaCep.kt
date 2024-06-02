package br.com.cursoimpacta.appcadastro

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface viaCep {
    @GET("{cep}/json/")
    suspend fun fetchCep(@Path("cep") cep: String): retrofit2.Response<CepResponse>

    companion object {
        fun create(): viaCep {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://viacep.com.br/ws/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(viaCep::class.java)
        }
    }
}

data class CepResponse(
    var cep: String,
    var logradouro: String,
    var complemento: String,
    var bairro: String,
    var localidade: String,
    var uf: String,
    var erro: Boolean,
    var ddd: String

)