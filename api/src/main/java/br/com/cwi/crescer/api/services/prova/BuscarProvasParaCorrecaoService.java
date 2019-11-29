package br.com.cwi.crescer.api.services.prova;

import br.com.cwi.crescer.api.controller.responses.ProvaParaCorrecaoResponse;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.mapper.ProvaMapper;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscarProvasParaCorrecaoService {

    @Autowired
    private ProvaRepository provaRepository;

    @Autowired
    private ProvaMapper mapper;


    public Page<ProvaParaCorrecaoResponse> buscar(Pageable pageable) {
        return provaRepository.findAllByStatusEquals(pageable, StatusProva.AGUARDANDO_CORRECAO)
                .map(prova -> mapper.paraCorrigir(prova));
    }
}
