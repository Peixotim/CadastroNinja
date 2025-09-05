package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.stereotype.Component;

@Component
public class MissoesMapper {

    public MissoesModel map(MissoesDTO dto){
        MissoesModel model = new MissoesModel();

        model.setId(dto.getId());
        model.setNome(dto.getNome());
        model.setDescricao(dto.getDescricao());
        model.setNinjas(dto.getNinjas());
        model.setDificuldade(dto.getDificuldade());

        return model;
    }

    public MissoesDTO map(MissoesModel model){
        MissoesDTO dto = new MissoesDTO();

        dto.setDescricao(model.getDescricao());
        dto.setDificuldade(model.getDificuldade());
        dto.setNinjas(model.getNinjas());
        dto.setId(model.getId());
        dto.setNome(model.getNome());

        return dto;
    }
}
