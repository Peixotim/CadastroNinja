package dev.java10x.cadastrodeninjas.Ninjas;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO dto){
        NinjaModel ninja = new NinjaModel();

        ninja.setId(dto.getId());
        ninja.setAldeia(dto.getAldeia());
        ninja.setNome(dto.getNome());
        ninja.setEmail(dto.getEmail());
        ninja.setIdade(dto.getIdade());
        ninja.setRank(dto.getRank());
        return ninja;
    }

    public NinjaDTO map(NinjaModel model){
        NinjaDTO ninja = new NinjaDTO();

        ninja.setId(model.getId());
        ninja.setIdade(model.getIdade());
        ninja.setNome(model.getNome());
        ninja.setEmail(model.getEmail());
        ninja.setAldeia(model.getAldeia());
        ninja.setMissoes(model.getMissoes());


        return ninja;
    }

}
