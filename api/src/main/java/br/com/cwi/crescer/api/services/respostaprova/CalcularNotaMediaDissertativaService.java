package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.questao.AlternativaMultiplaEscolha;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import br.com.cwi.crescer.api.repository.questao.AlternativaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.RetornarAlternativaCertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalcularNotaMediaDissertativaService {

    @Autowired
    private RespostasDissertativaRepository repository;

    public double calcular(Long idProva) {
        double media = 0;

        List<RespostasDissertativaProva> listaRespostas = repository.findAllByProvaIdEquals(idProva);

        for (RespostasDissertativaProva respostasDissertativaProva : listaRespostas) {
            media += respostasDissertativaProva.getNota();
        }

        return media/listaRespostas.size();
    }
}
