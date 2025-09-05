package dev.java10x.cadastrodeninjas.Ninjas;


import dev.java10x.cadastrodeninjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {
    private Long Id ;
    private String nome;
    private String email;
    private String aldeia;
    private int idade;
    private String rank;
    private MissoesModel missoes;
}
