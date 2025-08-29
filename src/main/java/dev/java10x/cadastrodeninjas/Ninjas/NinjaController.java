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

   //FAZER O CRUD AGORA CREATE READ UPDATE E DELETE

    @PostMapping("/adicionar")
    public NinjaModel adicionar(@RequestBody NinjaModel ninjaModel){
        return ninjaService.adicionarNinja(ninjaModel);
    }

    @GetMapping("/listar")
    public List<NinjaModel> mostrarTodosOsNinjas(){
        return ninjaService.listaNinjas();
    }

    @GetMapping("/listar/{id}")
    public NinjaModel mostrarPorId(@PathVariable Long id){
        return ninjaService.listarNinjaId(id);
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
