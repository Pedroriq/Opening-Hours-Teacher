package br.inatel.cdg;

public interface AtendimentoService {

    public boolean adicionaAtendimentoNaLista(String nomeDoProfessor, String horarioDeAtendimento, String periodo, Integer sala);

    public String buscaAtendimento(String nomeDoProfessor);

    public String atualizaHorarioAtendimento(String nomeDoProfessor, String horarioDeAtendimento);

    public boolean deletaAtendimento(String nomeDoProfessor);
}