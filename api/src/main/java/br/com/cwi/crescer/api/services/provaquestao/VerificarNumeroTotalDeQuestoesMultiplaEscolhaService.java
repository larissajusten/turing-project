package br.com.cwi.crescer.api.services.provaquestao;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.questaoprova.ProvaQuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
public class VerificarNumeroTotalDeQuestoesMultiplaEscolhaService {

    @Autowired
    private ProvaQuestaoMultiplaEscolhaRepository repository;

    public int verificar(Long idProva) {
       return repository.findAllByProvaIdEquals(idProva).size();
    }
}
