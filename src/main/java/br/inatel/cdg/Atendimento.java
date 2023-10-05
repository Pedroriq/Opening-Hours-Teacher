package br.inatel.cdg;

import com.google.gson.JsonArray;

import java.util.List;

public class Atendimento {

    private String nomeDoProfessor;

    private String horarioDeAtendimento;

    private String periodo;

    private Integer sala;

    private String[] predio;

    public Atendimento() {
        this.nomeDoProfessor = null;
        this.horarioDeAtendimento = null;
        this.periodo = null;
        this.sala = null;
        this.predio = null;
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

    public int getSala() {
        return this.sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

    public String[] getPredio() {
        return this.predio;
    }

    public void setPredio(Integer sala) {
        if (sala >= 1 && sala <= 5) {
            String[] predio = new String[]{String.valueOf(1)};
            this.predio = predio;
        }
        else if (sala >= 6 && sala <= 10) {
            String[] predio = new String[]{String.valueOf(2)};
            this.predio = predio;
        }
        else if (sala >= 11 && sala <= 15) {
            String[] predio = new String[]{String.valueOf(3)};
            this.predio = predio;
        } else if (sala >= 16 && sala <= 20) {
            String[] predio = new String[]{String.valueOf(4)};
            this.predio = predio;
        } else if (sala == 21) {
            String[] predio = new String[]{String.valueOf(5)};
            this.predio = predio;
        } else {
            throw new IllegalArgumentException("Sala fora do intervalo permitido");
        }
    }
}
