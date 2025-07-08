package view.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import database.DBQuery;
import models.Produtos;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TelaProduto {
    private JFrame janela = new JFrame("Produtos");
    private Font fonte = new Font("Arial", Font.BOLD, 24);
    private Font fonte2 = new Font("Arial", Font.BOLD, 16);

    private JLabel textoIDProduto = new JLabel("ID:");
    private JLabel textoNome= new JLabel("Nome do Produto:");
    private JLabel textoEspecificacoes = new JLabel("Especificações Técnicas:");
    private JLabel textoStatus = new JLabel("Status Documentação:");
    private JLabel textoErro = new JLabel("Não foi possível localizar o produto");
    private JTextField campoID = new JTextField();
    private JLabel campoIDEstatico = new JLabel("");
    private JTextField campoNome = new JTextField();
    private JTextArea  campoEspecificacoes = new JTextArea ();
    private JScrollPane scrollCampoEspecificacoes = new JScrollPane(campoEspecificacoes);
    private JComboBox<String> comboStatus = new JComboBox<>(new String[] {
    		"PENDENTE", "COMPLETO", "INCOMPLETO"
    });
    private JLabel titulo = new JLabel("Produtos");
    
    //botoes
    private JButton botaoCriar= new JButton("Criar");
    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoDeletar = new JButton("Deletar");
    private JButton botaoPesquisar = new JButton("Pesquisar");
    private JButton botaoSalvar = new JButton("Salvar");
    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoLimpar = new JButton("Limpar");
	private int IDProdutoDigitado;

    public TelaProduto() {

        this.janela.setBounds(200, 200, 600, 500);
        this.janela.setLayout(null);
        this.janela.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        // textos
        this.titulo.setFont(fonte);
        this.titulo.setBounds(180, 20, 400, 30);
        
        this.textoIDProduto.setBounds(200, 60, 150, 25);
        this.textoIDProduto.setFont(fonte2);

        this.textoNome.setBounds(80, 100, 150, 25);
        this.textoNome.setFont(fonte2);

        this.textoEspecificacoes.setBounds(30, 140, 200, 25);
        this.textoEspecificacoes.setFont(fonte2);

        this.textoStatus.setBounds(50, 310, 180, 25);
        this.textoStatus.setFont(fonte2);
        
        //campos de informação
        this.campoID.setBounds(230, 60, 300, 25);
        this.campoIDEstatico.setBounds(230, 60, 300, 25);
        
        this.campoNome.setBounds(230, 100, 300, 25);
        this.campoNome.setEditable(false);
        
        this.comboStatus.setBounds(230, 310, 150, 25);
        this.comboStatus.setEditable(false);

        this.scrollCampoEspecificacoes.setBounds(230, 140, 300, 165);
        this.campoEspecificacoes.setLineWrap(true);
        this.campoEspecificacoes.setEditable(false);

        this.textoErro.setBounds(175, 380, 200, 40);
        
        //posição dos botões
        this.botaoCriar.setBounds(310, 350, 100, 40);
        this.botaoPesquisar.setBounds(200, 350, 100, 40);

        this.botaoDeletar.setBounds(140, 350, 100, 40);        
        this.botaoEditar.setBounds(360, 350, 100, 40);
        this.botaoLimpar.setBounds(250, 350, 100, 40);
        
        this.botaoCancelar.setBounds(310, 350, 100, 40);
        this.botaoSalvar.setBounds(200, 350, 100, 40);
        

        // Adicionando na janela
        janela.setVisible(true);
        this.janela.add(titulo);
        
        this.janela.add(textoIDProduto);
        this.janela.add(textoEspecificacoes);
        this.janela.add(textoNome);
        this.janela.add(textoStatus);
        
        this.janela.add(scrollCampoEspecificacoes);
        this.janela.add(campoNome);
        this.janela.add(comboStatus);
        this.janela.add(campoID);
        this.janela.add(campoIDEstatico);
        this.janela.add(textoErro);
        
        this.janela.add(botaoCriar);
        this.janela.add(botaoPesquisar);
        
        this.janela.add(botaoEditar);
        this.janela.add(botaoLimpar);
        this.janela.add(botaoDeletar);
        
        this.janela.add(botaoCancelar);
        this.janela.add(botaoSalvar);

        this.botaoCriar.setVisible(true);
        this.botaoPesquisar.setVisible(true);

        this.botaoEditar.setVisible(false);
        this.botaoLimpar.setVisible(false);
        this.botaoCancelar.setVisible(false);
        this.botaoDeletar.setVisible(false);
        this.botaoSalvar.setVisible(false);
        
        this.textoErro.setVisible(false);
        

		this.campoID.addKeyListener(new KeyAdapter() {
			public  void keyPressed(KeyEvent ke) {
				if(
						(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||  (ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)
						) {
					campoID.setEditable(true);
				}else {
					campoID.setEditable(false);
				}
			}
		});
		
		this.botaoCriar.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				manejaProduto();
			}
		});
		
		this.botaoEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manejaProduto();
			}
		});
		
		this.botaoCancelar.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				if(campoID.getText().equals("") || campoIDEstatico.getText().equals("")) {
					telaLimpa();
				}else {					
					exibeProduto();
					Produtos produtoNaTela = new Produtos();
		            IDProdutoDigitado = (int) Double.parseDouble(campoIDEstatico.getText());
					produtoNaTela.setIdProduto(IDProdutoDigitado);
					produtoNaTela.buscaProduto();
					campoNome.setText(produtoNaTela.getNomeProduto());
					campoEspecificacoes.setText(produtoNaTela.getEspecificacoesTecnicas());
					comboStatus.setSelectedItem(produtoNaTela.getDocumentacaoStatus());
				}
			}
		});
		
		this.botaoLimpar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				telaLimpa();
			}
		});
		
		this.botaoPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(campoID.getText().equals("")) {
					textoErro.setVisible(true);
					return;
				}else {
					textoErro.setVisible(false);
				}
				Produtos produtoNaTela = new Produtos();
	            IDProdutoDigitado = (int) Double.parseDouble(campoID.getText());
	            produtoNaTela.setIdProduto(IDProdutoDigitado);
				produtoNaTela.buscaProduto();
				String nomeProdutoDigitado = produtoNaTela.getNomeProduto();
				if(!(nomeProdutoDigitado == "" || nomeProdutoDigitado == null)) {
					exibeProduto();
					campoIDEstatico.setText(produtoNaTela.getIdProduto() + "");
					campoNome.setText(produtoNaTela.getNomeProduto());
					campoEspecificacoes.setText(produtoNaTela.getEspecificacoesTecnicas());
					comboStatus.setSelectedItem(produtoNaTela.getDocumentacaoStatus());
				}else {
					textoErro.setVisible(true);
				}
			}
		});
		
		this.botaoSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Produtos produtoNaTela = new Produtos();
				produtoNaTela.setNomeProduto(campoNome.getText());
				produtoNaTela.setEspecificacoesTecnicas(campoEspecificacoes.getText());
				produtoNaTela.setDocumentacaoStatus((String) comboStatus.getSelectedItem());
				if(campoID.getText().equals("")) {
					produtoNaTela.salvaProduto();
				}else {
					produtoNaTela.setIdProduto((int) Double.parseDouble(campoID.getText()));
					produtoNaTela.editaProduto();
				}
				botaoCriar.setVisible(false);
				botaoPesquisar.setVisible(false);
				botaoEditar.setVisible(true);
				botaoLimpar.setVisible(true);
				botaoDeletar.setVisible(true);
				botaoSalvar.setVisible(false);
				botaoCancelar.setVisible(false);
				
				campoID.setVisible(true);
				campoID.setEditable(false);
				
				campoNome.setVisible(true);
		        campoNome.setEditable(false);
		        
		        campoEspecificacoes.setVisible(true);
		        campoEspecificacoes.setEditable(false);
		        
				comboStatus.setVisible(true);
				comboStatus.setEnabled(false);
				
				campoID.setText(produtoNaTela.getIdProduto() + "");
				campoNome.setText(produtoNaTela.getNomeProduto());
				campoEspecificacoes.setText(produtoNaTela.getEspecificacoesTecnicas());
				comboStatus.setSelectedItem(produtoNaTela.getDocumentacaoStatus());
			}
		});
		this.botaoDeletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Produtos produtoNaTela = new Produtos();
				produtoNaTela.setIdProduto((int) Double.parseDouble(campoID.getText()));
				produtoNaTela.setNomeProduto(campoNome.getText());
				produtoNaTela.setEspecificacoesTecnicas(campoEspecificacoes.getText());
				produtoNaTela.setDocumentacaoStatus((String) comboStatus.getSelectedItem());
				produtoNaTela.deletaProduto();
				telaLimpa();
			}
		});
    }
    public void exibeProduto() {
		botaoCriar.setVisible(false);
		botaoPesquisar.setVisible(false);
		botaoEditar.setVisible(true);
		botaoLimpar.setVisible(true);
		botaoDeletar.setVisible(true);
		botaoSalvar.setVisible(false);
		botaoCancelar.setVisible(false);
		
		campoID.setVisible(false);
		campoID.setEditable(false);
		campoIDEstatico.setVisible(true);
		
		
		campoNome.setVisible(true);
        campoNome.setEditable(false);
        
        campoEspecificacoes.setVisible(true);
        campoEspecificacoes.setEditable(false);
        
		comboStatus.setVisible(true);
		comboStatus.setEnabled(false);
    }
    public void manejaProduto() {
		botaoCriar.setVisible(false);
		botaoPesquisar.setVisible(false);
		botaoEditar.setVisible(false);
		botaoLimpar.setVisible(false);
		botaoDeletar.setVisible(false);
		botaoSalvar.setVisible(true);
		botaoCancelar.setVisible(true);

		campoID.setVisible(false);
		campoID.setEditable(false);
		campoIDEstatico.setVisible(true);
		
		campoNome.setVisible(true);
        campoNome.setEditable(true);
        
        campoEspecificacoes.setVisible(true);
        campoEspecificacoes.setEditable(true);
        
		comboStatus.setVisible(true);
		comboStatus.setEnabled(true);
    }
    public void telaLimpa() {
		botaoCriar.setVisible(true);
		botaoPesquisar.setVisible(true);
		botaoEditar.setVisible(false);
		botaoLimpar.setVisible(false);
		botaoDeletar.setVisible(false);
		botaoSalvar.setVisible(false);
		botaoCancelar.setVisible(false);
		
		campoID.setVisible(true);
		campoID.setEditable(true);
		campoIDEstatico.setVisible(false);

		
		campoNome.setVisible(true);
        campoNome.setEditable(false);
        
        campoEspecificacoes.setVisible(true);
        campoEspecificacoes.setEditable(false);
		comboStatus.setVisible(true);
		comboStatus.setEnabled(false);
		
        campoEspecificacoes.setText("");
       	campoID.setText("");
		campoIDEstatico.setText("");
        campoNome.setText("");
		comboStatus.setSelectedIndex(0);
    }

}