package br.com.aluno.controller;

import br.com.aluno.model.AlunoModel;
import br.com.aluno.service.AlunoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/aluno")
public class AlunoController {

    private final AlunoService service;

    //Buscar Lista de todos os Alunos no Banco.
    @GetMapping
    public List<AlunoModel> Get() {
        return this.service.listarAlunos();
    }

    //Keyworld criada para consultar aluno pelo nome
    @GetMapping("/nome")
    public AlunoModel getByName(@RequestParam("nome") String nome) {
        return this.service.getByName(nome);
    }

    //Keyworls criada para consultar pelo curso
    @GetMapping("/curso")
    public AlunoModel getByCurso(@RequestParam("curso") String curso) {
        return this.service.getByCurso(curso);
    }


    //Salvar Requisição via json no banco
    @PostMapping
    public String Post(@RequestBody AlunoModel aluno) {
        this.service.save(aluno);
        return "Dados Salvo no Banco!";
    }

    //Alterar os dados do aluno
    @PutMapping("/{id}")
    public String editar(@PathVariable("id") Long id, @RequestBody AlunoModel aluno) {
        this.service.save(aluno);
        return "Alterado com Sucesso!";
    }

    //Deletando Id via URL
    @DeleteMapping("/{id}")
    public String Delete(@PathVariable("id") Long id) {
        this.service.remove(id);
        return "Aluno Deletado via URL!";
    }

    //Deletando Id pelos Parametros do Postman
    @DeleteMapping
    public String Delete2(@RequestParam("id") Long id) {
        this.service.remove(id);
        return "Aluno Deletado via Parametros!";
    }
}
