public class No {
    int dado;
    No direita;
    No esquerda;
    boolean ehVermelho;
    No pai;

    public No(int dado) {
        this.dado = dado;
        this.direita = null;
        this.esquerda = null;
        this.ehVermelho = true;
        this.pai = null;
    }

    public int getDado() {
        return dado;
    }

    public void setDado(int dado) {
        this.dado = dado;
    }

    public No getDireita() {
        return direita;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }

    public boolean isEhVermelho() {
        return ehVermelho;
    }

    public void setEhVermelho(boolean ehVermelho) {
        this.ehVermelho = ehVermelho;
    }

    public No getPai() {
        return pai;
    }

    public void setPai(No pai) {
        this.pai = pai;
    }

}
