package service;

import java.util.ArrayList;

import dao.PaisDAO;
import model.Pais;

public class PaisService {

		PaisDAO dao = new PaisDAO();
		
		
		
		 public Pais criar() {
			 return dao.criar();
		 }
		 
		 public Pais excluir() {
			 return dao.excluir();
		 }
		 
		 public Pais atualizar() {
			 return dao.atualizar();
		 }
		 
		 public Pais carregar() {
			 return dao.carregar();
		 }
		 
		 public Pais maiorPopulacao() {
			 return dao.maiorPopulacao();
		 }
		 
		 public Pais menorPopulacao() {
			 return dao.menorPopulacao();
		 }
		 
		 public ArrayList<Pais> vetor(){
			 return dao.vetor();
		 }
		
		
}
