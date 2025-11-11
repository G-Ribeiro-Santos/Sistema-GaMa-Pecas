package models;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuarios {
	private String loginUsuario;
	private String senhaUsuario;

	public Usuarios() {
	}
	public Usuarios(String loginUsuario, String senhaUsuario) {
		this.setLoginUsuario(loginUsuario);
		this.setSenhaUsuario(senhaUsuario);
	}

	public boolean validaUsuario() {
		UsuariosDAO userProcurado = new UsuariosDAO();
		try {		
			ResultSet rs = userProcurado.list("");
			while (rs.next()) {
				if (rs.getString("login_usuario").equals(this.getLoginUsuario()) && rs.getString("senha_usuario").equals(this.getSenhaUsuario())) {
					return true;
				}
			}
		} catch (SQLException e1) {
        e1.printStackTrace();
    }
		return false;
	}
	public String getSenhaUsuario() {
		return senhaUsuario;
	}
	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}
	public String getLoginUsuario() {
		return loginUsuario;
	}
	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}
	
}
