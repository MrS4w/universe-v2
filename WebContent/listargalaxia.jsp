<%@page import="br.model.Galaxias"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.html"%>
<form method="post" action="index?action=BuscarGalaxia">
<div class="black white-text">
          <input id="txtestrela" name="txtgalaxia" type="text" placeholder="Pesquise por nome..." required>
            <button class="btn waves-effect brown darken-4" type="submit" name="action">Procurar
    <i class="material-icons right">send</i>
  </button>
          </div>
          </form>
	<% 
ArrayList<Galaxias> listag =(ArrayList<Galaxias>) request.getSession().getAttribute("listagal");
if(listag==null || listag.isEmpty()){
	out.println("<h1 class='header center white-text'>Não existem galáxias registradas!</h1>");
}else{
%>
<style>
table, td, th {border:solid 1px #000; padding:5px;}
td{width: 10%;}
</style>
<table class='header center white-text'>
<tr class="green darken-4">
<th>Nome</th>
<th>Posição</th>
<th>Dimensão</th>
<th>Quantidade de sistemas planetários</th>
<th>Editar</th>
<th>Excluir</th>
</tr>
<% 
for(int i=0;i<listag.size();i++){
	out.println("<tr>");
	out.println("<td>"+listag.get(i).getNome()+"</td>");
	out.println("<td>"+listag.get(i).getPosicao()+"</td>");
	out.println("<td>"+listag.get(i).getDimensao()+"</td>");
	out.println("<td>"+listag.get(i).getQuantidade()+"</td>");
	
	%>
	<td>
					<form method="post" action="index?action=EditarGalaxia">					
						<button value="<%=listag.get(i).getId() %>" class="button blue darken-4" name="editar"  type="submit"> 
							<i class='blue darken-4 white-text material-icons left'>edit</i>
						</button>
					</form>
				</td>
				<td>
				<form method="post" action="index?action=ExcluirGalaxia">
					<input type="hidden" name="id" value="<%=listag.get(i).getId() %>">
					<button class="button red accent-4" value="<%=listag.get(i).getId() %>" name="deletar" type="submit">
						<i class='button red accent-4 white-text material-icons left'>delete</i>
					</button>
				</form>
			</td>
		</tr>
	<% }
	%>
</table>
<%}%>
 <!-- Footer -->
 <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
  <footer class="ftr page-footer blue-grey darken-4">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Descri&ccedil;&atilde;o:</h5>
          <p class="grey-text text-lighten-4">Projeto acad&ecirc;mico para a disciplina de desenvolvimento de software.</p>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Contatos:</h5>
          <ul>
            <li>
              <a class="white-text" href="https://github.com/SoldumaPraia" target="blank">
                <img src="img/gh.png" width="15px" height="15px">Patrick Brass</a>
            </li>
            <li>
              <a class="white-text" href="https://github.com/MrS4w" target="blank">
                <img src="img/gh.png" width="15px" height="15px">Victor Silva</a>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
        &copy; 2018 - Victor Silva and Patrick Brass
      </div>
    </div>
  </footer>
  
  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="js/materialize.js"></script>
  <script src="js/init.js"></script>

</body>
</html>