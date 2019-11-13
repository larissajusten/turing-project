package br.com.cwi.crescer.api.services.QuestaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.BuscaQuestoesTecnicasRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestoesTecnicasService {

    @Autowired
    private QuestaoTecnicaRepository repository;

    public List<QuestaoTecnica> buscar(BuscaQuestoesTecnicasRequest buscaQuestoes){

    }
}
