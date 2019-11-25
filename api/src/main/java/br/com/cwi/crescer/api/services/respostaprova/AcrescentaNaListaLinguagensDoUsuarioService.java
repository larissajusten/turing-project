package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.LinguagensResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcrescentaNaListaLinguagensDoUsuarioService {

    @Autowired
    private RetornaTotalPorLinguagemService retornaTotalPorLinguagemService;

    public void retornar( List<LinguagensResponse> lista, Especificidade especificidade) {

        LinguagensResponse linguagensResponse = new LinguagensResponse();
        linguagensResponse.setEspecificidade(especificidade);
        linguagensResponse.setQuantosUsuarios(retornaTotalPorLinguagemService.retornar(especificidade));
        lista.add(linguagensResponse);

    }

}
