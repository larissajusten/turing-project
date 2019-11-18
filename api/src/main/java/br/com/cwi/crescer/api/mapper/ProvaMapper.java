package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProvaMapper {

    @Autowired
    private ModelMapper mapper;

    public Prova transformar(ProvaRequest request) {
        Prova prova = mapper.map(request, Prova.class);

        prova.setDataCriacao(LocalDateTime.now());
        prova.setEmail(request.getEmail());
        prova.setCriador(new Usuario(1L, "a"));
        prova.setStatus(StatusProva.ATIVA);

        return prova;
    }
}
