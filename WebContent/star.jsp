<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="header.html"%>
<div class="section no-pad-bot" id="index-banner">
  <div class="container">
    <div class="row">
      <h3 class="header center white-text">Inserir estrela:</h3>
      <form class="white-text col s4 offset-s4" method="post" action="index?action=Estrela">
        Nome:<input type="text" id="nome" name="nome" required>
        Volume:<input type="number" id="volume" name="volume" min="0" required>
        Posição:<input type="text" id="posicao" name="posicao" required>
        <input type="radio" name="" value="a">    
        Está visível?<input name="group1" value="1" type="radio" id="test1"/>
        <label class="white-text with-gap" for="test1">Sim</label>
        <input name="group1" type="radio" value="0" id="test2" checked/>
        <label class="white-text with-gap" for="test2">Não</label><br><br>
        <input type="submit" name="botao" class="blue-grey darken-4 waves-effect waves-light btn" value="Enviar">
      </form>
    </div>
  </div>
</div>
<br><br> <br><br><br>

<%@ include file="footer.html"%>