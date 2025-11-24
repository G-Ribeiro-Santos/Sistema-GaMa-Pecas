package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBConnection;


class OrdensServicoDAO {
	
    private Statement dbLink = null;

    public OrdensServicoDAO() {
        try {
            this.dbLink = new DBConnection().getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int insert(OrdensServico o) {
        try {
            if (o.getIdOP() != 0 && o.getIdProcesso() != 0 && !o.getStatusOS().isEmpty()) {
                String cmd = "INSERT INTO GamaPecas.OrdensServico(idOS, idOP, idProcesso, ordemRoteiro, recursoID, statusOS, tempoExecucaoReal) VALUES ('"
                        + o.getIdOS() + "', '" + o.getIdOP() + "', '" + o.getIdProcesso() + "', '" + o.getOrdemRoteiro() + "', '" + o.getRecursoID() + "', '" + o.getStatusOS() + "', '" + o.getTempoExecucaoReal() + "')";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int update(OrdensServico o) {
        try {
            if (o.getIdOS() != 0) {
                String cmd = "UPDATE GamaPecas.OrdensServico SET idOP = '" + o.getIdOP() +
                             "', idProcesso = '" + o.getIdProcesso() +
                             "', ordemRoteiro = '" + o.getOrdemRoteiro() +
                             "', recursoID = '" + o.getRecursoID() +
                             "', statusOS = '" + o.getStatusOS() +
                             "', tempoExecucaoReal = '" + o.getTempoExecucaoReal() +
                             "' WHERE idOS = '" + o.getIdOS() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int delete(OrdensServico o) {
        try {
            if (o.getIdOS() != 0) {
                String cmd = "DELETE FROM GamaPecas.OrdensServico WHERE idOS = '" + o.getIdOS() + "'";
                return dbLink.executeUpdate(cmd);
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ResultSet list(String where) {
        String cmd = "SELECT * FROM GamaPecas.OrdensServico";
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
