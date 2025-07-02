package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBConnection;

class ProdutosDAO {
    private Statement dbLink = null;

    public ProdutosDAO() {
        try {
            this.dbLink = new DBConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(Produtos p) {
        try {
            if (!p.getNomeProduto().isEmpty()) {
                String cmd = "INSERT INTO GamaPecas.Produtos(idProduto, nomeProduto, especificacoesTecnicas, documentacaoStatus) VALUES ('"
                        + p.getIdProduto() + "', '" + p.getNomeProduto() + "', '" + p.getEspecificacoesTecnicas() + "', '" + p.getDocumentacaoStatus() + "')";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Produtos p) {
        try {
            if (!p.getNomeProduto().isEmpty()) {
                String cmd = "UPDATE GamaPecas.Produtos SET nomeProduto = '" + p.getNomeProduto() +
                             "', especificacoesTecnicas = '" + p.getEspecificacoesTecnicas() +
                             "', documentacaoStatus = '" + p.getDocumentacaoStatus() +
                             "' WHERE idProduto = '" + p.getIdProduto() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(Produtos p) {
        try {
            if (p.getIdProduto() != 0) {
                String cmd = "DELETE FROM GamaPecas.Produtos WHERE idProduto = '" + p.getIdProduto() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet list(String where) {
        String cmd = "SELECT * FROM GamaPecas.Produtos";
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
