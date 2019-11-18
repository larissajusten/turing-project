package br.com.cwi.crescer.api.services.respostaprova;

import br.com.cwi.crescer.api.domain.resposta.RespostasDissertativaProva;
import br.com.cwi.crescer.api.domain.resposta.RespostasTecnicaProva;
import br.com.cwi.crescer.api.exception.resposta.RespostaNaoEncontradaException;
import br.com.cwi.crescer.api.repository.resposta.RespostasDissertativaRepository;
import br.com.cwi.crescer.api.repository.resposta.RespostasTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscarRespostaTecnicaPorIDService {

    @Autowired
    private RespostasTecnicaRepository repository;

    public RespostasTecnicaProva buscar(Long id){
        return repository.findById(id).orElseThrow(() -> new
                RespostaNaoEncontradaException("Resposta técnica não encontrada por esse ID"));
    }
}
