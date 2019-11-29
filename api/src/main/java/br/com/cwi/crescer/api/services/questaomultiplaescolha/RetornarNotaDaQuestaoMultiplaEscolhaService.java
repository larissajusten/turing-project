package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import org.springframework.stereotype.Service;

@Service
public class RetornarNotaDaQuestaoMultiplaEscolhaService {

    public int notaQuestaoMultiplaEscolha(NivelDeDificuldade nivelDeDificuldade) {

        if (nivelDeDificuldade.equals(NivelDeDificuldade.FACIL)) {
            return 10;
        } else if (nivelDeDificuldade.equals(NivelDeDificuldade.MEDIO)) {
            return 20;
        } else {
            return 30;
        }
    }
}
