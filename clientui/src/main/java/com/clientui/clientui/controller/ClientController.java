package com.clientui.clientui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Mohamed ouokki on 11/14/22
 * @project microservice-commandes
 */
@Controller
public class ClientController {

    @RequestMapping("/")
    public String accueil(Model model)
    {
        return "Accueil";
    }
}
