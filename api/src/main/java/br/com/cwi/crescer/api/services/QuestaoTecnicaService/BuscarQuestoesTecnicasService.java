package br.com.cwi.crescer.api.services.QuestaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.BuscaQuestoesTecnicasRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarQuestoesTecnicasService {

    @Autowired
    private QuestaoTecnicaRepository repository;

    public List<QuestaoTecnica> buscar(BuscaQuestoesTecnicasRequest buscaQuestoes){

    }
}
