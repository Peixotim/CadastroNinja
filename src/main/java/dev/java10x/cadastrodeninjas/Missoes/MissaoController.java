package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("missoes")
public class MissaoController {

    private final MissoesService missoesService;

    public MissaoController(MissoesService missoesService){
        this.missoesService = missoesService;
    }

    @GetMapping("/list/{id}")
    @Operation(summary = "Lista por id" , description = "Essa rota lista as missoes de acordo com seu id")
    public MissoesDTO listID(@PathVariable Long id){
        return missoesService.listId(id);
    }

    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Deleta Missoes",  description = "Essa rota faz a delecao de missoes com base no id passado!")
    public ResponseEntity<String> delete(@PathVariable Long id){
        if(missoesService.listId(id) != null){
            missoesService.delete(id);
            return ResponseEntity.ok().body("Missao deletada com sucesso !");
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Id não encontrado !");
        }
    }

    @PostMapping("/add")
    @Operation(summary = "Adiciona Ninjas", description = "Essa rota adicona os ninjas com os parametros passado")
    public ResponseEntity<String> add(@RequestBody MissoesDTO missoesDTO){
        MissoesDTO missoes = missoesService.add(missoesDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Missao criada com sucesso!" + " " + missoes.getNome() + " " + missoes.getId());
    }

    @PutMapping("/alter/{id}")
    @Operation(summary = "Altera dados" , description = "Altera os dados da missao passado pelo id")
    public ResponseEntity<?> alter(@PathVariable Long id , @RequestBody MissoesDTO dto) {
        MissoesDTO missao = missoesService.alter(id, dto);
        if (missao != null) {
            return ResponseEntity
                    .ok(missao);
        }
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Missão nao encontrada !");
        }


    @GetMapping("list")
    @Operation(summary = "Lista Missoes", description = "Lista todo as missoes do banco de dados")
    public ResponseEntity<?> list(){
        if(missoesService.list().isEmpty()) {
            List<MissoesDTO> missoes = missoesService.list();
            return ResponseEntity.ok(missoes);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não há missões cadastradas !");
    }
}
