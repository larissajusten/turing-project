package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.requests.questoes.CorrecaoProvaRequest;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import br.com.cwi.crescer.api.validator.NotaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CorrigirQuestaoTecnicaService {

    @Autowired
    private RespostasTecnicaRepository repository;

    @Autowired
    private BuscarRespostaTecnicaPorIDService buscarRespostaTecnicaPorIDService;

    @Autowired
    private NotaValidator notaValidator;

    public void corrigir(Long idResposta, CorrecaoProvaRequest correcao) {

        notaValidator.validar(correcao.getNota());
        RespostasTecnicaProva resposta = buscarRespostaTecnicaPorIDService.buscar(idResposta);

        resposta.setNota(correcao.getNota());
        resposta.setComentario(correcao.getComentario());

        repository.save(resposta);
    }
}
