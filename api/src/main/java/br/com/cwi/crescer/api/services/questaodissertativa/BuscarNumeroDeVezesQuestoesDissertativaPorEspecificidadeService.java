package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.domain.enums.Especificidade;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.questao.QuestaoMultiplaEscolha;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import br.com.cwi.crescer.api.repository.questao.QuestaoMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarNumeroDeVezesQuestoesDissertativaPorEspecificidadeService {

    @Autowired
    private QuestaoDissertativaRepository repository;


    public int buscar(Especificidade especificidade){
        List<QuestaoDissertativa> lista =  repository.findByEspecificidade(especificidade);

        int vezes = 0;
        for (QuestaoDissertativa questaoDissertativa : lista) {
            if(questaoDissertativa.getVezesUsada() > 0){
                vezes++;
            }
        }

        return vezes;
    }

}
