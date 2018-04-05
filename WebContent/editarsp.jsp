<%@page import="br.model.SistemasPlanetarios"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.html"%>
<div class="section no-pad-bot" id="index-banner">
  <div class="container">
  <%
	int x = Integer.parseInt(request.getParameter("editar"))-1;
  	ArrayList<SistemasPlanetarios> s=(ArrayList<SistemasPlanetarios>) request.getSession().getAttribute("listasp");
  	SistemasPlanetarios a = s.get(x);
  %>
    <div class="row">
      <h3 class="header center white-text">Editar sistema planetário:</h3>
      <form class="white-text col s4 offset-s4" method="post" action="index?action=SPedit">
       <input type="hidden" name="id" value="<%=a.getId()%>">
        Nome:<input type="text" id="nome" value="<%=a.getNome() %>" name="nome" required>
        Posição:<input type="text" id="posicao" value="<%=a.getPosicao() %>" name="posicao" required>
        Dimensão:<input type="text" min="0" name="dimen" id="dimen" value="<%=a.getDimensao() %>" required>
        Constelação:<input type="text" value="<%=a.getConstelacao() %>" name="const" id="const" required>
        <input type="submit" name="botao" class="blue-grey darken-4 waves-effect waves-light btn" value="Enviar">
      </form>
    </div>
  </div>
</div>
<br><br> <br><br><br>
<%@ include file="footer.html"%>