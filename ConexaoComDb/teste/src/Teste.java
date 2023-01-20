import java.sql.*;

public class Teste {

	public static void main(String[] args) {
		Conexao db = new Conexao();
		Connection cone = db.conectar();
		System.out.println(cone);
	}

}
