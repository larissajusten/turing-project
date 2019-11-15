package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoDissertativa;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListarQuestoesDissertativasDaProvaService {

    @Autowired
    ProvaQuestaoDissertativaRepository repository;

    public List<ProvaQuestaoDissertativa> listar(Long idProva){
        return repository.findAllByProvaIdEquals(idProva);
    }
}
