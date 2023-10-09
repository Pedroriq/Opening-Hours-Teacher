package br.inatel.cdg;

public class AtendimentoImpl {

    AtendimentoService atendimentoService;

    public AtendimentoImpl(AtendimentoService service){
        this.atendimentoService = service;
    }

    public boolean adicionaAtendimentoNaLista(String nomeDoProfessor, String horarioDeAtendimento, String periodo, Integer sala){
        boolean adicionadoComSucesso = atendimentoService.adicionaAtendimentoNaLista(nomeDoProfessor, horarioDeAtendimento, periodo, sala);
        return adicionadoComSucesso;
    }

    public String buscaAtendimento(String nomeDoProfessor){
        String atendimentoJson = atendimentoService.buscaAtendimento(nomeDoProfessor);
        return atendimentoJson;
    }

    public String atualizaAtendimento(String nomeDoProfessor, String horarioDeAtendimento){
        String atendimentoAtualizadoJson = atendimentoService.atualizaHorarioAtendimento(nomeDoProfessor, horarioDeAtendimento);
        return atendimentoAtualizadoJson;
    }

    public boolean deletaAtendimento(String nomeDoProfessor){
        boolean atendimentoAtualizadoJson = atendimentoService.deletaAtendimento(nomeDoProfessor);
        return atendimentoAtualizadoJson;
    }
}
