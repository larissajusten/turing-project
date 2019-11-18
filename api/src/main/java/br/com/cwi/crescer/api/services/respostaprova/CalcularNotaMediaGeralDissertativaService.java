package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularNotaMediaGeralDissertativaService {

    @Autowired
    private RespostasDissertativaRepository repository;

    public double calcular(Long idQuestao){
        double media = 0;
        List<RespostasDissertativaProva> listaRespostas = repository.findAllByQuestaoDissertativaIdEquals(idQuestao);

        for (RespostasDissertativaProva respostasDissertativaProva : listaRespostas) {
            media += respostasDissertativaProva.getNota();
        }

        return media/listaRespostas.size();
    }
}
