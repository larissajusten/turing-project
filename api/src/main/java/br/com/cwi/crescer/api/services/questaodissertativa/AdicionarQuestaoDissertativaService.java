package br.com.cwi.crescer.api.services.questaodissertativa;

import br.com.cwi.crescer.api.controller.requests.questoes.QuestaoUnicaAlternativaRequest;
import br.com.cwi.crescer.api.domain.questao.QuestaoDissertativa;
import br.com.cwi.crescer.api.domain.usuario.Usuario;
import br.com.cwi.crescer.api.mapper.QuestaoDissertativaMapper;
import br.com.cwi.crescer.api.repository.questao.QuestaoDissertativaRepository;
import br.com.cwi.crescer.api.security.LoggedUser;
import br.com.cwi.crescer.api.services.autenticacao.VerificarPerfilUsuarioLogadoService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPeloEmailService;
import br.com.cwi.crescer.api.services.usuario.BuscarUsuarioPorIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarQuestaoDissertativaService {

    @Autowired
    private QuestaoDissertativaMapper mapper;

    @Autowired
    private QuestaoDissertativaRepository repository;

    @Autowired
    private BuscarUsuarioPorIdService buscarUsuarioPorIdService;

    @Autowired
    private VerificarPerfilUsuarioLogadoService verificarPerfilUsuarioLogadoService;

    @Autowired
    private BuscarUsuarioPeloEmailService buscarUsuarioPeloEmailService;

    @Autowired
    private LoggedUser loggedUser;

    public QuestaoDissertativa adicionar(QuestaoUnicaAlternativaRequest request) {

        verificarPerfilUsuarioLogadoService.verificar(loggedUser);

        QuestaoDissertativa questaoDissertativa = mapper.transformar(request);
        questaoDissertativa.setDataCriacao(LocalDate.now());

        Usuario usuario = buscarUsuarioPeloEmailService.buscar(loggedUser.getLogin());
        questaoDissertativa.setUsuario(usuario);

        repository.save(questaoDissertativa);

        return questaoDissertativa;
    }
}
