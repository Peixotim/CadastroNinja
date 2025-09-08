package dev.java10x.cadastrodeninjas.Ninjas;

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
    public ResponseEntity<String> add(@RequestBody NinjaDTO ninja){
        ninjaService.create(ninja);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Ninja criado com sucesso !"
                + " nome : " + ninja.getNome() +
                " id : " + ninja.getId());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
         ninjaService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Ninja Deletado com sucesso");
    }

    @GetMapping("/list/{id}")
    public NinjaDTO listId(@PathVariable Long id){
        return ninjaService.listId(id);
    }

    @GetMapping("list")
    public List<NinjaDTO> list(){
        return ninjaService.list();
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<String> alter(@PathVariable Long id , @RequestBody NinjaDTO dto){
        NinjaDTO ninja =  ninjaService.alter(id,dto);
        return  ResponseEntity.status(HttpStatus.OK).body("Ninja Alterado com sucesso!");
    }
}
