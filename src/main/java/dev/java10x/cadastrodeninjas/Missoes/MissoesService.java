package dev.java10x.cadastrodeninjas.Missoes;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaDTO;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissoesService {


    private MissoesRepository missoesRepository;
    private MissoesMapper missoesMapper;


    public MissoesService(MissoesRepository missoesRepository , MissoesMapper missoesMapper){
        this.missoesMapper = missoesMapper;
        this.missoesRepository = missoesRepository;
    }



        public void delete(Long id){
            missoesRepository.deleteById(id);
        }

        public MissoesDTO listId(Long id){
            MissoesModel model = missoesRepository.findById(id).orElseThrow(RuntimeException::new);
            return missoesMapper.map(model);
        }



        public MissoesDTO add(MissoesDTO missoesDTO){
            MissoesModel missoesAdd = missoesMapper.map(missoesDTO);
            missoesAdd = missoesRepository.save(missoesAdd);

            return missoesMapper.map(missoesAdd);
        }


        public List<MissoesDTO> list(){
            List<MissoesModel> model = missoesRepository.findAll();
            return model.stream()
                    .map(missoesMapper::map)
                    .collect(Collectors.toList());
        }

        public MissoesDTO alter(Long id , MissoesDTO dto){
            Optional<MissoesModel> model = missoesRepository.findById(id);
            
            if(model.isPresent()){
                MissoesModel missoes = missoesMapper.map(dto);
                missoes = missoesRepository.save(missoes);
                return missoesMapper.map(missoes);
            }

            return null;
        }
    }
