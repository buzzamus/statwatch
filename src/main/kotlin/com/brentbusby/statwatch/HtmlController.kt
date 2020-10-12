package com.brentbusby.statwatch

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

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
}