package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBConnection;

public class FichaTecnicaDAO {
    private Statement dbLink = null;

    public FichaTecnicaDAO() {
        try {
            this.dbLink = new DBConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(FichaTecnica f) {
        try {
            if (f.getIdProduto() != 0 && f.getIdMaterial() != 0) {
                String cmd = "INSERT INTO GamaPecas.FichaTecnica(idProduto, idMaterial, quantidadeMaterial) VALUES ('"
                        + f.getIdProduto() + "', '" + f.getIdMaterial() + "', '" + f.getQuantidadeMaterial() + "')";
                return dbLink.executeUpdate(cmd);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(FichaTecnica f) {
        try {
            if (f.getIdProduto() != 0 && f.getIdMaterial() != 0 && f.getQuantidadeMaterial() != 0) {
                String cmd = "UPDATE GamaPecas.FichaTecnica SET quantidadeMaterial = '" + f.getQuantidadeMaterial() + "' " +
                             "WHERE idProduto = '" + f.getIdProduto() + "' AND idMaterial = '" + f.getIdMaterial() + "'";
                return dbLink.executeUpdate(cmd);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(FichaTecnica f) {
        try {
            if (f.getIdProduto() != 0 && f.getIdMaterial() != 0) {
                String cmd = "DELETE FROM GamaPecas.FichaTecnica WHERE idProduto = '" + f.getIdProduto() +
                             "' AND idMaterial = '" + f.getIdMaterial() + "'";
                return dbLink.executeUpdate(cmd);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet list(String where) {
        String cmd = "SELECT * FROM GamaPecas.FichaTecnica";
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