package br.com.aluno.repository;

import br.com.aluno.model.AlunoModel;
import org.springframework.data.jpa.repository.JpaRepository;


@org.springframework.stereotype.Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, Long> {

    AlunoModel findByNome(String nome);

    AlunoModel findByCurso(String cursos);


}
