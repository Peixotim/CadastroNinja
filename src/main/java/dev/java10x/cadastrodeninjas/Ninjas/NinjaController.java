package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping ("ninja")
public class NinjaController {

    private NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }

    @PostMapping("/add")
    public NinjaDTO add(@RequestBody NinjaDTO ninja){
        return ninjaService.create(ninja);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        ninjaService.delete(id);
    }

    @GetMapping("/list/{id}")
    public NinjaDTO listId(@PathVariable Long id){
        return ninjaService.listId(id);
    }

    @PutMapping("/alter/{id}")
    public NinjaDTO alter(@PathVariable Long id , @RequestBody NinjaDTO dto){
        return ninjaService.alter(id,dto);
    }
}
