package br.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	String run(HttpServletRequest request, HttpServletResponse response) throws Exception;
}
