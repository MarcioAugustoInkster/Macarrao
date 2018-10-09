package entra21.java.dao;

import entra21.java.bean.FilmeBean;
import entra21.java.coneccao.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmeDAO {
    private Connection coneccao;
    
    public FilmeBean obterPeloId(int id) {
        coneccao = Banco.conectar();
        
        FilmeBean filme = null;
        
        if (coneccao != null) {
            String sql = "SELECT * FROM filmes WHERE id = ?";
            
            try {
                PreparedStatement ps = coneccao.prepareStatement(sql);
                ps.setInt(1, id);
                
                ResultSet rs = ps.executeQuery();
                
                if (rs.next()) {
                    filme = new FilmeBean();
                    
                    filme.setNome(rs.getString("Nascido para Morrer"));
                    filme.setDiretor(rs.getString("Edward Lowrence"));
                    filme.setCategoria(rs.getString("Ação"));
                    filme.setAno(rs.getShort(1995));
                    filme.setAtorPrincipal(rs.getString("Richard Crow"));
                    filme.setTempoFilme(rs.getShort(180));
                    filme.setOrcamento(rs.getDouble(15000));
                    filme.setFaturamento(rs.getDouble(25000));
                    filme.setFaixaEtaria(rs.getShort(18));
                    filme.setLegenda(true);
                    filme.setDublado(true);
                    filme.setIdiomaOriginal(rs.getString("Inglês"));
                    
                    return filme;
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public int inserir(FilmeBean filme) {
        if (coneccao != null) {
            String sql = "INSERT INTO filmes (nome, diretor, categoria, ano, ";
                sql += "ator_principal, tempo_filme, orcamento, faturamento, ";
                sql += "faixa_etaria, legenda, dublado, idioma_original) ";
                sql += "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
            try {
                PreparedStatement ps = coneccao.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);
                ps.setString(1, filme.getNome());
                ps.setString(2, filme.getDiretor());
                ps.setString(3, filme.getCategoria());
                ps.setShort(4, filme.getAno());
                ps.setString(5, filme.getAtorPrincipal());
                ps.setShort(6, filme.getTempoFilme());
                ps.setDouble(7, filme.getOrcamento());
                ps.setDouble(8, filme.getFaturamento());
                ps.setShort(9, filme.getFaixaEtaria());
                ps.setBoolean(10, filme.isLegenda());
                ps.setBoolean(11, filme.isDublado());
                ps.setString(12, filme.getIdiomaOriginal());
                ps.setInt(13, filme.getId());
                
                ResultSet rs = ps.getGeneratedKeys();
                
                if (rs.next()) {
                    return rs.getInt(1);
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                Banco.desconectar();
            }
        }
        return -1;
    }
    
    public boolean excluir() {
        
        
        return false;
    }
    
    public boolean editar() {
        if (coneccao != null) {
            
        }
        
        return false;
    }
}
