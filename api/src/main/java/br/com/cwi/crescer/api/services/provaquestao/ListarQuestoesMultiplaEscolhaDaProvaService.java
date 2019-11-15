package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarQuestoesMultiplaEscolhaDaProvaService {

    @Autowired
    ProvaQuestaoMultiplaEscolhaRepository repository;

    public List<ProvaQuestaoMultiplaEscolha> listar(Long idProva){
        return repository.findAllByProvaIdEquals(idProva);
    }
}
