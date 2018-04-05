<%@page import="br.model.BuracosNegros"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.html"%>
<div class="section no-pad-bot" id="index-banner">
	<div class="container">
		<%
			int x = Integer.parseInt(request.getParameter("editar"))-1;
			ArrayList<BuracosNegros> b =(ArrayList<BuracosNegros>) request.getSession().getAttribute("listabn");
			BuracosNegros a=b.get(x);
		%>
		<div class="row">
			<h3 class="header center white-text">Editar buraco negro:</h3>
			<form class="white-text col s4 offset-s4" method="post"
				action="index?action=BNedit">
				<input type="hidden" name="id" value="<%=a.getId()%>">
				Nome:<input type="text" id="nome" value="<%=a.getNome()%>"
					name="nome" required> 
					Volume:
					<input type="text" value="<%=a.getVolume()%>"
					id="volume" name="volume" required> 
					Posição:
					<input type="text" value="<%=a.getPosicao()%>" id="posicao" name="posicao" required> 
					Velocidade/Rotação:
					<input type="text" id="velocidade" name="velocidade" min="0" value="<%=a.getVelocidade()%>" required>
					<input type="submit" name="botao"
					class="blue-grey darken-4 waves-effect waves-light btn"
					value="Enviar">
			</form>
		</div>
	</div>
</div>
<br>
<br>
<br>
<br>
<br>

<%@ include file="footer.html"%>