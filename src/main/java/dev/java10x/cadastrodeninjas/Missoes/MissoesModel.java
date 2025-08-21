package dev.java10x.cadastrodeninjas.Missoes;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_missoes")
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;
    private String descricao;

    @OneToMany(mappedBy = "missoes")
    private List<NinjaModel> ninjas; //Aqui sao muitos ninjas

    public String getNome(){
        return nome;
    }

    public String getDificuldade(){
        return dificuldade;
    }

    public String getDescricao(){
        return descricao;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDificuldade(String dificuldade){
        this.dificuldade = dificuldade;
    }

    public void setDescricao(String descricao){
        this.descricao = descricao;
    }



}
