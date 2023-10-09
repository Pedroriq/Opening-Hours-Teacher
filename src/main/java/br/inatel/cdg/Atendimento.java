package br.inatel.cdg;

import java.util.List;

import com.google.gson.Gson;

import java.util.ArrayList;

public class Atendimento {

    private String nomeDoProfessor;

    private String horarioDeAtendimento;

    private String periodo;

    private Integer sala;

    private Integer predio;

    private static List<Atendimento> atendimentos = new ArrayList<Atendimento>();

    public Atendimento(String nomeDoProfessor, String horarioDeAtendimento, String periodo, Integer sala) {
        this.nomeDoProfessor = nomeDoProfessor;
        this.horarioDeAtendimento = horarioDeAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = setPredio(sala);
    }

    public boolean adicionaAtendimentoNaLista() {
        return atendimentos.add(this);
    }

    public static String buscaAtendimentoNaLista(String nomeDoProfessor) {
        for (int i = 0; i < atendimentos.size(); i++) {
            if (atendimentos.get(i).nomeDoProfessor == nomeDoProfessor) {
                Gson gson = new Gson();
                return gson.toJson(atendimentos.get(i));
            }
        }
        return null;
    }

    public static String atualizaHorarioAtendimento(String nomeDoProfessor, String horarioDeAtendimento) {
        for (int i = 0; i < atendimentos.size(); i++) {
            if (atendimentos.get(i).nomeDoProfessor == nomeDoProfessor) {
                atendimentos.get(i).horarioDeAtendimento = horarioDeAtendimento;
                Gson gson = new Gson();
                return gson.toJson(atendimentos.get(i));
            }
        }
        return null;
    }

    public static boolean deletaAtendimento(String nomeDoProfessor) {
        for (int i = 0; i < atendimentos.size(); i++) {
            if (atendimentos.get(i).nomeDoProfessor == nomeDoProfessor) {
                atendimentos.remove(atendimentos.get(i));
                return true;
            }
        }
        return false;
    }

    public static boolean deletaTodosAtendimentos() {
        atendimentos.clear();
        return true;
    }

    public String getNomeDoProfessor() {
        return this.nomeDoProfessor;
    }

    public void setNomeDoProfessor(String nomeDoProfessor) {
        this.nomeDoProfessor = nomeDoProfessor;
    }

    public String getHorarioDeAtendimento() {
        return this.horarioDeAtendimento;
    }

    public void setHorarioDeAtendimento(String horarioDeAtendimento) {
        this.horarioDeAtendimento = horarioDeAtendimento;
    }

    public String getPeriodo() {
        return this.periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getSala() {
        return this.sala;
    }

    public void setSala(Integer sala) {
        this.sala = sala;
    }

    public Integer getPredio() {
        return this.predio;
    }

    public Integer setPredio(Integer sala){
        if (sala >= 1 && sala <= 5) {
            return 1;
        }
        else if (sala >= 6 && sala <= 10) {
            return 2;
        }
        else if (sala >= 11 && sala <= 15) {
            return 3;
        }
        else if (sala >= 16 && sala <= 20) {
            return 4;
        }
        else if (sala >= 21) {
            return 6;
        }
        else {
            throw new IllegalArgumentException("Número de sala deve ser maior ou igual a 1");
        }
    }
}
