package dev.java10x.cadastrodeninjas.Missoes;
import dev.java10x.cadastrodeninjas.Ninjas.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;


@Entity
@Table(name = "tb_missoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String dificuldade;
    private String descricao;

    @OneToMany(mappedBy = "missoes") //Um para muitos (Uma missao sera para varios ninjas)
    private List<NinjaModel> ninjas; //Aqui sao muitos ninjas

}
