package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBConnection;

class OrdensProducaoDAO {
    private Statement dbLink = null;

    public OrdensProducaoDAO() {
        try {
            this.dbLink = new DBConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(OrdensProducao o) {
        try {
            if (o.getIdProduto() != 0 && !o.getStatusOP().isEmpty()) {
                String cmd = "INSERT INTO GamaPecas.OrdensProducao(idOP, idProduto, quantidadeProduzir, statusOP, volumeProduzido) VALUES ('"
                        + o.getIdOP() + "', '" + o.getIdProduto() + "', '" + o.getQuantidadeProduzir() + "', '" + o.getStatusOP() + "', '" + o.getVolumeProduzido() + "')";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(OrdensProducao o) {
        try {
            if (o.getIdOP() != 0) {
                String cmd = "UPDATE GamaPecas.OrdensProducao SET idProduto = '" + o.getIdProduto() +
                             "', quantidadeProduzir = '" + o.getQuantidadeProduzir() +
                             "', statusOP = '" + o.getStatusOP() +
                             "', volumeProduzido = '" + o.getVolumeProduzido() +
                             "' WHERE idOP = '" + o.getIdOP() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(OrdensProducao o) {
        try {
            if (o.getIdOP() != 0) {
                String cmd = "DELETE FROM GamaPecas.OrdensProducao WHERE idOP = '" + o.getIdOP() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet list(String where) {
        String cmd = "SELECT * FROM GamaPecas.OrdensProducao";
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
