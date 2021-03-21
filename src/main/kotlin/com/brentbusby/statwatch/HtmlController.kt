package com.brentbusby.statwatch

import com.brentbusby.statwatch.config.HaloApiConfiguration
import com.brentbusby.statwatch.requests.UsernameRequest
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
class HtmlController @Autowired constructor(
    private val haloApiConfiguration: HaloApiConfiguration
) {
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
        var request = UsernameRequest(haloApiConfiguration)
        var response = request.call(username)

        redirect.addFlashAttribute("response", response)

        return "redirect:results"
    }

    @GetMapping("/haloLookup")
    fun haloLookup(model: Model): String {
        model["title"] = "Halo stat lookup"
        return "haloLookup"
    }

    @GetMapping("/haloResults")
    fun haloResults(): String {
        return "haloResults"
    }

    @PostMapping("/haloLookup")
    fun haloLookupSubmit(@RequestParam("username") username: String, redirect: RedirectAttributes): String {
        var request = UsernameRequest(haloApiConfiguration)
        var response = request.haloCall(username)
        redirect.addFlashAttribute("response", response)
        return "redirect:haloResults"
    }
}