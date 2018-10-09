package dao;

import entra21.java.bean.FilmeBean;

public class FilmeJUnitTest {
    public void testeInserir() {
        FilmeBean filme = new FilmeBean();
        filme.setNome("O Programador de Programa");
        filme.setDiretor("Isaac Newton");
        filme.setCategoria("Ação, Suspense");
        filme.setAno((short)1992);
        filme.setAtorPrincipal("Rocky Balboa");
        filme.setTempoFilme((short)96);
        filme.setOrcamento(15000);
        filme.setFaturamento(5000);
        filme.setFaixaEtaria((short)18);
        filme.setLegenda(true);
        filme.setDublado(true);
        filme.setIdiomaOriginal("Inglês");
    }
}
