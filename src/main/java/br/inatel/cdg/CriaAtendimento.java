package br.inatel.cdg;

import java.util.ArrayList;
import java.util.List;

public class CriaAtendimento {

    AtendimentoService atendimentoService;

    public CriaAtendimento(AtendimentoService service) {
        this.atendimentoService = service;
    }

    public boolean criaAtendimento(String nomeDoProfessor, String horarioDeAtendimento, String periodo, Integer sala) throws CriacaoAtendimentoInvalida {

        Atendimento atendimento = new Atendimento(nomeDoProfessor, horarioDeAtendimento, periodo, sala);
        return true;

    }
}



