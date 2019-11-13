package br.com.cwi.crescer.api.services.QuestaoTecnicaService;

import br.com.cwi.crescer.api.controller.requests.QuestaoTecnicaRequest;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarQuestaoTecnicaService {

    @Autowired
    private QuestaoTecnicaRepository repository;


    public QuestaoTecnicaResponse adicionar(QuestaoTecnicaRequest questaoTecnica){

    }

}
