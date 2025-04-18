package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularNotaMediaGeralTecnicaService {

    @Autowired
    private RespostasTecnicaRepository repository;

    public double calcular(Long idQuestao) {

        List<RespostasTecnicaProva> listaRespostas = repository.findAllByQuestaoTecnicaIdEquals(idQuestao);
        double media = 0;

        for (RespostasTecnicaProva respostasTecnicaProva : listaRespostas) {
            media += respostasTecnicaProva.getNota();
        }

        return media / listaRespostas.size();
    }
}
