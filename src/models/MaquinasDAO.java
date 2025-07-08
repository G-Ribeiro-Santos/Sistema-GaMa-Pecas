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
            if (!m.getNomeMaquina().isEmpty()) {
                String cmd = "INSERT INTO Maquinas(Nome_Maquina, Disponibilidade) VALUES ('"
                        + m.getNomeMaquina() + "', '" + m.getDisponibilidade() + "')";
                dbLink.executeUpdate(cmd);
            }
            
            ResultSet rs = null;
            String cmd2 = "SELECT id_Maquina FROM Maquinas WHERE Nome_Maquina = '" + m.getNomeMaquina() + "'";
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

    public int update(Maquinas m) {
        try {
            if (!m.getNomeMaquina().isEmpty() && m.getIdMaquina() != 0) {
                String cmd = "UPDATE Maquinas SET Nome_Maquina = '" + m.getNomeMaquina()
                        + "', Disponibilidade = '" + m.getDisponibilidade()
                        + "' WHERE id_Maquina = '" + m.getIdMaquina() + "'";
                dbLink.executeUpdate(cmd);
                return m.getIdMaquina();
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
                String cmd = "DELETE FROM Maquinas WHERE id_Maquina = '" + m.getIdMaquina() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet listarPorID(String where) {
        String cmd = "SELECT * FROM Maquinas";
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
