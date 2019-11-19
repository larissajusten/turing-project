package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VerificarNumeroTotalDeQuestoesMultiplaEscolhaService {

    @Autowired
    private ProvaQuestaoMultiplaEscolhaRepository repository;

    public int verificar(Long idProva) {
       return repository.findAllByProvaIdEquals(idProva).size();
    }
}
