package persistencia;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.sun.rowset.CachedRowSetImpl;

public class Connection {
	static java.sql.Connection con;

	public static Connection abrirConexao() {
		String driver = "org.postgresql.Driver";
		String user = "postgres";
		String senha = "Xbox2014";
		String url = "jdbc:postgresql://127.0.0.1:5432/rh";// Coloque o
															// //servidor onde
															// est� instalado o
															// banco
		Connection con = null;
		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, senha);
			System.out.println("Conexao realizada com sucesso.");
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print(e.getMessage());
		}
		return con;
	}

	public static void fecharConexao() {
		try {
			con.close();
		} catch (Exception e) {

		}
	}

}
