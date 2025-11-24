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
            if (!p.getNomeProcesso().isEmpty()) {
                String cmd = "INSERT INTO Processos(Nome_Processo, id_Maquina) VALUES ('"
                        + p.getNomeProcesso() + "', '" + p.getIdMaquina() + "')";
                dbLink.executeUpdate(cmd);
            }

            ResultSet rs = null;
            String cmd2 = "SELECT id_Processo FROM Processos WHERE Nome_Processo = '" + p.getNomeProcesso() + "'";
            rs = dbLink.executeQuery(cmd2);
            int ultimoID = 0;
            while (rs.next()) {
                ultimoID = rs.getInt(1);
            }
            return ultimoID;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Processos p) {
        try {
            if (!p.getNomeProcesso().isEmpty() && p.getIdProcesso() != 0) {
                String cmd = "UPDATE Processos SET Nome_Processo = '" + p.getNomeProcesso()
                        + "', id_Maquina = '" + p.getIdMaquina()
                        + "' WHERE id_Processo = '" + p.getIdProcesso() + "'";
                dbLink.executeUpdate(cmd);
                return p.getIdProcesso();
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
                String cmd = "DELETE FROM Processos WHERE id_Processo = '" + p.getIdProcesso() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet listarPorID(String where) {
        String cmd = "SELECT * FROM Processos";
        if (!where.isEmpty()) {
            cmd += " WHERE " + where;
        }
        ResultSet rs = null;
        try {
            rs = dbLink.executeQuery(cmd);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }
}
