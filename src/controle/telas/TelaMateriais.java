package controle.telas;

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
import java.sql.ResultSet;
import java.sql.SQLException;

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
    private JTextField campoNome = new JTextField();
    private JTextField campoUnidadeEstoque = new JTextField();
    private JTextField campoNivelEstoque = new JTextField();
    private JTextField campoPontoRessuprimento = new JTextField();
    private JComboBox<String> comboObsoleto = new JComboBox<>(new String[] {
        "...", "DESATIVADO", "OK"
    });
    private JLabel titulo = new JLabel("Materiais");

    //botoes
    private JButton botaoCriar= new JButton("Criar");
    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoDeletar = new JButton("Deletar");
    private JButton botaoPesquisar = new JButton("Pesquisar");
    private JButton botaoSalvar = new JButton("Salvar");
    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoLimpar = new JButton("Limpar");

    //sql
	private DBQuery tabela = new DBQuery("Materials", "id_Material,nome_Material,Especificacoes_tecnicas,Documentacao_Obsoleto", "id_Material");
	private String pesquisa = "SELECT * FROM Materials";
	private int IDMaterialDigitado;

    public TelaMateriais() {

        this.janela.setBounds(200, 200, 600, 370);
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

        this.botaoCriar.setVisible(true);
        this.botaoPesquisar.setVisible(true);

        this.botaoEditar.setVisible(false);
        this.botaoLimpar.setVisible(false);
        this.botaoDeletar.setVisible(false);
        
        this.botaoCancelar.setVisible(false);
        this.botaoSalvar.setVisible(false);
        
        this.textoErro.setVisible(false);
		this.botaoCriar.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				botaoCriar.setVisible(false);
				botaoPesquisar.setVisible(false);
				textoIDMaterial.setVisible(false);
				campoID.setVisible(false);
				botaoSalvar.setVisible(true);
				botaoCancelar.setVisible(true);
		        campoNome.setEditable(true);
			}
		});

		this.botaoEditar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				botaoLimpar.setVisible(false);
				botaoEditar.setVisible(false);
				textoIDMaterial.setVisible(false);
				campoID.setEditable(false);
				botaoSalvar.setVisible(true);
				botaoCancelar.setVisible(true);
		        campoNome.setEditable(true);
		        
			}
		});
		
		this.botaoCancelar.addActionListener(new ActionListener() {
			@Override					
			public void actionPerformed(ActionEvent e) {
				botaoCriar.setVisible(true);
				botaoPesquisar.setVisible(true);
				textoIDMaterial.setVisible(true);
				campoID.setVisible(true);
				botaoSalvar.setVisible(false);
				botaoCancelar.setVisible(false);
				campoNome.setEditable(false);
		        if(campoID.getText() == "") {
		        campoNome.setText("");
		        }else {
		        	
		        }
			}
		});
		this.campoID.addKeyListener(new KeyAdapter() {
			public  void keyPressed(KeyEvent ke) {
				String valorTotal = campoID.getText();
				if((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') ||  (ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
					campoID.setEditable(true);
				}else {
					campoID.setEditable(false);
				}
			}
		});
		
		this.botaoPesquisar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	            ResultSet rs = tabela.query(pesquisa);
				if(campoID.getText().equals("")) {
					System.out.print("erro aqio óia");
					textoErro.setVisible(true);
					return;
				}else {
					textoErro.setVisible(false);
				}
	            IDMaterialDigitado = (int) Double.parseDouble(campoID.getText());
	            try {
					while (rs.next()) {
						if (rs.getInt("id_Material") == IDMaterialDigitado){
					        campoID.setEditable(false);
							botaoCriar.setVisible(false);
							botaoPesquisar.setVisible(false);
							botaoEditar.setVisible(true);
							botaoLimpar.setVisible(true);
							campoNome.setText(rs.getString("nome_Material"));
							switch (rs.getString("Documentacao_Obsoleto")){
							case "COMPLETO":
								comboObsoleto.setSelectedIndex(1);
								break;
							case "INCOMPLETO":
								comboObsoleto.setSelectedIndex(2);
								break;
							case "PENDENTE":
								comboObsoleto.setSelectedIndex(3);
								break;
							default:
								comboObsoleto.setSelectedIndex(0);
								break;
							}
						}
					}

				} catch (SQLException e1) {
		            e1.printStackTrace();
				}		        
			}
		});

    }
}