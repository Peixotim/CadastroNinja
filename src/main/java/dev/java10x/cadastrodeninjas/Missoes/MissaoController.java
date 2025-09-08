package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaDTO;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    private MissoesService missoesService;

    public MissaoController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @GetMapping("/list/{id}")
    public MissoesDTO listID(@PathVariable Long id){
        return missoesService.listId(id);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(missoesService.listId(id) != null){
            missoesService.delete(id);
            return ResponseEntity.ok().body("Missao deletada com sucesso !");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado !");
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missoes = missoesService.add(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missao criada com sucesso!" + " " + missoes.getNome() + " " + missoes.getId());
    }

    @PutMapping("/alter/{id}")
    public ResponseEntity<?> alter(@PathVariable Long id , @RequestBody MissoesDTO dto) {
        MissoesDTO missao = missoesService.alter(id, dto);
        if (missao != null) {
            return ResponseEntity
                    .ok(missao);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão nao encontrada !");
        }


    @GetMapping("list")
    public ResponseEntity<?> list(){
        if(missoesService.list().isEmpty()) {
            List<MissoesDTO> missoes = missoesService.list();
            return ResponseEntity.ok(missoes);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há missões cadastradas !");
    }
}
