package br.com.cwi.crescer.api.services.questaoTecnicaService;

import br.com.cwi.crescer.api.domain.questao.QuestaoTecnica;
import br.com.cwi.crescer.api.exception.ValidacaoDeAplicacaoException;
import br.com.cwi.crescer.api.repository.questao.QuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestaoTecnicaPorIdService {

    @Autowired
    QuestaoTecnicaRepository repository;

    public QuestaoTecnica buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new ValidacaoDeAplicacaoException("Questão técnica não foi encontrada por esse id"));
    }
}
