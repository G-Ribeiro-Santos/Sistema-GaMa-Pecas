package models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBConnection;

class UsoMaterialOPDAO {
    private Statement dbLink = null;

    public UsoMaterialOPDAO() {
        try {
            this.dbLink = new DBConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(UsoMaterialOP u) {
        try {
            if (u.getIdOP() != 0 && u.getIdProduto() != 0) {
                String cmd = "INSERT INTO GamaPecas.UsoMaterialOP(idOP, idProduto, quantidadeReservada, quantidadeConsumida) VALUES ('"
                        + u.getIdOP() + "', '" + u.getIdProduto() + "', '" + u.getQuantidadeReservada() + "', '" + u.getQuantidadeConsumida() + "')";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(UsoMaterialOP u) {
        try {
            if (u.getIdOP() != 0 && u.getIdProduto() != 0) {
                String cmd = "UPDATE GamaPecas.UsoMaterialOP SET quantidadeReservada = '" + u.getQuantidadeReservada() +
                             "', quantidadeConsumida = '" + u.getQuantidadeConsumida() +
                             "' WHERE idOP = '" + u.getIdOP() + "' AND idProduto = '" + u.getIdProduto() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(UsoMaterialOP u) {
        try {
            if (u.getIdOP() != 0 && u.getIdProduto() != 0) {
                String cmd = "DELETE FROM GamaPecas.UsoMaterialOP WHERE idOP = '" + u.getIdOP() + "' AND idProduto = '" + u.getIdProduto() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet list(String where) {
        String cmd = "SELECT * FROM GamaPecas.UsoMaterialOP";
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
