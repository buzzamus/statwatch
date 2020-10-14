package com.brentbusby.statwatch

import com.brentbusby.statwatch.requests.UsernameRequest
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes
import org.springframework.web.servlet.view.RedirectView

@Controller
class HtmlController {
    @GetMapping("/")
    fun statwatch(model: Model): String {
        model["title"] = "Statwatch"
        return "statwatch"
    }

    @GetMapping("/results")
    fun results(): String {
        return "results"
    }

    @GetMapping("/lookup")
    fun lookup(model: Model): String {
        model["title"] = "Stat lookup"
        return "lookup"
    }

    @PostMapping("/lookup")
    fun lookupSubmit(@RequestParam("username") username: String, redirect: RedirectAttributes): String {
        var request = UsernameRequest()
        var response = request.call(username)

        redirect.addFlashAttribute("response", response)

        return "redirect:results"
    }
}