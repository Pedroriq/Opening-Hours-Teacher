package br.inatel.cdg.test;

import br.inatel.cdg.AtendimentoService;

public class MockAtendimentoService implements AtendimentoService {

    @Override
    public boolean adicionaAtendimentoNaLista(String nomeDoProfessor, String horarioDeAtendimento, String periodo, Integer sala) {
        if (sala >= 1) {
            return true;
        }
        else {
            throw new IllegalArgumentException("Número de sala deve ser maior ou igual a 1");
        }
    }

    @Override
    public String buscaAtendimento(String nomeDoProfessor) {
        if (nomeDoProfessor == "Chris") {
            return AtendimentoConst.CHRIS;
        }
        else if (nomeDoProfessor == "Aquino") {
            return AtendimentoConst.AQUINO;
        }
        else if (nomeDoProfessor == "Vitor") {
            return AtendimentoConst.VITOR;
        }
        else {
            return null;
        }
    }

    @Override
    public String atualizaHorarioAtendimento(String nomeDoProfessor, String horarioDeAtendimento) {
        if (nomeDoProfessor == "Chris") {
            return AtendimentoConst.CHRIS_ATUALIZADO;
        }
        else if (nomeDoProfessor == "Aquino") {
            return AtendimentoConst.AQUINO_ATUALIZADO;
        }
        else if (nomeDoProfessor == "Vitor") {
            return AtendimentoConst.VITOR_ATUALIZADO;
        }
        else {
            return null;
        }
    }

    @Override
    public boolean deletaAtendimento(String nomeDoProfessor) {
        if (nomeDoProfessor == "Chris" || nomeDoProfessor == "Aquino" || nomeDoProfessor == "Vitor") {
            return true;
        }
        else {
            return false;
        }
    }
}
