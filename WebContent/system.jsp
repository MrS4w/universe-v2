<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.html"%>
<div class="section no-pad-bot" id="index-banner">
  <div class="container">
    <div class="row">
      <h3 class="header center white-text">Inserir sistema planetário:</h3>
      <form class="white-text col s4 offset-s4" method="post" action="index?action=Sistema">
        Nome:<input type="text" name="nome" id="nome" required>
        Posição:<input type="text" name="posicao" id="posicao" required>
        Dimensão:<input type="number" min="0" name="dimen" id="dimen" required>
        Constelação:<input type="text" name="const" id="const" required>
        <input type="submit" name="botao" class="blue-grey darken-4 waves-effect waves-light btn" value="Enviar">
      </form>
    </div>
  </div>
</div>
<br><br> <br><br><br>
<%@ include file="footer.html"%>