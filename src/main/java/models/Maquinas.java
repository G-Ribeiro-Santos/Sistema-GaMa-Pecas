package models;

import java.sql.ResultSet;
import java.sql.SQLException;

// Maquinas.java
public class Maquinas {
    private int idMaquina;
    private String nomeMaquina;
    private String disponibilidade;

    public Maquinas() {
    }

    public Maquinas(int idMaquina, String nomeMaquina, String disponibilidade) {
        this.idMaquina = idMaquina;
        this.nomeMaquina = nomeMaquina;
        this.disponibilidade = disponibilidade;
    }

    public Maquinas(String nomeMaquina, String disponibilidade) {
        this.nomeMaquina = nomeMaquina;
        this.disponibilidade = disponibilidade;
    }

    public int buscaMaquina() {
        MaquinasDAO maquinaPesquisada = new MaquinasDAO();
        ResultSet rs = maquinaPesquisada.listarPorID("id_Maquina = " + this.getIdMaquina());
        try {
            while (rs.next()) {
                if (rs.getInt("id_Maquina") == this.getIdMaquina()) {
                    this.setIdMaquina(rs.getInt("id_Maquina"));
                    this.setNomeMaquina(rs.getString("Nome_Maquina"));
                    this.setDisponibilidade(rs.getString("Disponibilidade"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return this.getIdMaquina();
    }

    public int salvaMaquina() {
        MaquinasDAO maquinaSalva = new MaquinasDAO();
        this.setIdMaquina(maquinaSalva.insert(this));
        return this.getIdMaquina();
    }

    public int editaMaquina() {
        MaquinasDAO maquinaSalva = new MaquinasDAO();
        return maquinaSalva.update(this);
    }

    public int deletaMaquina() {
        MaquinasDAO maquinaSalva = new MaquinasDAO();
        return maquinaSalva.delete(this);
    }

    public int getIdMaquina() {
        return idMaquina;
    }

    public void setIdMaquina(int idMaquina) {
        this.idMaquina = idMaquina;
    }

    public String getNomeMaquina() {
        return nomeMaquina;
    }

    public void setNomeMaquina(String nomeMaquina) {
        this.nomeMaquina = nomeMaquina;
    }

    public String getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(String disponibilidade) {
        this.disponibilidade = disponibilidade;
    }
}
