package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBConnection;

class MaquinasDAO {
    private Statement dbLink = null;

    public MaquinasDAO() {
        try {
            this.dbLink = new DBConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Maquinas m) {
        try {
            if (!m.getNomeMaquina().isEmpty() && !m.getDisponibilidade().isEmpty()) {
                String cmd = "INSERT INTO GamaPecas.Maquinas(idMaquina, nomeMaquina, disponibilidade) VALUES ('"
                        + m.getIdMaquina() + "', '" + m.getNomeMaquina() + "', '" + m.getDisponibilidade() + "')";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Maquinas m) {
        try {
            if (!m.getNomeMaquina().isEmpty() && !m.getDisponibilidade().isEmpty()) {
                String cmd = "UPDATE GamaPecas.Maquinas SET nomeMaquina = '" + m.getNomeMaquina() +
                             "', disponibilidade = '" + m.getDisponibilidade() +
                             "' WHERE idMaquina = '" + m.getIdMaquina() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(Maquinas m) {
        try {
            if (m.getIdMaquina() != 0) {
                String cmd = "DELETE FROM GamaPecas.Maquinas WHERE idMaquina = '" + m.getIdMaquina() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet list(String where) {
        String cmd = "SELECT * FROM GamaPecas.Maquinas";
        if (!where.isEmpty()) {
            cmd += " WHERE " + where;
        }
        try {
            return dbLink.executeQuery(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
