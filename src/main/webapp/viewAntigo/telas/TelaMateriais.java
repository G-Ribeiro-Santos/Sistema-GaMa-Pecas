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
import javax.swing.JTextField;
import models.Materiais;


public class TelaMateriais {
    private JFrame janela = new JFrame("Materials");
    private Font fonte = new Font("Arial", Font.BOLD, 24);
    private Font fonte2 = new Font("Arial", Font.BOLD, 16);

    private JLabel textoIDMaterial = new JLabel("ID:");
    private JLabel textoNome= new JLabel("Nome do Material:");
    private JLabel textoObsoleto = new JLabel("Obsoleto:");
    private JLabel textoErro = new JLabel("Não foi possível localizar o Material");
    private JLabel textoUnidadeEstoque = new JLabel("Un:");
    private JLabel textoNivelEstoque = new JLabel("Disponível:");
    private JLabel textoPontoRessuprimento = new JLabel("Ponto crítico:");
    private JTextField campoID = new JTextField();
    private JLabel campoIDEstatico = new JLabel("");
    private JTextField campoNome = new JTextField();
    private JTextField campoUnidadeEstoque = new JTextField();
    private JTextField campoNivelEstoque = new JTextField();
    private JTextField campoPontoRessuprimento = new JTextField();
    private JComboBox<String> comboObsoleto = new JComboBox<>(new String[] {"DESATIVADO", "OK"});
    private JLabel titulo = new JLabel("Materiais");

    //botoes
    private JButton botaoCriar= new JButton("Criar");
    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoDeletar = new JButton("Deletar");
    private JButton botaoPesquisar = new JButton("Pesquisar");
    private JButton botaoSalvar = new JButton("Salvar");
    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoLimpar = new JButton("Limpar");
	private int IDMaterialDigitado;

    public TelaMateriais() {

        janela.setBounds(200, 200, 600, 370);
        this.janela.setLayout(null);
        this.janela.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.titulo.setFont(fonte);
        this.titulo.setBounds(250, 20, 200, 30);
        
        this.textoIDMaterial.setBounds(195, 60, 150, 25);
        this.textoIDMaterial.setFont(fonte2);

        this.textoNome.setBounds(80, 100, 150, 25);
        this.textoNome.setFont(fonte2);


        this.textoObsoleto.setBounds(50, 310, 180, 25);
        this.textoObsoleto.setFont(fonte2);
        
        this.textoNivelEstoque.setBounds(130, 140, 180, 25);
        this.textoNivelEstoque.setFont(fonte2);
        this.textoUnidadeEstoque.setBounds(320, 140, 30, 25);
        this.textoUnidadeEstoque.setFont(fonte2);
        this.textoPontoRessuprimento.setBounds(110,170, 150,25);
        this.textoPontoRessuprimento.setFont(fonte2);

        this.textoObsoleto.setBounds(140, 200, 180, 25);
        this.textoObsoleto.setFont(fonte2);
        
        this.campoID.setBounds(230, 60, 300, 25);
        this.campoIDEstatico.setBounds(230, 60, 300, 25);
        this.campoNome.setBounds(230, 100, 300, 25);
        this.campoNome.setEditable(false);
        this.comboObsoleto.setBounds(230, 200, 150, 25);
        this.comboObsoleto.setEditable(false);
        this.campoUnidadeEstoque.setBounds(360,140, 70, 25);
        this.campoNivelEstoque.setBounds(230, 140, 80, 25);
        this.campoPontoRessuprimento.setBounds(230, 170, 80, 25);

        //botões
        this.botaoCriar.setBounds(310, 250, 100, 40);
        this.botaoPesquisar.setBounds(200, 250, 100, 40);
        this.textoErro.setBounds(175, 270, 200, 40);

        this.botaoEditar.setBounds(310, 250, 100, 40);
        this.botaoLimpar.setBounds(200, 250, 100, 40);
        this.botaoDeletar.setBounds(320, 250, 100, 40);        
        
        this.botaoCancelar.setBounds(310, 250, 100, 40);
        this.botaoSalvar.setBounds(200, 250, 100, 40);
        

        // Adicionando na janela
        janela.setVisible(true);
        this.janela.add(titulo);
        
        this.janela.add(textoIDMaterial);
        this.janela.add(textoNome);
        this.janela.add(textoObsoleto);
        this.janela.add(textoNivelEstoque);
        this.janela.add(textoUnidadeEstoque);
        this.janela.add(textoObsoleto);
        this.janela.add(textoPontoRessuprimento);

        this.janela.add(campoNome);
        this.janela.add(comboObsoleto);
        this.janela.add(campoID);
        this.janela.add(campoIDEstatico);
        this.janela.add(campoNivelEstoque);
        this.janela.add(campoUnidadeEstoque);
        this.janela.add(textoErro);
        this.janela.add(campoPontoRessuprimento);
        
        this.janela.add(botaoCriar);
        this.janela.add(botaoPesquisar);
        
        this.janela.add(botaoEditar);
        this.janela.add(botaoLimpar);
        this.janela.add(botaoDeletar);
        
        this.janela.add(botaoCancelar);
        this.janela.add(botaoSalvar);

        //visibilidades dos botões
        this.botaoCriar.setVisible(true);
        this.botaoPesquisar.setVisible(true);

        this.botaoEditar.setVisible(false);
        this.botaoLimpar.setVisible(false);
        this.botaoDeletar.setVisible(false);
        
        this.botaoCancelar.setVisible(false);
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
		this.campoNivelEstoque.addKeyListener(new KeyAdapter() {
			public  void keyPressed(KeyEvent ke) {
				if(
						(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||  (ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)
						) {
					campoNivelEstoque.setEditable(true);
				}else {
					campoNivelEstoque.setEditable(false);
				}
			}
		});
		this.campoPontoRessuprimento.addKeyListener(new KeyAdapter() {
			public  void keyPressed(KeyEvent ke) {
				if(
						(ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||  (ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)
						) {
					campoPontoRessuprimento.setEditable(true);
				}else {
					campoPontoRessuprimento.setEditable(false);
				}
			}
		});
		
		this.botaoCriar.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				campoID.setText("");
				campoIDEstatico.setText("");
				manejaMaterial();
			}
		});
		
		this.botaoEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				manejaMaterial();
			}
		});
		
		this.botaoCancelar.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				if(campoID.getText().equals("") || campoIDEstatico.getText().equals("")) {
					telaLimpa();
				}else {					
					exibeMaterial();
					Materiais materialNaTela = new Materiais();
		            IDMaterialDigitado = (int) Double.parseDouble(campoIDEstatico.getText());
					materialNaTela.setIdMaterial(IDMaterialDigitado);
					materialNaTela.buscaMaterial();
					campoNome.setText(materialNaTela.getNomeMaterial());
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
				Materiais materialNaTela = new Materiais();
	            IDMaterialDigitado = (int) Double.parseDouble(campoID.getText());
	            materialNaTela.setIdMaterial(IDMaterialDigitado);
				materialNaTela.buscaMaterial();
				String nomeMaterialDigitado = materialNaTela.getNomeMaterial();
				if(!(nomeMaterialDigitado == "" || nomeMaterialDigitado == null)) {
					campoIDEstatico.setText(materialNaTela.getIdMaterial() + "");
			        campoNome.setText(materialNaTela.getNomeMaterial());
			        campoNivelEstoque.setText(materialNaTela.getNivelEstoque() + "");
			        campoUnidadeEstoque.setText(materialNaTela.getUnidadeEstoque());
			        campoPontoRessuprimento.setText(materialNaTela.getPontoRessuprimento() + "");
			        comboObsoleto.setEnabled(true);
			        comboObsoleto.setSelectedIndex(materialNaTela.getStatusObsolescencia() ? 1 : 0);
					exibeMaterial();
				}else {
					textoErro.setVisible(true);
				}
			}
		});
		
		this.botaoSalvar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Materiais materialNaTela = new Materiais();
				materialNaTela.setNomeMaterial(campoNome.getText());
				materialNaTela.setNivelEstoque((float) Double.parseDouble(campoNivelEstoque.getText()));
				materialNaTela.setUnidadeEstoque(campoUnidadeEstoque.getText());
				materialNaTela.setPontoRessuprimento((float) Double.parseDouble(campoPontoRessuprimento.getText()));
				materialNaTela.setStatusObsolescencia((comboObsoleto.getSelectedIndex() -1 != 0));
				if(campoID.getText().equals("")) {
					materialNaTela.salvaMaterial();
				}else {
					materialNaTela.setIdMaterial((int) Double.parseDouble(campoID.getText()));
					materialNaTela.editaMaterial();
				}
				
				campoID.setText(materialNaTela.getIdMaterial() + "");
				campoIDEstatico.setText(materialNaTela.getIdMaterial() + "");

		        campoNome.setText(materialNaTela.getNomeMaterial());
		        campoNivelEstoque.setText(materialNaTela.getNivelEstoque() + "");
		        campoUnidadeEstoque.setText(materialNaTela.getUnidadeEstoque());
		        campoPontoRessuprimento.setText(materialNaTela.getPontoRessuprimento() + "");
		        comboObsoleto.setEnabled(true);
		        comboObsoleto.setSelectedIndex(materialNaTela.getStatusObsolescencia() ? 1 : 0);
				exibeMaterial();
			}
		});
		this.botaoDeletar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Materiais materialNaTela = new Materiais();
				materialNaTela.setIdMaterial((int) Double.parseDouble(campoID.getText()));
				materialNaTela.setNomeMaterial(campoNome.getText());
				materialNaTela.deletaMaterial();
				telaLimpa();
			}
		});
    }
    public void exibeMaterial() {
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

        campoNome.setEditable(false);
        campoNivelEstoque.setEditable(false);
        campoUnidadeEstoque.setEditable(false);
        campoPontoRessuprimento.setEditable(false);
        comboObsoleto.setEnabled(false);
        
        textoErro.setVisible(false);    
    }
    public void manejaMaterial() {
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


		campoID.setVisible(true);
		campoID.setEditable(true);
		campoIDEstatico.setVisible(false);

        campoNome.setEditable(false);
        campoNivelEstoque.setEditable(false);
        campoUnidadeEstoque.setEditable(false);
        campoPontoRessuprimento.setEditable(false);
        comboObsoleto.setEnabled(false);
		
       	campoID.setText("");
		campoIDEstatico.setText("");
        campoNome.setText("");
        campoNivelEstoque.setText("");
        campoUnidadeEstoque.setText("");
        campoPontoRessuprimento.setText("");
        comboObsoleto.setSelectedIndex(0);
    }

}