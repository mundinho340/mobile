import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class ViewEstudante extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtNota1;
	private JTextField txtNota2;
	private JTable table;
	JButton addStudent,btnDeletar,btnLimpar,btnListar;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEstudante frame = new ViewEstudante();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewEstudante() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(235, 11, 189, 240);
		contentPane.add(panel);
		panel.setLayout(null);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(76, 38, 86, 20);
		panel.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Codigo");
		lblNewLabel.setBounds(76, 13, 46, 14);
		panel.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setBounds(76, 94, 86, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtNota1 = new JTextField();
		txtNota1.setColumns(10);
		txtNota1.setBounds(76, 146, 86, 20);
		panel.add(txtNota1);
		
		txtNota2 = new JTextField();
		txtNota2.setColumns(10);
		txtNota2.setBounds(76, 197, 86, 20);
		panel.add(txtNota2);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(76, 69, 46, 14);
		panel.add(lblNome);
		
		JLabel lblNota = new JLabel("NOTA 1");
		lblNota.setBounds(76, 121, 46, 14);
		panel.add(lblNota);
		
		JLabel lblNota_1 = new JLabel("NOTA 2");
		lblNota_1.setBounds(76, 172, 46, 14);
		panel.add(lblNota_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 303, 414, 77);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		addStudent = new JButton("Adicionar");
		addStudent.setBounds(10, 11, 89, 23);
		panel_1.add(addStudent);
		addStudent.addActionListener(this);
		
		 btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(109, 11, 89, 23);
		panel_1.add(btnDeletar);
		btnDeletar.addActionListener(this);
		
		 btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(325, 11, 89, 23);
		panel_1.add(btnLimpar);
		btnLimpar.addActionListener(this);
		
		 btnListar = new JButton("Listar");
		btnListar.setBounds(226, 11, 89, 23);
		panel_1.add(btnListar);
		btnListar.addActionListener(this);
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 11, 226, 240);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {
				"Codigo", "Nome", "Nota 1", "Nota 2"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, Double.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(1).setPreferredWidth(164);
		table.getColumnModel().getColumn(2).setPreferredWidth(88);
		table.getColumnModel().getColumn(3).setPreferredWidth(113);
		table.setBounds(0, 0, 226, 240);
		panel_2.add(table);
	}
	public void adicionarNovoEstudante (){
		int codigo = Integer.parseInt(txtCodigo.getText());
		String nome = txtNome.getText();
		double nota1 = Double.parseDouble(txtNota1.getText());
		double nota2 = Double.parseDouble(txtNota2.getText());		
		try {
			Estudante estudante = new Estudante(codigo, nome, nota1, nota2);
			ControllerEstudante.adicionarEstudate(codigo, nome, nota1, nota2);
			listarEstudantes();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
	}
	public void limparTabela (){
		while(table.getRowCount() > 0){
			((DefaultTableModel) table.getModel()).removeRow(0);
		}
	}
	public void listarEstudantes (){
		limparTabela();
		DefaultTableModel  listar = (DefaultTableModel) table.getModel();
		try {
			ArrayList<Estudante> estudantes = ControllerEstudante.listarEstudantes();
			for (Estudante estudante : estudantes) {
				listar.addRow(new Object[]{
						estudante.getCodigo(),
						estudante.getNome(),
						estudante.getNota1(),
						estudante.getNota2()
				});
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		if(event.getSource() == addStudent){
			adicionarNovoEstudante();
		}
		if(event.getSource() == btnListar){
			listarEstudantes();
		}
	}
}
