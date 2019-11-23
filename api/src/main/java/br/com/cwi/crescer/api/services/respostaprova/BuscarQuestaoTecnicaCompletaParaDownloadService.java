package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaCompletaResponse;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarQuestaoTecnicaCompletaParaDownloadService {

    @Autowired
    private BuscarRespostaTecnicaPorIDService buscarRespostaTecnicaPorIDService;

    public QuestaoTecnicaCompletaResponse buscar(Long idResposta) {

        QuestaoTecnicaCompletaResponse response = new QuestaoTecnicaCompletaResponse();

        RespostasTecnicaProva respostaTecnica = buscarRespostaTecnicaPorIDService.buscar(idResposta);

        response.setRespostaUsuario(respostaTecnica.getResposta());
        response.setRespostaBase(respostaTecnica.getQuestaoTecnica().getRespostaBase());
        response.setTesteBase(respostaTecnica.getQuestaoTecnica().getTesteBase());
        response.setQuestao(respostaTecnica.getQuestaoTecnica().getQuestao());

        return response;
    }

}
