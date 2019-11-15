package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoTecnica;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarQuestoesTecnicasDaProvaService {

    @Autowired
    ProvaQuestaoTecnicaRepository repository;

    public List<ProvaQuestaoTecnica> listar(Long idProva){
        return repository.findAllByProvaIdEquals(idProva);
    }
}
