package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.controller.responses.LinguagensResponse;
import br.com.cwi.crescer.api.domain.enums.Especificidade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetornaLinguagensDoUsuarioService {

    @Autowired
    private AcrescentaNaListaLinguagensDoUsuarioService acrescentaNaListaLinguagensDoUsuarioService;

    public List<LinguagensResponse> retornar() {

        List<LinguagensResponse> lista = new ArrayList<>();

        acrescentaNaListaLinguagensDoUsuarioService.retornar(lista, Especificidade.JAVASCRIPT);
        acrescentaNaListaLinguagensDoUsuarioService.retornar(lista, Especificidade.JAVA);
        acrescentaNaListaLinguagensDoUsuarioService.retornar(lista, Especificidade.C);
        acrescentaNaListaLinguagensDoUsuarioService.retornar(lista, Especificidade.PHP);
        acrescentaNaListaLinguagensDoUsuarioService.retornar(lista, Especificidade.PYTHON);
        acrescentaNaListaLinguagensDoUsuarioService.retornar(lista, Especificidade.RUBY);
        acrescentaNaListaLinguagensDoUsuarioService.retornar(lista, Especificidade.TYPESCRIPT);
        acrescentaNaListaLinguagensDoUsuarioService.retornar(lista, Especificidade.SWIFT);

        return lista;
    }
}
