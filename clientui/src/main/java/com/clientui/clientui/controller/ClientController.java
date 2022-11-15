package com.clientui.clientui.controller;

import com.clientui.clientui.beans.ProductBean;
import com.clientui.clientui.proxy.MicroserviceProduitsProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author Mohamed ouokki on 11/14/22
 * @project microservice-commandes
 */
@Controller
public class ClientController {

    private final MicroserviceProduitsProxy produitsProxy;

    public ClientController(MicroserviceProduitsProxy produitsProxy){
        this.produitsProxy = produitsProxy;
    }

    @RequestMapping("/")
    public String accueil(Model model){
        List<ProductBean> produits =  produitsProxy.listeDesProduits();
        model.addAttribute("produits", produits);
        return "Accueil";
    }

    @RequestMapping("/details-produit/{id}")
    public String ficheProduit(@PathVariable int id, Model model){
        ProductBean produit = produitsProxy.recupererUnProduit(id);
        model.addAttribute("produit", produit);
        return "FicheProduit";
    }
}
