package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoMultiplaEscolhaComRespostaResponse;
import br.com.cwi.crescer.api.controller.responses.QuestaoTecnicaComRespostaResponse;
import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.services.alternativamultiplaescolha.BuscarAlternativaQuestaoMultiplaEscolhaService;
import br.com.cwi.crescer.api.services.questaomultiplaescolha.RetornarNotaDaQuestaoMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QuestaoComRespostaMapper {

    @Autowired
    private RetornarNotaDaQuestaoMultiplaEscolhaService retornarNotaDaQuestaoMultiplaEscolhaService;

    @Autowired
    private BuscarAlternativaQuestaoMultiplaEscolhaService buscarAlternativaQuestaoMultiplaEscolhaService;

    public QuestaoDissertativaComRespostaResponse questaoDissertativa(RespostasDissertativaProva questao) {

        QuestaoDissertativaComRespostaResponse questaoDissertativaComRespostaResponse =
                new QuestaoDissertativaComRespostaResponse();

        questaoDissertativaComRespostaResponse.setIdQuestao(questao.getQuestaoDissertativa().getId());
        questaoDissertativaComRespostaResponse.setNota(questao.getNota());
        questaoDissertativaComRespostaResponse.setComentario(questao.getComentario());
        questaoDissertativaComRespostaResponse.setQuestao(questao.getQuestaoDissertativa().getQuestao());
        questaoDissertativaComRespostaResponse.setResposta(questao.getResposta());
        questaoDissertativaComRespostaResponse.setEspecificidade(questao.getQuestaoDissertativa().getEspecificidade());

        return questaoDissertativaComRespostaResponse;
    }

    public QuestaoMultiplaEscolhaComRespostaResponse questaoMultiplaEscolha(RespostasMultiplaEscolhaProva questao) {

        QuestaoMultiplaEscolhaComRespostaResponse questaoMultiplaEscolhaComRespostaResponse =
                new QuestaoMultiplaEscolhaComRespostaResponse();

        questaoMultiplaEscolhaComRespostaResponse.setNota(retornarNotaDaQuestaoMultiplaEscolhaService
                .notaQuestaoMultiplaEscolha(questao.getQuestaoMultiplaEscolha().getNivelDeDificuldade()));
        questaoMultiplaEscolhaComRespostaResponse.setIdQuestao(questao.getQuestaoMultiplaEscolha().getId());
        questaoMultiplaEscolhaComRespostaResponse.setQuestao(questao.getQuestaoMultiplaEscolha().getQuestao());
        questaoMultiplaEscolhaComRespostaResponse.setResposta(questao.getAlternativaMultiplaEscolha());
        questaoMultiplaEscolhaComRespostaResponse.setEspecificidade(questao.getQuestaoMultiplaEscolha().getEspecificidade());
        questaoMultiplaEscolhaComRespostaResponse.setAlternativasMultiplaEscolhas(buscarAlternativaQuestaoMultiplaEscolhaService
                .buscar(questao.getQuestaoMultiplaEscolha().getId()));

        return questaoMultiplaEscolhaComRespostaResponse;

    }

    public QuestaoTecnicaComRespostaResponse questaoTecnica(RespostasTecnicaProva questao) {

        QuestaoTecnicaComRespostaResponse questaoTecnicaComRespostaResponse =
                new QuestaoTecnicaComRespostaResponse();

        questaoTecnicaComRespostaResponse.setIdQuestao(questao.getQuestaoTecnica().getId());
        questaoTecnicaComRespostaResponse.setNota(questao.getNota());
        questaoTecnicaComRespostaResponse.setComentario(questao.getComentario());
        questaoTecnicaComRespostaResponse.setQuestao(questao.getQuestaoTecnica().getQuestao());
        questaoTecnicaComRespostaResponse.setResposta(questao.getResposta());
        questaoTecnicaComRespostaResponse.setEspecificidade(questao.getQuestaoTecnica().getEspecificidade());

        return questaoTecnicaComRespostaResponse;
    }
}
