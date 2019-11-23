package br.com.cwi.crescer.api.mapper;

import br.com.cwi.crescer.api.controller.requests.prova.ProvaRequest;
import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.domain.prova.Prova;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.security.LoggedUser;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ProvaMapper {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Autowired
    private LoggedUser loggedUser;

    public Prova transformar(ProvaRequest request) {
        Prova prova = mapper.map(request, Prova.class);

        prova.setDataCriacao(LocalDateTime.now());
        prova.setEmailCandidato(request.getEmail());

        Usuario usuario = buscarUsuarioPeloEmailService.buscar(loggedUser.getLogin());

        prova.setCriador(usuario);
        prova.setStatus(StatusProva.ATIVA);

        return prova;
    }
}
