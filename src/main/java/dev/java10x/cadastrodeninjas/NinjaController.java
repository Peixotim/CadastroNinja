package dev.java10x.cadastrodeninjas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas") //E aqui que passa o valor localhost:8080/boasVindas
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota!";
    }
}
