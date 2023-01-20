import java.sql.*;
import java.util.ArrayList;

public class ControllerEstudante {
	
	public static void adicionarEstudate(int codigo, String nome, double nota1, double nota2) 
		throws SQLException{
		Conexao conexao =  new Conexao();
		Connection db = conexao.conectar();
		
		PreparedStatement query = null;
		query = db.prepareStatement("insert into lista values(?,?,?,?)");
		
		query.setInt(1, codigo);
		query.setString(2, nome);
		query.setDouble(3, nota1);
		query.setDouble(4, nota2);
		query.executeUpdate();
		db.close();
	}
	
	public static ArrayList<Estudante> listarEstudantes ()throws SQLException {
		ArrayList<Estudante> estudantes = new ArrayList<Estudante>();
		Conexao conexao =  new Conexao();
		Connection db = conexao.conectar();
		
		PreparedStatement query = null;
		query = db.prepareStatement("select * from lista");
		ResultSet results = (ResultSet) query.executeQuery();
		while(results.next()) {
			int codigo = results.getInt(1);
			String nome = results.getString(2);
			double nota1  = results.getDouble(3);
			double nota2 = results.getDouble(4);
			
			estudantes.add(new Estudante(codigo, nome, nota1, nota2));
		}
		db.close();
		return estudantes;
	}
	
	public static void apagar(int codigo) throws SQLException {
		Conexao conexao =  new Conexao();
		Connection db = conexao.conectar();
		
		PreparedStatement query = null;
		query = db.prepareStatement("delete from lista where codigo=?");
		query.setInt(1, codigo);
		query.executeUpdate();
		db.close();
		
	}
	
	
	
	
}
