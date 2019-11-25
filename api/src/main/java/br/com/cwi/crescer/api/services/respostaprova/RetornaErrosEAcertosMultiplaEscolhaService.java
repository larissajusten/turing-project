package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.enums.NivelDeDificuldade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RetornaErrosEAcertosMultiplaEscolhaService {

    @Autowired
    private RetornaErrosEAcertosPorNivelMultiplaEscolhaService retornaErrosEAcertosPorNivelMultiplaEscolhaService;

    public List<Integer> retornar(Especificidade especificidade) {

        List<Integer> erradasEAcertadasTotal = new ArrayList<>();
        List<Integer> erradasEAcertadasFacil = retornaErrosEAcertosPorNivelMultiplaEscolhaService.retornar(especificidade,
                NivelDeDificuldade.FACIL);
        List<Integer> erradasEAcertadasMedia = retornaErrosEAcertosPorNivelMultiplaEscolhaService.retornar(especificidade,
                NivelDeDificuldade.MEDIO);
        List<Integer> erradasEAcertadasDificil = retornaErrosEAcertosPorNivelMultiplaEscolhaService.retornar(especificidade,
                NivelDeDificuldade.DIFICIL);

        erradasEAcertadasTotal.addAll(erradasEAcertadasFacil);
        erradasEAcertadasTotal.addAll(erradasEAcertadasMedia);
        erradasEAcertadasTotal.addAll(erradasEAcertadasDificil);

        return erradasEAcertadasTotal;
    }

}
