package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.exception.resposta.RespostaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarRespostaDissertativaPorIDService {

    @Autowired
    private RespostasDissertativaRepository repository;

    public RespostasDissertativaProva buscar(Long id) {

        return repository.findById(id).orElseThrow(() -> new
                RespostaNaoEncontradaException("Resposta dissertativa não encontrada por esse ID"));
    }

}
