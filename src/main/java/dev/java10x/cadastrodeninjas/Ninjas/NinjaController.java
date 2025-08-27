package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("ninja")
public class NinjaController {

    @GetMapping("/boasvindas") //E aqui que passa o valor localhost:8080/boasVindas
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota!";
    }

   //FAZER O CRUD AGORA CREATE READ UPDATE E DELETE

    @PostMapping("/criar")
    public String criarNinja(){
        return "Criando Ninja";
    }


    @GetMapping("/todos")
    public String mostrarTodosOsNinjas(){
        return "Mostrando Ninja";
    }

    @GetMapping("/todosId")
    public String mostrarTodosOsNinjasPorId(){
        return "Mostrando Ninja";
    }

    @PutMapping("/alterar")
    public String alterarNinjaPorId(){
        return "Alterando Ninja";
    }

    @DeleteMapping("/deletar")
    public String deletarNinjaPorId(){
        return  "Deletando Ninja";
    }

}
