package com.amonteiro.a03_kmp_mprolead_g1.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.isSuccess
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable //KotlinX impose cette annotation
data class PhotographerDTO(
    var id: Int,
    val stageName: String,
    val photoUrl: String,
    val story: String,
    val portfolio: List<String>,
)

suspend fun main() {

    println(PhotographerAPI.loadPhotographers().joinToString(separator = "\n\n"))


    //Pour que le programme s'arrête, inutile sur Android
    PhotographerAPI.close()
}

object PhotographerAPI {
    private const val API_URL =
        "https://www.amonteiro.fr/api/photographers?apikey=1234"

    //Déclaration du client
    private val client = HttpClient {
        install(ContentNegotiation) {
            json(Json { ignoreUnknownKeys = true }, contentType = ContentType.Any)
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 5000
        }
        //Proxy
        //engine {
        //    proxy = ProxyBuilder.http("monproxy:1234")
        //}
    }

    //GET
    suspend fun loadPhotographers(): List<PhotographerDTO> {
        val response = client.get(API_URL) {
//            headers {
//                append("Authorization", "Bearer YOUR_TOKEN")
//                append("Custom-Header", "CustomValue")
//            }
        }
        if (!response.status.isSuccess()) {
            throw Exception("Erreur API: ${response.status} - ${response.bodyAsText()}")
        }
        return response.body()
    }

    fun close() {
        client.close()
    }
}