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
                String cmd = "INSERT INTO Produtos(nome_produto, Especificacoes_tecnicas, Documentacao_status) VALUES ('"
                        + p.getNomeProduto() + "', '" + p.getEspecificacoesTecnicas() + "', '" + p.getDocumentacaoStatus() + "')";
                dbLink.executeUpdate(cmd);
            }
            
            ResultSet rs = null;
            String cmd2 = "SELECT id_produto FROM Produtos WHERE nome_produto = '" + p.getNomeProduto() + "'";
            rs = dbLink.executeQuery(cmd2);
            int ultimoID = 0;
            while(rs.next()) {
            ultimoID = rs.getInt(1);
            }
            return ultimoID;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(Produtos p) {
        try {
            if (!p.getNomeProduto().isEmpty() && p.getIdProduto() != 0) {
                String cmd = "UPDATE Produtos SET nome_produto = '" + p.getNomeProduto() +
                             "', Especificacoes_tecnicas = '" + p.getEspecificacoesTecnicas() +
                             "', Documentacao_status = '" + p.getDocumentacaoStatus();
                cmd += "' WHERE id_produto = '" + p.getIdProduto() + "'";
                dbLink.executeUpdate(cmd);
                return p.getIdProduto();
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
                String cmd = "DELETE FROM Produtos WHERE id_produto = '" + p.getIdProduto() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet listarPorID(String where) {
        String cmd = "SELECT * FROM Produtos";
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
