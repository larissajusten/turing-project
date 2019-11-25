package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.services.provaquestao.CalcularNumeroDeAcertosMultiplaEscolhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetornaErrosEAcertosPorNivelMultiplaEscolhaService {

    @Autowired
    private CalcularNumeroDeAcertosMultiplaEscolhaService calcularNumeroDeAcertosMultiplaEscolhaService;


    @Autowired
    private BuscarListaDeRespostasFiltradaService buscarListaDeRespostasFiltradaService;

    public List<Integer> retornar(Especificidade especificidade, NivelDeDificuldade nivelDeDificuldade) {

        List<Integer> erradasEAcertadas = new ArrayList<>();

        List<RespostasMultiplaEscolhaProva> lista = buscarListaDeRespostasFiltradaService.retornar(especificidade,
                nivelDeDificuldade);


        int corretas = calcularNumeroDeAcertosMultiplaEscolhaService.calcular(lista);
        int erradas = lista.size() - corretas;

        erradasEAcertadas.add(corretas);
        erradasEAcertadas.add(erradas);

        return erradasEAcertadas;
    }

}
