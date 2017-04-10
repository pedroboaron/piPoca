/**
 * 
 */
package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dados.Filmes;

/**
 * @author pedro
 *
 */
public class FilmesDao {

	static java.sql.Connection con;

	public List<Filmes> executar(String sql) throws SQLException {
		Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
		List<Filmes> lista = new ArrayList<Filmes>();
		try {
			PreparedStatement pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			if (rs != null) {
				while (rs.next()) {
					Filmes filmes = new Filmes();
					lista.add(filmes);
				}
				return lista;
			} else {
				return null;
			}
		} catch (SQLException e) {
			return null;
		} finally {
			if (con != null) {
				Connection.fecharConexao();
			}
		}

	}
	
	}
