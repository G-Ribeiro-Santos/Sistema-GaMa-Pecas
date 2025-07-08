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
            if (!m.getNomeMaterial().isEmpty()) {
                String cmd = "INSERT INTO Materiais(nome_material, Nivel_estoque, Unidade_estoque, Ponto_ressuprimento, Status_Obsolescencia) VALUES ('"
                        + m.getNomeMaterial() + "', '" + m.getNivelEstoque() + "', '" + m.getUnidadeEstoque() + "', '" + m.getPontoRessuprimento() + "', " + m.getStatusObsolescencia() + ")";
                dbLink.executeUpdate(cmd);
            }
            ResultSet rs = null;
            String cmd2 = "SELECT id_Material FROM Materiais WHERE nome_material = '" + m.getNomeMaterial() + "'";
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
    
    public int update(Materiais m) {
        try {
            if (m.getIdMaterial() != 0) {
                String cmd = "UPDATE Materiais SET nome_material = '" + m.getNomeMaterial() +
                             "', Ponto_ressuprimento = '" + m.getPontoRessuprimento() +
                             "', Nivel_estoque = '" + m.getNivelEstoque() +
                             "', Unidade_estoque = '" + m.getUnidadeEstoque() +
                             "', Status_Obsolescencia = " + m.getStatusObsolescencia() +
                             " WHERE id_Material = '" + m.getIdMaterial() + "'";
                dbLink.executeUpdate(cmd);
                return m.getIdMaterial();
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
                String cmd = "DELETE FROM Materiais WHERE id_Material = '" + m.getIdMaterial() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet listarPorID(String where) {
        String cmd = "SELECT * FROM Materiais";
        if (!where.isEmpty()) {
            cmd += " WHERE" + where;
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

