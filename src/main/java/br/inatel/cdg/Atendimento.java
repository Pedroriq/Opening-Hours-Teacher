package br.inatel.cdg;

import com.google.gson.JsonArray;

import java.util.List;

public class Atendimento {

    private String nomeDoProfessor;

    private String horarioDeAtendimento;

    private String periodo;

    private String sala;

    private List predio;

    public Atendimento(String nomeDoProfessor, String horarioDeAtendimento, String periodo, String sala, JsonArray predio) {
    }

    public String getNomeDoProfessor() {
        return nomeDoProfessor;
    }

    public void setNomeDoProfessor(String nomeDoProfessor) {
        this.nomeDoProfessor = nomeDoProfessor;
    }

    public String getHorarioDeAtendimento() {
        return horarioDeAtendimento;
    }

    public void setHorarioDeAtendimento(String horarioDeAtendimento) {
        this.horarioDeAtendimento = horarioDeAtendimento;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    public List getPredio() {
        return predio;
    }

    public void setPredio(List predio) {
        this.predio = predio;
    }
}
