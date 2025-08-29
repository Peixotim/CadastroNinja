package dev.java10x.cadastrodeninjas.Ninjas;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository){
        this.ninjaRepository = ninjaRepository;
    } //Construtor da class NinjaService que passa os dados contidos nela


    //Criar todos os nossos metodos

    public List<NinjaModel> listaNinjas(){
        return ninjaRepository.findAll();
    }

       public NinjaModel listarNinjaId(Long id){
           Optional<NinjaModel> ninjaId = ninjaRepository.findById(id);
           return ninjaId.orElseThrow(RuntimeException::new);
       }
}
