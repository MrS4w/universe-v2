<%@page import="br.model.Galaxias"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.html"%>

<div class="section no-pad-bot" id="index-banner">
  <div class="container">
  <%
  	int x = Integer.parseInt(request.getParameter("editar"))-1;
  	ArrayList<Galaxias> g=(ArrayList<Galaxias>) request.getSession().getAttribute("listagal");
  	Galaxias a=g.get(x);
  %>
    <div class="row">
      <h3 class="header center white-text">Editar galáxia:</h3>
      <form class="white-text col s4 offset-s4" method="post" action="index?action=GalaxiaEdit">
      <input type="hidden" name="id" value="<%=a.getId()%>">
        Nome:<input type="text" id="nome" value="<%=a.getNome() %>" name="nome" required>
        Posição:<input type="text" id="posicao" value="<%=a.getPosicao() %>" name="posicao" required>
        Dimensão:<input type="text" min="0" name="dimen" id="dimen" value="<%=a.getDimensao() %>" required>
        Quantidade de sistemas planetários:<input type="text" value="<%=a.getQuantidade() %>" min="0" id="qtd" name="qtd" required>
        <input type="submit" name="botao" class="blue-grey darken-4 waves-effect waves-light btn" value="Enviar">
      </form>
    </div>
  </div>
</div>
<br><br> <br><br><br>
<%@ include file="footer.html"%>