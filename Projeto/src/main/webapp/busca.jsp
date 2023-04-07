<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.vemprafam.dao.DaoProduto"%>
<%@page import="br.vemprafam.pojo.Produto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Produto</title>
</head>
<body>
<form>
<%
int codigo = Integer.parseInt(request.getParameter("codigo"));
Produto p = new DaoProduto().buscarPeloCodigo(codigo);
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
código:<input type="text" name="codigo" value="<%=p.getCodigo()%>"/><br/>
descrição:<input type="text" name="descricao" value="<%=p.getDescricao()%>"/><br/>
quantidade:<input type="text" name="quantidade" value="<%=p.getQuantidade()%>"/><br/>
preço:<input type="text" name="preco" value="<%=p.getPreco()%>"/><br/>
data da compra:<input type="text" name="dataCompra" 
                value="<%=dateFormat.format(p.getDataCompra())%>"/><br/>
<input type="submit" value="enviar"/><br/>
</form>
<a href="/Projeto">voltar</a>
</body>
</html>