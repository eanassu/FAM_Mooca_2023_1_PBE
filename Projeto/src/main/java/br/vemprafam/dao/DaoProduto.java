package br.vemprafam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.vemprafam.pojo.Produto;

public class DaoProduto {

	private Connection connection;
	private String url = "jdbc:hsqldb:hsql://localhost/";
	private String user = "SA";
	private String password = "";
	
	public DaoProduto() {
		if ( connection == null ) {
			try {
				connection = DriverManager.getConnection(url,user,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}
	}
	
	public void inserir( Produto produto ) {
		String sql = "INSERT INTO PRODUTOS VALUES(?,?,?,?,?)";
		try {
			PreparedStatement pstmt = connection.prepareStatement(sql);
			pstmt.setInt(1, produto.getCodigo());
			pstmt.setString(2, produto.getDescricao());
			pstmt.setInt(3, produto.getQuantidade());
			pstmt.setDouble(4, produto.getPreco());
			pstmt.setDate(5, 
					new java.sql.Date(produto.getDataCompra().getTime()));
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public List<Produto> getLista() {
		List<Produto> lista = new ArrayList<>();
		try {
			PreparedStatement pstmt = connection.prepareStatement(
					"SELECT * FROM PRODUTOS");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				lista.add(new Produto(rs.getInt(1),
						              rs.getString(2),
						              rs.getInt(3),
						              rs.getDouble(4),
						              rs.getDate(5)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return lista;
	}
	
	public static void main(String[] args) {
		DaoProduto dao = new DaoProduto();
		//Produto produto = new Produto(100,"teste100",100,100,new Date());
		//dao.inserir(produto);
		System.out.println(dao.getLista());
	}
}
