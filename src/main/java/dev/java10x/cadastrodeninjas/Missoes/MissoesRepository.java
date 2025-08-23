package dev.java10x.cadastrodeninjas.Missoes;

import org.springframework.data.jpa.repository.JpaRepository;
//Aqui a gente passa onde está o model da instancia e o tipo do meu ID , no caso dessa aplicacao long
public interface MissoesRepository extends JpaRepository<MissoesModel, Long>{
}
