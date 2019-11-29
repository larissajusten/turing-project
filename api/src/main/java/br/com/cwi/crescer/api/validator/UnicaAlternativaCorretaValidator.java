package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoMultiplaEscolhaRequest;
import br.com.cwi.crescer.api.exception.questoes.MultiplaEscolhaException;
import org.springframework.stereotype.Component;

@Component
public class UnicaAlternativaCorretaValidator {

    public void validar(QuestaoMultiplaEscolhaRequest request) {
        int quantidadeDeCorretas = 0;
        boolean temCorreta = false;

        if (request.getAlternativaA().isRespostaCorreta()) {
            temCorreta = true;
            quantidadeDeCorretas++;
        }

        if (request.getAlternativaB().isRespostaCorreta()) {
            temCorreta = true;
            quantidadeDeCorretas++;
        }

        if (request.getAlternativaC().isRespostaCorreta()) {
            temCorreta = true;
            quantidadeDeCorretas++;
        }

        if (request.getAlternativaD().isRespostaCorreta()) {
            temCorreta = true;
            quantidadeDeCorretas++;
        }
        if (request.getAlternativaE().isRespostaCorreta()) {
            temCorreta = true;
            quantidadeDeCorretas++;
        }

        if (!temCorreta || quantidadeDeCorretas > 1) {
            throw new MultiplaEscolhaException("Deve ter UMA alternativa correta");
        }
    }

}
