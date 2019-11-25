package br.com.cwi.crescer.api.services.questaomultiplaescolha;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarNumeroDeVezesQuestoesMultiplaPorEspecificidadeService {

    @Autowired
    private QuestaoMultiplaEscolhaRepository repository;


    public int buscar(Especificidade especificidade){
        List<QuestaoMultiplaEscolha> lista = repository.findByEspecificidade(especificidade);

        int vezes = 0;
        for (QuestaoMultiplaEscolha questaoMultiplaEscolha : lista) {
            if(questaoMultiplaEscolha.getVezesUsada() > 0){
                vezes++;
            }
        }

        return vezes;
    }

}
