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
                    
                    filme.setNome(rs.getString("nome"));
                    filme.setDiretor(rs.getString("diretor"));
                    filme.setCategoria(rs.getString("categoria"));
                    filme.setAno(rs.getShort("ano"));
                    filme.setAtorPrincipal(rs.getString("ator_principal"));
                    filme.setTempoFilme(rs.getShort("tempo_filme"));
                    filme.setOrcamento(rs.getDouble("orcamento"));
                    filme.setFaturamento(rs.getDouble("faturamento"));
                    filme.setFaixaEtaria(rs.getShort("faixa_etaria"));
                    filme.setLegenda(rs.getBoolean("legenda"));
                    filme.setDublado(rs.getBoolean("dublado"));
                    filme.setIdiomaOriginal(rs.getString("idioma_original"));
                    
                    return filme;
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
    
    public int inserir(FilmeBean filme) {
        coneccao = Banco.conectar();
        
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
    
    public boolean excluir(int id) {
        coneccao = Banco.conectar();
        
        if (coneccao != null) {
            String sql = "DELETE FROM filmes WHERE id = ?";
            
            try {
                PreparedStatement ps = coneccao.prepareStatement(sql);
                ps.setInt(1, id);
                
                return ps.executeUpdate() == 1;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                Banco.desconectar();
            }
        }
        return false;
    }
    
    public boolean editar(FilmeBean filme) {
        if (coneccao != null) {
            String sql = "UPDATE filmes SET nome=?, diretor=?, categoria=? ";
                sql += "ano=?, ator_principal=?, tempo_filme=?, orcamento=?, ";
                sql += "faturamento=?, faixa_etaria=?, legenda=?, dublado=?, ";
                sql += "idioma_original=? WHERE id = ?";
                
            try {
                PreparedStatement ps = coneccao.prepareStatement(sql);
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
                
                return ps.executeUpdate() == 1;
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                Banco.desconectar();
            }
        }
        return false;
    }
}
