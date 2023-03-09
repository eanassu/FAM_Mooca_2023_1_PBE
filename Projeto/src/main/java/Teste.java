import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

import br.vemprafam.pojo.Produto;

public class Teste {

	public static void main(String[] args) throws SQLException {
//		Connection connection = DriverManager.getConnection(
//				"jdbc:hsqldb:hsql://localhost/", "SA", "");
//		Statement stmt = connection.createStatement();
//		ResultSet rs = stmt.executeQuery("SELECT * FROM Produtos");
//		while( rs.next() ) {
//			int codigo = rs.getInt("codigo");
//			String descricao = rs.getString(2);
//			int quantidade = rs.getInt("quantidade");
//			double preco = rs.getDouble("preco");
//			Date dataCompra = rs.getDate(5);
//			System.out.println( codigo + " " +
//							    descricao + " " +
//								quantidade + " " + 
//							    preco + " " +
//								dataCompra );
//		}
//		connection.close();
		Produto produto = new Produto();
		System.out.println(produto);
	}

}
