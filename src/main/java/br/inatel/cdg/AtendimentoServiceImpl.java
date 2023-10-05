package br.inatel.cdg;

public class AtendimentoServiceImpl implements AtendimentoService {
    @Override
    public Atendimento buscaAtendimentos(String nomeDoProfessor) {
        Atendimento atendimento = new Atendimento();
        atendimento.setNomeDoProfessor("Chris");
        return atendimento;
    }
}