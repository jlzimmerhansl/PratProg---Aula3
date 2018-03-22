package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Pais;

public class PaisDAO {
	
	
	public Pais criar()  {
	
		String sqlInsert = "INSERT INTO pais(nome, populacao, area) VALUES (?, ?, ?)";
		
		try (Connection conn = ConnectionFactory.obtemConexao()) {
			
			PreparedStatement stm = conn.prepareStatement(sqlInsert);
			
			ResultSet rs = stm.executeQuery();	
			Pais pais = new Pais();

		
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;

	}
	
	public Pais excluir() {
		
		String sqlDelete = "DELETE FROM pais WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao()) {
			
			PreparedStatement stm = conn.prepareStatement(sqlDelete);
			
			ResultSet rs = stm.executeQuery();
			
			Pais pais = new Pais();

			
			pais.setId(rs.getInt("id"));
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
				
	}
	
	public Pais atualizar() {
		
		String sqlUpdate = "UPDATE pais SET nome =?, populacao = ?, area = ? WHERE id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao())  {
			
		
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);
			
			ResultSet rs = stm.executeQuery();
			
			Pais pais = new Pais();

			
			pais.setNome(rs.getString("nome"));
			pais.setPopulacao(rs.getLong("populacao"));
			pais.setArea(rs.getDouble("area"));
			pais.setId(rs.getInt("id"));
			
			stm.executeQuery();
			
		
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Pais carregar() {
		
		String sqlSelect = "SELECT * FROM pais";
		
		try (Connection conn = ConnectionFactory.obtemConexao()){
			
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			ResultSet rs = stm.executeQuery();
			
			Pais pais = new Pais();

			
			if(rs.next()) {
				
				pais.setId(rs.getInt("id"));
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
				
			}
			
			return pais;
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Pais maiorPopulacao() {
		
		String sqlSelect = " SELECT * FROM pais WHERE populacao IN (SELECT MAX(populacao) FROM pais)";
		
		try (Connection conn = ConnectionFactory.obtemConexao()){
			
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			ResultSet rs = stm.executeQuery();
			
			Pais pais = new Pais();
			
			if(rs.next()) {
				
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
			}
			
			return pais;
			
		} catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		return null;
		
	}
	
	public Pais menorPopulacao() {
		
		String sqlSelect = "SELECT * FROM pais WHERE area IN (SELECT MIN(area) FROM pais)";
		
		try (Connection conn = ConnectionFactory.obtemConexao()){
			
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			ResultSet rs = stm.executeQuery();
			
			Pais pais = new Pais();
			
			if(rs.next()) {				
				
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
			}
			
			return pais;
			
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
	}
	
	//vetor
	public ArrayList<Pais>  vetor (){
		String sqlSelect = "SELECT * FROM pais LIMIT 3";
		
		try (Connection conn = ConnectionFactory.obtemConexao()){
			
			PreparedStatement stm = conn.prepareStatement(sqlSelect);
			
			ResultSet rs = stm.executeQuery();
			
			Pais pais = new Pais();

			
			ArrayList <Pais> vetor = new ArrayList<Pais>();
			
			while(rs.next()) {
				
				
				pais.setNome(rs.getString("nome"));
				pais.setPopulacao(rs.getLong("populacao"));
				pais.setArea(rs.getDouble("area"));
				
				vetor.add(pais);
			}
			
			return vetor;
		}catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}

}
