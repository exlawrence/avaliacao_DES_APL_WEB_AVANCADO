package br.com.aluno.service;


import br.com.aluno.model.AlunoModel;
import br.com.aluno.repository.AlunoRepository;
import lombok.AllArgsConstructor;

import java.util.List;

@org.springframework.stereotype.Service
@AllArgsConstructor

public class AlunoService {

    private final AlunoRepository repository;

    public AlunoModel getByName(String nome) {
        return this.repository.findByNome(nome);
    }

    public AlunoModel getByCurso(String cursos) {
        return this.repository.findByCurso(cursos);
    }

    public void save(AlunoModel aluno) {
        this.repository.save(aluno);
    }

    public List<AlunoModel> listarAlunos() {
        return this.repository.findAll();
    }

    public void remove(Long id) {
        this.repository.deleteById(id);
    }


}
