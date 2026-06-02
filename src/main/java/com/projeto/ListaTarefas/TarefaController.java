package com.projeto.ListaTarefas;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private TarefaRepository tarefaRepository;

    public TarefaController(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @GetMapping
    public List<Tarefa> buscarTodas() {
        return tarefaRepository.findAll();
    }

    @PostMapping
    public void criar(@RequestBody Tarefa tarefa) {
        tarefaRepository.save(tarefa);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable("id") int id) {
        tarefaRepository.deleteById(id);
    }
}

