package dev.java10x.cadastrodeninjas.Ninjas;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping ("ninja")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @PostMapping("/add")
    @Operation(summary = "Adiciona Ninjas", description = "Essa rota adicona os ninjas com os parametros passado")
    public ResponseEntity<String> add(@RequestBody NinjaDTO ninja){
        ninjaService.create(ninja);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso !"
                + " nome : " + ninja.getNome() +
                " id : " + ninja.getId());
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta Ninjas",  description = "Essa rota faz a delecao de ninjas com base no id passado!")
    public ResponseEntity<String> delete(@PathVariable Long id){
         ninjaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ninja Deletado com sucesso");
    }


    @GetMapping("/list/{id}")
    @Operation(summary = "Lista por id" , description = "Essa rota lista o ninja de acordo com seu id")
    public NinjaDTO listId(@PathVariable Long id){
        return ninjaService.listId(id);
    }

    @GetMapping("list")
    @Operation(summary = "Lista Ninjas", description = "Lista todo os ninjas do banco de dados")
    public List<NinjaDTO> list(){
        return ninjaService.list();
    }

    @PutMapping("/alter/{id}")
    @Operation(summary = "Altera dados" , description = "Altera os dados do ninja passado pelo id")
    public ResponseEntity<String> alter(@PathVariable Long id , @RequestBody NinjaDTO dto){
        NinjaDTO ninja =  ninjaService.alter(id,dto);
        return  ResponseEntity.status(HttpStatus.OK).body("Ninja Alterado com sucesso!");
    }
}
