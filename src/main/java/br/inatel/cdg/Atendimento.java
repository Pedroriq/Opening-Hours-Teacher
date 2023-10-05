package br.inatel.cdg;

public class Atendimento {

    private String nomeDoProfessor;

    private String horarioDeAtendimento;

    private String periodo;

    private Integer sala;

    private Integer predio;

    public Atendimento(String nomeDoProfessor, String horarioDeAtendimento, String periodo, Integer sala) {
        this.nomeDoProfessor = nomeDoProfessor;
        this.horarioDeAtendimento = horarioDeAtendimento;
        this.periodo = periodo;
        this.sala = sala;
        this.predio = verifyPredio(sala);
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

    public void setPredio(Integer predio) {
        this.predio = predio;
    }

    public Integer verifyPredio(Integer sala){
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
            throw new IllegalArgumentException("Sala fora do intervalo permitido");
        }
    }

    /*
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
        } else if (sala >= 21) {
            String[] predio = new String[]{String.valueOf(6)};
            this.predio = predio;
        } else {
            throw new IllegalArgumentException("Sala fora do intervalo permitido");
        }
    }*/
}
