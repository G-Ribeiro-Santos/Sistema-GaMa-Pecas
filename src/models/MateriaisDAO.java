package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBConnection;

class MateriaisDAO {
    private Statement dbLink = null;

    public MateriaisDAO() {
        try {
            this.dbLink = new DBConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Materiais m) {
        try {
            if (!m.getNomeMaterial().isEmpty() && !m.getUnidadeEstoque().isEmpty()) {
                String cmd = "INSERT INTO GamaPecas.Materiais(idMaterial, nomeMaterial, pontoRessuprimento, nivelEstoque, unidadeEstoque, statusObsolescencia) VALUES ('"
                        + m.getIdMaterial() + "', '" + m.getNomeMaterial() + "', '" + m.getPontoRessuprimento() + "', '" + m.getNivelEstoque() + "', '" + m.getUnidadeEstoque() + "', '" + m.isStatusObsolescencia() + "')";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Materiais m) {
        try {
            if (m.getIdMaterial() != 0) {
                String cmd = "UPDATE GamaPecas.Materiais SET nomeMaterial = '" + m.getNomeMaterial() +
                             "', pontoRessuprimento = '" + m.getPontoRessuprimento() +
                             "', nivelEstoque = '" + m.getNivelEstoque() +
                             "', unidadeEstoque = '" + m.getUnidadeEstoque() +
                             "', statusObsolescencia = '" + m.isStatusObsolescencia() +
                             "' WHERE idMaterial = '" + m.getIdMaterial() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(Materiais m) {
        try {
            if (m.getIdMaterial() != 0) {
                String cmd = "DELETE FROM GamaPecas.Materiais WHERE idMaterial = '" + m.getIdMaterial() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet list(String where) {
        String cmd = "SELECT * FROM GamaPecas.Materiais";
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

