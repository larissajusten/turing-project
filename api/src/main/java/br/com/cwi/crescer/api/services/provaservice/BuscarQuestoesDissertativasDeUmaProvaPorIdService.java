package br.com.cwi.crescer.api.services.provaservice;

import br.com.cwi.crescer.api.controller.responses.QuestaoDissertativaResponse;
import br.com.cwi.crescer.api.repository.prova.ProvaQuestaoDissertativaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BuscarQuestoesDissertativasDeUmaProvaPorIdService {

    @Autowired
    private ProvaQuestaoDissertativaRepository repository;

    @Autowired
    private ModelMapper mapper;

    public List<QuestaoDissertativaResponse> buscar(Long idProva) {

        List<QuestaoDissertativaResponse> questoesDissertativasDaProva = new ArrayList<>();

        repository.findAllByProvaIdEquals(idProva)
                .forEach(item -> {
                    questoesDissertativasDaProva.add(mapper.map(item.getQuestao(), QuestaoDissertativaResponse.class));
                });

        return questoesDissertativasDaProva;
    }
}
