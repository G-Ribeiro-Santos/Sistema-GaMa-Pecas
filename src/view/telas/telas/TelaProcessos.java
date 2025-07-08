package controle.telas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import models.Processos;
import models.Maquinas;

public class TelaProcessos {
    private JFrame janela = new JFrame("Processos");
    private Font fonte = new Font("Arial", Font.BOLD, 24);
    private Font fonte2 = new Font("Arial", Font.BOLD, 16);

    private JLabel titulo = new JLabel("Processos");

    private JLabel textoID = new JLabel("ID:");
    private JLabel textoNome = new JLabel("Nome do Processo:");
    private JLabel textoIDMaquina = new JLabel("ID Máquina:");
    private JLabel textoErro = new JLabel("Não foi possível localizar o processo");

    private JTextField campoID = new JTextField();
    private JLabel campoIDEstatico = new JLabel("");
    private JTextArea campoNome = new JTextArea();
    private JTextArea campoIDMaquina = new JTextArea();
    private JTextArea campoNomeMaquina = new JTextArea();


    private JButton botaoCriar = new JButton("Criar");
    private JButton botaoEditar = new JButton("Editar");
    private JButton botaoDeletar = new JButton("Deletar");
    private JButton botaoPesquisar = new JButton("Pesquisar");
    private JButton botaoSalvar = new JButton("Salvar");
    private JButton botaoCancelar = new JButton("Cancelar");
    private JButton botaoLimpar = new JButton("Limpar");

    private int IDDigitado;

    public TelaProcessos() {
        this.janela.setBounds(200, 200, 600, 450);
        this.janela.setLayout(null);
        this.janela.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.janela.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.titulo.setFont(fonte);
        this.titulo.setBounds(200, 20, 400, 30);

        this.textoID.setBounds(200, 60, 150, 25);
        this.textoID.setFont(fonte2);

        this.textoNome.setBounds(70, 100, 200, 25);
        this.textoNome.setFont(fonte2);

        this.textoIDMaquina.setBounds(130, 140, 200, 25);
        this.textoIDMaquina.setFont(fonte2);

        this.textoErro.setBounds(175, 320, 250, 25);

        this.campoID.setBounds(230, 60, 300, 25);
        this.campoIDEstatico.setBounds(230, 60, 300, 25);

        this.campoNome.setBounds(230, 100, 300, 25);
        this.campoNome.setLineWrap(true);
        this.campoNome.setEditable(false);

        this.campoIDMaquina.setBounds(230, 140, 50, 25);
        this.campoIDMaquina.setLineWrap(true);
        this.campoIDMaquina.setEditable(false);
        
        this.campoNomeMaquina.setBounds(290, 140, 100, 25);
        
        this.botaoCriar.setBounds(310, 280, 100, 40);
        this.botaoPesquisar.setBounds(200, 280, 100, 40);
        this.botaoDeletar.setBounds(140, 280, 100, 40);
        this.botaoEditar.setBounds(360, 280, 100, 40);
        this.botaoLimpar.setBounds(250, 280, 100, 40);
        this.botaoCancelar.setBounds(310, 280, 100, 40);
        this.botaoSalvar.setBounds(200, 280, 100, 40);

        this.janela.add(titulo);
        this.janela.add(textoID);
        this.janela.add(textoNome);
        this.janela.add(textoIDMaquina);
        this.janela.add(textoErro);
        this.janela.add(campoNomeMaquina);
        
        this.janela.add(campoID);
        this.janela.add(campoIDEstatico);
        this.janela.add(campoIDMaquina);
        this.janela.add(campoNome);
        

        this.janela.add(botaoCriar);
        this.janela.add(botaoPesquisar);
        this.janela.add(botaoEditar);
        this.janela.add(botaoLimpar);
        this.janela.add(botaoDeletar);
        this.janela.add(botaoCancelar);
        this.janela.add(botaoSalvar);

        this.janela.setVisible(true);
        this.campoIDEstatico.setVisible(false);
        this.textoErro.setVisible(false);

        this.botaoCriar.setVisible(true);
        this.botaoPesquisar.setVisible(true);
        this.botaoEditar.setVisible(false);
        this.botaoLimpar.setVisible(false);
        this.botaoDeletar.setVisible(false);
        this.botaoSalvar.setVisible(false);
        this.botaoCancelar.setVisible(false);

        this.campoID.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
                if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || (ke.getKeyChar() == KeyEvent.VK_BACK_SPACE)) {
                    campoID.setEditable(true);
                } else {
                    campoID.setEditable(false);
                }
            }
        });

        this.botaoCriar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejaProcesso();
            }
        });

        this.botaoEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                manejaProcesso();
            }
        });

        this.botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (campoID.getText().equals("") || campoIDEstatico.getText().equals("")) {
                    telaLimpa();
                } else {
                    exibeProcesso();
                    Processos processoNaTela = new Processos();
                    IDDigitado = Integer.parseInt(campoIDEstatico.getText());
                    processoNaTela.setIdProcesso(IDDigitado);
                    processoNaTela.buscaProcesso();
                    campoNome.setText(processoNaTela.getNomeProcesso());
                    campoIDMaquina.setText(processoNaTela.getIdMaquina() + "");
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
                if (campoID.getText().equals("")) {
                    textoErro.setVisible(true);
                    return;
                } else {
                    textoErro.setVisible(false);
                }
                Processos processoNaTela = new Processos();
                Maquinas maquinaPesquisada = new Maquinas();

                IDDigitado = Integer.parseInt(campoID.getText());
                processoNaTela.setIdProcesso(IDDigitado);
                processoNaTela.buscaProcesso();
                if (processoNaTela.getNomeProcesso() != null && !processoNaTela.getNomeProcesso().equals("")) {
                    exibeProcesso();
                    campoIDEstatico.setText(processoNaTela.getIdProcesso() + "");
                    campoNome.setText(processoNaTela.getNomeProcesso());
                    campoIDMaquina.setText(processoNaTela.getIdMaquina() + "");
                    maquinaPesquisada.setIdMaquina(processoNaTela.getIdMaquina());
                    maquinaPesquisada.buscaMaquina();
                    campoNomeMaquina.setText(maquinaPesquisada.getNomeMaquina());
                } else {
                    textoErro.setVisible(true);
                }
            }
        });

        this.botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Processos processoNaTela = new Processos();
                Maquinas maquinaPesquisada = new Maquinas();
                
                processoNaTela.setNomeProcesso(campoNome.getText());
                processoNaTela.setIdMaquina(Integer.parseInt(campoIDMaquina.getText()));

                if (campoID.getText().equals("")) {
                    processoNaTela.salvaProcesso();
                } else {
                    processoNaTela.setIdProcesso(Integer.parseInt(campoID.getText()));
                    processoNaTela.editaProcesso();
                }
                campoIDEstatico.setText(processoNaTela.getIdProcesso() + "");
                campoID.setText(processoNaTela.getIdProcesso()+ "");
                campoNome.setText(processoNaTela.getNomeProcesso());
                campoIDMaquina.setText(processoNaTela.getIdMaquina() + "");
                maquinaPesquisada.setIdMaquina(processoNaTela.getIdMaquina());
                maquinaPesquisada.buscaMaquina();
                campoNomeMaquina.setText(maquinaPesquisada.getNomeMaquina());
                exibeProcesso();
            }
        });

        this.botaoDeletar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Processos processoNaTela = new Processos();
                processoNaTela.setIdProcesso(Integer.parseInt(campoID.getText()));
                processoNaTela.deletaProcesso();
                telaLimpa();
            }
        });
    }

    public void exibeProcesso() {
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
        campoIDMaquina.setEditable(false);
    }

    public void manejaProcesso() {
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

        campoNome.setEditable(true);
        campoIDMaquina.setEditable(true);
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

        campoNome.setEditable(false);
        campoIDMaquina.setEditable(false);

        campoNomeMaquina.setEditable(false);
        
        campoID.setText("");
        campoIDEstatico.setText("");
        campoNome.setText("");
        campoIDMaquina.setText("");
        campoNomeMaquina.setText("");
        
        textoErro.setVisible(false);
    }
}
