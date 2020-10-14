package com.brentbusby.statwatch

import com.brentbusby.statwatch.requests.UsernameRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam

@Controller
class HtmlController {
    @GetMapping("/")
    fun statwatch(model: Model): String {
        model["title"] = "Statwatch"
        return "statwatch"
    }

    @GetMapping("/lookup")
    fun lookup(model: Model): String {
        model["title"] = "Stat lookup"
        return "lookup"
    }

    @PostMapping("/lookup")
    fun lookupSubmit(@RequestParam("username") username: String): String {
        var request = UsernameRequest()
        var response = request.call(username)
        return response.toString()
    }
}