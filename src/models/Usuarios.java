package models;

public class Usuarios {
	private String loginUsuario;
	private String senhaUsuario;

	public Usuarios() {
	}
	public Usuarios(String loginUsuario, String senhaUsuario) {
		this.setLoginUsuario(loginUsuario);
		this.setSenhaUsuario(senhaUsuario);
	}
	
	public String toString() {
		return(
		this.getLoginUsuario() + ", " +
		this.getSenhaUsuario() + ""
		);
	}
	public String[] toArray() {
		String[] arrayStr = {
		this.getLoginUsuario() + "",
		this.getSenhaUsuario() + ""
		};
		return arrayStr;
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
