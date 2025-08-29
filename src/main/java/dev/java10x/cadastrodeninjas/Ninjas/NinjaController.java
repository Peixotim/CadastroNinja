package dev.java10x.cadastrodeninjas.Ninjas;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @GetMapping("/boasvindas") //E aqui que passa o valor localhost:8080/boasVindas
    public String boasVindas(){
        return "Essa é minha primeira mensagem nessa rota!";
    }

   //FAZER O CRUD AGORA CREATE READ UPDATE E DELETE

    @PostMapping("/criar")
    public String criarNinja(){
        return "Criando Ninja";
    }

    @JsonIgnore
    @GetMapping("/todos")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.listaNinjas();
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
