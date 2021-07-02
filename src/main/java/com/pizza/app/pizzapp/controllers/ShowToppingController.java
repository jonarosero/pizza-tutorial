package com.pizza.app.pizzapp.controllers;


import com.pizza.app.pizzapp.services.ShowToppingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/recommendation")
public class ShowToppingController {
    @Autowired
    ShowToppingService showToppingService;
    /**
     * Returns all customer orders. 
     * @return application/json
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRecommendation(){
        String query = "PREFIX rdfs:<http://www.w3.org/2000/01/rdf-schema#>"+
        "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#>"+
        "PREFIX pizza:<http://www.semanticweb.org/jaros/ontologies/2021/5/PizzaTutorial-JonathanRosero#>"+
        "SELECT * WHERE { ?Toppings rdfs:subClassOf pizza:PizzaTopping }";

        return showToppingService.getRecommendation(query);
    }
}
