package classes;

import database.DBQuery;

public class Usuarios {
	private String loginUsuario;
	private String senhaUsuario;

	private String  tableName 	= "Usuario";
	private String  fieldsName 	= "login_usuario, senha_usuario";
	private String  fieldKey  	= "login_usuario";
	private DBQuery dbQuery = new DBQuery(tableName, fieldsName, fieldKey);
	
	public Usuarios() {
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
