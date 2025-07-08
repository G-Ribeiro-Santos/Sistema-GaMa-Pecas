package models;

import java.sql.ResultSet;
import java.sql.SQLException;

// Processos.java
public class Processos {
    private int idProcesso;
    private String nomeProcesso;
    private int idMaquina;

    public Processos() {
    }

    public Processos(int idProcesso, String nomeProcesso, int idMaquina) {
        this.idProcesso = idProcesso;
        this.nomeProcesso = nomeProcesso;
        this.idMaquina = idMaquina;
    }

    public Processos(String nomeProcesso, int idMaquina) {
        this.nomeProcesso = nomeProcesso;
        this.idMaquina = idMaquina;
    }

    public Boolean buscaProcesso() {
        ProcessosDAO processoPesquisado = new ProcessosDAO();
        ResultSet rs = processoPesquisado.listarPorID("id_Processo = " + this.getIdProcesso());
        try {
            while (rs.next()) {
                if (rs.getInt("id_Processo") == this.getIdProcesso()) {
                    this.setIdProcesso(rs.getInt("id_Processo"));
                    this.setNomeProcesso(rs.getString("Nome_Processo"));
                    this.setIdMaquina(rs.getInt("id_Maquina"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int salvaProcesso() {
        ProcessosDAO processoSalvo = new ProcessosDAO();
        this.setIdProcesso(processoSalvo.insert(this));
        return this.getIdProcesso();
    }

    public int editaProcesso() {
        ProcessosDAO processoSalvo = new ProcessosDAO();
        return processoSalvo.update(this);
    }

    public int deletaProcesso() {
        ProcessosDAO processoSalvo = new ProcessosDAO();
        return processoSalvo.delete(this);
    }

    public int getIdProcesso() {
        return idProcesso;
    }

    public void setIdProcesso(int idProcesso) {
        this.idProcesso = idProcesso;
    }

    public String getNomeProcesso() {
        return nomeProcesso;
    }

    public void setNomeProcesso(String nomeProcesso) {
        this.nomeProcesso = nomeProcesso;
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }
}
