package br.com.cwi.crescer.api.validator;

import br.com.cwi.crescer.api.domain.enums.StatusProva;
import br.com.cwi.crescer.api.exception.usuario.UsuariojaTemProvaEmVigorException;
import br.com.cwi.crescer.api.repository.prova.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ProvaValidator {

    @Autowired
    private ProvaRepository provaRepository;

    public void verificarSeEmailDoCandidatoTemProvaEmAbertoNoSistema(String email) {

        if (provaRepository.existsByEmailCandidatoEqualsAndStatusEquals(email, StatusProva.ATIVA)) {
            throw new UsuariojaTemProvaEmVigorException("Usuário já possui uma prova ativa.");
        }
    }
}
