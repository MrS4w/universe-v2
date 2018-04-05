<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.html"%>
<div class="section no-pad-bot" id="index-banner">
  <div class="container">
    <div class="row">
      <h3 class="header center white-text">Inserir buraco negro:</h3>
      <form class="white-text col s4 offset-s4" method="post" action="index?action=BuracoNegro">
        Nome:<input type="text" name="nome" id="nome" required>
        Volume:<input type="number" name="volume" id="volume" min="0" required>
        Posição:<input type="text" name="posicao" id="posicao" required>
        Velocidade/Rotação:<input type="number" name="velocidade" id="velocidade" min="0" required>
        <input type="submit" name="botao" class="blue-grey darken-4 waves-effect waves-light btn" value="Enviar">
      </form>
    </div>
  </div>
</div>
    <br>
      <br>
      <br>
<%@ include file="footer.html"%>