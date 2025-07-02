package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import database.DBConnection;

public class UsuariosDAO {
	private Statement dbLink = null;
	
	public UsuariosDAO() {
		try {
			this.dbLink = new DBConnection().getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int insert(Usuarios usuarioRecebido) {
		try {
			int linesAfected = 0;
			if (usuarioRecebido.getLoginUsuario() != "" && usuarioRecebido.getSenhaUsuario() != "") {
				String cmd =  " INSERT INTO GamaPecas.Usuarios(login_usuario, senha_usuario) "
						+ "VALUES ('";
				cmd +=	usuarioRecebido.getLoginUsuario() + "', '" +
						usuarioRecebido.getSenhaUsuario() + "')";
				linesAfected = dbLink.executeUpdate(cmd);
				return linesAfected;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public int update(Usuarios usuarioRecebido) {
		int linesAffected = 0;
		try {
			if (usuarioRecebido.getLoginUsuario() != "" && usuarioRecebido.getSenhaUsuario() != "") {
				String cmd = "UPDATE GamaPecas.Usuarios SET senha_usuario ='" + usuarioRecebido.getSenhaUsuario() + "'";
				cmd += " WHERE login_usuario =" + usuarioRecebido.getLoginUsuario();
				linesAffected = dbLink.executeUpdate(cmd);
				return linesAffected;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}
		return 0;
	}

	public int delete(Usuarios user) {
		try {
			int linesAfected = 0;
			if (user.getLoginUsuario() != "") {
				String cmd =  " DELETE FROM GamaPecas.Usuarios ";
				cmd += " WHERE login_usuario = " + user.getLoginUsuario();
				linesAfected = dbLink.executeUpdate(cmd);
				return linesAfected;
			}else{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return 0;
		}		
	}

	public ResultSet list(String where) {
		String cmd = "SELECT * FROM GamaPecas.Usuarios";
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
