package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaResponse;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class BuscarQuestoesTecnicasDeUmaProvaPorIdService {

    @Autowired
    private ProvaQuestaoTecnicaRepository repository;

    @Autowired
    private ModelMapper mapper;

    public List<QuestaoTecnicaResponse> buscar(Long idProva) {

        List<QuestaoTecnicaResponse> questoes = new ArrayList<>();

        repository
                .findAllByProvaIdEquals(idProva)
                .forEach(item ->
                        questoes.add(mapper.map(item.getQuestao(), QuestaoTecnicaResponse.class))
                );

        return questoes;
    }
}
