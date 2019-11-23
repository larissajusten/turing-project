package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.exception.prova.ProvaNaoEncontradaException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProvasVaziaValidador {

    public void validar(List<Prova> provas) {

        if (provas.isEmpty()) {
            throw new ProvaNaoEncontradaException("Nenhuma prova corrigida foi encontrada");
        }
    }

}
