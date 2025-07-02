
package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBConnection;

class ProcessosDAO {
    private Statement dbLink = null;

    public ProcessosDAO() {
        try {
            this.dbLink = new DBConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Processos p) {
        try {
            if (!p.getNomeProcesso().isEmpty() && p.getIdMaquina() != 0) {
                String cmd = "INSERT INTO GamaPecas.Processos(idProcesso, nomeProcesso, idMaquina) VALUES ('"
                        + p.getIdProcesso() + "', '" + p.getNomeProcesso() + "', '" + p.getIdMaquina() + "')";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Processos p) {
        try {
            if (!p.getNomeProcesso().isEmpty()) {
                String cmd = "UPDATE GamaPecas.Processos SET nomeProcesso = '" + p.getNomeProcesso() +
                             "', idMaquina = '" + p.getIdMaquina() + "' WHERE idProcesso = '" + p.getIdProcesso() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(Processos p) {
        try {
            if (p.getIdProcesso() != 0) {
                String cmd = "DELETE FROM GamaPecas.Processos WHERE idProcesso = '" + p.getIdProcesso() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet list(String where) {
        String cmd = "SELECT * FROM GamaPecas.Processos";
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