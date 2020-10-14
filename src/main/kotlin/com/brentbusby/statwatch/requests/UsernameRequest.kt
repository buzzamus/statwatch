package com.brentbusby.statwatch.requests

import io.github.rybalkinsd.kohttp.dsl.httpGet
import io.github.rybalkinsd.kohttp.ext.asString
import okhttp3.Response

class UsernameRequest() {

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
}