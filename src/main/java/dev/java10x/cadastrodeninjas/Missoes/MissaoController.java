package dev.java10x.cadastrodeninjas.Missoes;

import dev.java10x.cadastrodeninjas.Ninjas.NinjaDTO;
import org.springframework.web.bind.annotation.*;

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
    public void delete(@PathVariable Long id){
        missoesService.delete(id);
    }

    @PostMapping("/add")
    public MissoesDTO add(@RequestBody MissoesDTO missoesDTO){
        return missoesService.add(missoesDTO);
    }

    @PutMapping("/alter/{id}")
    public MissoesDTO alter(@PathVariable Long id , MissoesDTO dto){
        return missoesService.alter(id,dto);
    }
}
