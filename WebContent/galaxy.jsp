<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.html"%>

<div class="section no-pad-bot" id="index-banner">
  <div class="container">
    <div class="row">
      <h3 class="header center white-text">Inserir galáxia:</h3>
      <form class="white-text col s4 offset-s4" method="post" action="index?action=Galaxia">
        Nome:<input type="text" id="nome" name="nome" required>
        Posição:<input type="text" id="posicao" name="posicao" required>
        Dimensão:<input type="number" min="0" name="dimen" id="dimen" required>
        Quantidade de sistemas planetários:<input type="number" min="0" id="qtd" name="qtd" required>
        <input type="submit" name="botao" class="blue-grey darken-4 waves-effect waves-light btn" value="Enviar">
      </form>
    </div>
  </div>
</div>
<br><br> <br><br><br>
<%@ include file="footer.html"%>