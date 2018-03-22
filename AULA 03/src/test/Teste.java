package test;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConnectionFactory;
import dao.PaisDAO;
import model.Pais;

public class Teste {
	
	
	
	public static void main(String[] args) throws SQLException {
		
		ConnectionFactory bd = new ConnectionFactory();
		
		Connection conn = bd.obtemConexao();
			
			
			PaisDAO paisDao = new PaisDAO();
			
			ArrayList<Pais> vetorDAO = new ArrayList<Pais>();

						
			Pais pais = new Pais();
			
			pais = paisDao.menorPopulacao();
			
			System.out.println(pais);
			
			pais = paisDao.maiorPopulacao();
			System.out.println(pais);
			
			vetorDAO = paisDao.vetor();
			
			for(PaisDAO vdao:vetorDAO) {
				System.out.println(vdao);
			}
			
		}
	


}
