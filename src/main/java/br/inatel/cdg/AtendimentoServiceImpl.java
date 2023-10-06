package br.inatel.cdg;

public class AtendimentoServiceImpl implements AtendimentoService {
    @Override
    public boolean adicionaAtendimentoNaLista(String nomeDoProfessor, String horarioDeAtendimento, String periodo, Integer sala) {
        Atendimento atendimento = new Atendimento(nomeDoProfessor, horarioDeAtendimento, periodo, sala);
        return atendimento.adicionaAtendimentoNaLista();
    }

    @Override
    public String buscaAtendimento(String nomeDoProfessor) {
        return Atendimento.buscaAtendimentoNaLista(nomeDoProfessor);
    }

    @Override
    public String atualizaHorarioAtendimento(String nomeDoProfessor, String horarioDeAtendimento) {
        return Atendimento.atualizaHorarioAtendimento(nomeDoProfessor, horarioDeAtendimento);
    }

    @Override
    public boolean deletaAtendimento(String nomeDoProfessor) {
        return Atendimento.deletaAtendimento(nomeDoProfessor);
    }
}