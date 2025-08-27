package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissaoController {


    @PostMapping("/criar")
    public String criarNinja(){
        return "Criando Missoes";
    }


    @GetMapping("/todos")
    public String mostrarTodosAsMissoes(){
        return "Mostrando todos as Missoes";
    }

    @GetMapping("/todosId")
    public String mostrarTodasAsMissoesPorId(){
        return "Mostrando todas as Missoes por ID";
    }

    @PutMapping("/alterar")
    public String alterarMissoesPorId(){
        return "Alterando Missoes por ID";
    }

    @DeleteMapping("/deletar")
    public String deletarMissoes(){
        return  "Deletando Ninja";
    }
}
