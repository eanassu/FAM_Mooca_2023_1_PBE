import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class TesteInsert {

	public static void main(String[] args) throws SQLException, ParseException {
		Scanner scan = new Scanner( System.in );
		System.out.print("codigo:");
		int codigo = scan.nextInt();
		
		System.out.print("descricao:");
		String descricao = scan.next();
		System.out.print("quantidade:");
		int quantidade = scan.nextInt();
		System.out.print("preco:");
		double preco = scan.nextDouble();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		System.out.print("dataCompra:");
		String dataStr = scan.next();
		
		Date dataCompra = format.parse(dataStr);
		SimpleDateFormat formatIso = new SimpleDateFormat("yyyy-MM-dd");
		Connection connection = DriverManager.getConnection(
				"jdbc:hsqldb:hsql://localhost/", "SA", "");
//		Statement stmt = connection.createStatement();
//		int linhas = stmt.executeUpdate(
//			"INSERT INTO Produtos values("+ codigo + ",'" + 
//		                                    descricao+"',"+
//		                                    quantidade+","+
//		                                    preco+"," +
//		                                    "'"+formatIso.format(dataCompra)+
//		                                    "');drop table teste;");
		PreparedStatement pstmt = connection.prepareStatement(
				"INSERT INTO PRODUTOS VALUES(?,?,?,?,?)");
		pstmt.setInt(1, codigo);
		pstmt.setString(2, descricao);
		pstmt.setInt(3, quantidade);
		pstmt.setDouble(4, preco);
		pstmt.setDate(5, new java.sql.Date(dataCompra.getTime()));
		int linhas = pstmt.executeUpdate();
		
		System.out.println(linhas);

	}

}
