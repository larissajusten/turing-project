package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularNotaMediaDissertativaService {

    @Autowired
    private RespostasDissertativaRepository repository;

    public double calcular(Long idProva) {

        List<RespostasDissertativaProva> listaRespostas = repository.findAllByProvaIdEquals(idProva);
        double media = 0;

        for (RespostasDissertativaProva respostasDissertativaProva : listaRespostas) {
            media += respostasDissertativaProva.getNota();
        }

        return media/listaRespostas.size();
    }

}
