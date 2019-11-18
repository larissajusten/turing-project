package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.resposta.RespostasMultiplaEscolhaProva;
import br.com.cwi.crescer.api.exception.resposta.RespostaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.resposta.RespostaMultiplaEscolhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarRespostaMultiplaEscolhaPorIDService {

    @Autowired
    private RespostaMultiplaEscolhaRepository repository;

    public RespostasMultiplaEscolhaProva buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new
                RespostaNaoEncontradaException("Resposta de múltipla escolha não encontrada por esse ID"));
    }
}
