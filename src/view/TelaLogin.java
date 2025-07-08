package view;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.Usuarios;

public class TelaLogin {
	
	private JFrame janela = new JFrame();
	private JLabel texto = new JLabel("Faça seu login");
	private JLabel textoCampoUsuario = new JLabel("Usuário:");
	private JLabel textoCampoSenha = new JLabel("Senha:");
	private JLabel textoErro = new JLabel("Login ou senha incorretos");
	private JTextField campoUsuario = new JTextField();
	private JPasswordField campoSenha = new JPasswordField();
	private JButton EnviarLogin = new JButton();
	private Font fonte = new Font("Arial", Font.BOLD, 26);
	private Font fonte2 = new Font("Arial", Font.BOLD, 24);
	private Font fonte3 = new Font("Arial", Font.BOLD, 20);
	private Font fonteErro = new Font("Arial", Font.BOLD, 14);
	private String LoginDigitado = "";
	private String SenhaDigitado = "";

	public TelaLogin() {
		this.janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.janela.setTitle("Login GamaPeças");
		
		//Tamanho e posição da janela de login
		this.janela.setBounds(700, 300, 500, 350);
		this.janela.setLayout(null);
		this.janela.getContentPane().setBackground(Color.LIGHT_GRAY);
		//Tamanho e posição dos 
		//labels
		this.texto.setBounds(150, 50, 200, 40);
		this.texto.setFont(fonte);
		
		this.textoCampoUsuario.setBounds(80, 100, 150, 40);
		this.textoCampoUsuario.setFont(fonte2);
		
		this.textoCampoSenha.setBounds(100, 150, 150, 40);
		this.textoCampoSenha.setFont(fonte2);

		this.textoErro.setBounds(150, 240, 200, 40);
		this.textoErro.setFont(fonteErro);
		this.textoErro.setVisible(false);
		
		//textfield
		this.campoUsuario.setBounds(200, 100, 200, 35);
		this.campoUsuario.setFont(fonte3);
		
		this.campoSenha.setBounds(200, 150, 200, 35);
		this.campoSenha.setFont(fonte3);
		
		//button
		this.EnviarLogin.setBounds(175, 200, 150, 40);
		this.EnviarLogin.setText("ENTRAR");
		this.EnviarLogin.setFont(fonte3);
		
		//adicionando tudo à tela
		this.janela.setVisible(true);
		this.janela.add(texto);
		this.janela.add(textoCampoUsuario);
		this.janela.add(textoCampoSenha);
		this.janela.add(textoErro);
		this.janela.add(campoUsuario);
		this.janela.add(campoSenha);
		this.janela.add(EnviarLogin);

		this.EnviarLogin.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				LoginDigitado = campoUsuario.getText();
				SenhaDigitado = new String(campoSenha.getPassword());
				Usuarios userDigitado = new Usuarios(LoginDigitado, SenhaDigitado);
				if(userDigitado.validaUsuario()) {
                	TelaInicial home = new TelaInicial();
                	janela.removeAll();
                	janela.setVisible(false);
				}else {
		    		textoErro.setVisible(true);
				}
			}
		});
	}
}

