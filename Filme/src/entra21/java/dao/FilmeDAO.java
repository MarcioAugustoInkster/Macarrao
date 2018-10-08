package entra21.java.dao;

import entra21.java.bean.FilmeBean;
import entra21.java.coneccao.Banco;
import java.sql.Connection;

public class FilmeDAO {
    private Connection coneccao;
    
    public FilmeBean obterPeloId(int id) {
        coneccao = Banco.conectar();
        
        FilmeBean filme = new FilmeBean();
        
        if (coneccao != null)
        
        return null;
    }
    
    public int inserir() {
        
        
        return -1;
    }
    
    public boolean excluir() {
        
        
        return false;
    }
    
    public boolean editar() {
        
        
        return false;
    }
}
