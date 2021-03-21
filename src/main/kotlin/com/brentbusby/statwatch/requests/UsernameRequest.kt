package com.brentbusby.statwatch.requests

import com.brentbusby.statwatch.config.HaloApiConfiguration
import io.github.rybalkinsd.kohttp.dsl.httpGet
import io.github.rybalkinsd.kohttp.ext.asString
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service

@Service
class UsernameRequest @Autowired constructor(
    private val haloApiConfiguration: HaloApiConfiguration
) {
    fun call(username: String): String? {
        val response: Response = httpGet {
            host = "fortnite-api.com"
            path = "/v1/stats/br/v2"
            param {
                "name" to username
            }
        }

        return response.asString()
    }

    fun haloCall(username: String): String? {
        val client = OkHttpClient()
        val urlBuilder = HttpUrl.parse("https://www.haloapi.com/stats/h5/servicerecords/arena")?.newBuilder()
        urlBuilder?.addQueryParameter("players", username)
        val url = urlBuilder?.build().toString()

        val request = Request.Builder()
            .url(url)
            .header("Ocp-Apim-Subscription-Key", haloApiConfiguration.subscriptionKey)
            .build()
        
        val response = client.newCall(request).execute()

        return response.body()?.string()
    }
}