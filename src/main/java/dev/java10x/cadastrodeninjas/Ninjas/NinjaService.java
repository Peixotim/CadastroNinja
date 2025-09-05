package dev.java10x.cadastrodeninjas.Ninjas;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Service;

@Service
public class NinjaService {

    private NinjaRepository ninjaRepository;
    private NinjaMapper ninjaMapper;


    public NinjaService(NinjaRepository ninjaRepository , NinjaMapper ninjaMapper){
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }


    //CRUD

    //listAll
    public List<NinjaDTO> list(){
        List<NinjaModel> model = ninjaRepository.findAll();
        return model.stream()
                .map(ninjaMapper::map)
                .collect(Collectors.toList());
    }


    //listById
    public NinjaDTO listId(Long id){
        Optional<NinjaModel> ninja = ninjaRepository.findById(id);

        return ninja.map(ninjaMapper::map).orElseThrow(RuntimeException::new);
    }


    //Adding
    public NinjaDTO create(NinjaDTO dto){
        NinjaModel ninjas = ninjaMapper.map(dto);
        ninjas = ninjaRepository.save(ninjas);
        return ninjaMapper.map(ninjas);
    }

    //Delete
    public void delete(Long id){
        if(ninjaRepository.existsById(id)){
            ninjaRepository.deleteById(id);
        }else{
            throw new RuntimeException("Check the id, as it does not exist !");
        }

    }

    //Alter
    public NinjaDTO alter(Long id, NinjaDTO ninja){
        Optional<NinjaModel> ninjaExistente = ninjaRepository.findById(id);
        if(ninjaExistente.isPresent()){
            NinjaModel model = ninjaMapper.map(ninja);
            model.setId(id);
            NinjaModel ninjaAtualizado = ninjaRepository.save(model);
            return ninjaMapper.map(ninjaAtualizado);
        }

        return null ;
    }
}
