public class Arvore {
    No raiz;


    public Arvore() {
        this.raiz = null;
    }


    public void inserir(int dado){
        No newNo = new No(dado);
        if(raiz == null){
            raiz = newNo;
            raiz.setEhVermelho(false);
        } else {
            int primeiro = raiz.getDado(); // pe a raiz como primeiro
            No descida = raiz; // e a descida -> que vai me orientar a pegar o próximo número ou setar o pai


            while (descida != null) {
                if(primeiro > dado){
                    if(descida.getEsquerda() != null){ // se o dado é diferente de null significa que ainda tem número para baixo
                        descida = descida.getEsquerda(); // pega o proximo número e coloca ele como a nova descida
                        primeiro = descida.getDado(); // pega o seu dado
                    } else {

                        newNo.setPai(descida); // a descida será o nó anterior ao novo, sendo a descida seu pai
                        descida.setEsquerda(newNo);
                        descida = null;
                    }
                } else {
                    if(descida.getDireita() != null){
                        descida = descida.getDireita();
                        primeiro = descida.getDado();
                    } else {
                        newNo.setPai(descida);
                        descida.setDireita(newNo);


                        descida = null;
                    }
                }
            }
        }
        cor(newNo);
    }


    public void cor(No no){
        while(no.getPai() != null && no.getPai().ehVermelho){ // enquanto o pai não for a raiz e ele estiver vermelho

            if(no.getPai().getPai() != null && no.getPai() == no.getPai().getPai().getEsquerda()){ // se o avô não for nulo e se o pai for o filho a esquerda do avô, significa que o tio do nó está a direita
                No tio = no.getPai().getPai().getDireita(); // o tio está à direita do avô
                if (tio != null && tio.ehVermelho) { // Caso 1: o tio é difenrente de null e é vermelho
                    no.getPai().setEhVermelho(false); // pai fica preto
                    tio.setEhVermelho(false); // tio fica preto
                    no.getPai().getPai().setEhVermelho(true); // avô fica vermelho
                    no = no.getPai().getPai(); // sobe o problema para o avô
                } else { // tio preto ou nulo
                    rotacionar(no);




                }
            } else {
                No tio = no.getPai().getPai().getEsquerda();
                if (tio != null && tio.ehVermelho) { // Caso 1: o tio é difenrente de null e é vermelho
                    no.getPai().setEhVermelho(false); // pai fica preto
                    tio.setEhVermelho(false); // tio fica preto
                    no.getPai().getPai().setEhVermelho(true); // avô fica vermelho
                    no = no.getPai().getPai(); // sobe o problema para o avô
                } else { // tio preto ou nulo
                    if(no == no.getPai().getDireita()) { // no filho a direita
                        rotacaoDireita(no.getPai());
                    }
                    // no é flho a esquerda
                    no.getPai().setEhVermelho(false); // pai fica preto
                    no.getPai().getPai().setEhVermelho(true); // avô fica vermelho
                    rotacaoEsquerda(no.getPai().getPai()); // rotação a direita do avô
                }
            }
        }
        raiz.setEhVermelho(false);



    }

    public void rotacionar(No no){
        if(no == no.getPai().getDireita()) { // no filho a direita
            rotacaoEsquerda(no.getPai());


        } else if(no == no.getPai().getEsquerda()) {
            // no é flho a esquerda
            no.getPai().setEhVermelho(false); // pai fica preto
            no.getPai().getPai().setEhVermelho(true); // avô fica vermelho
            rotacaoDireita(no.getPai().getPai()); // rotação a direita do avô
        } // Se o nó está na subárvore direita e o pai está na subárvore esquerda
        else if (no == no.getPai().getDireita() && no.getPai() == no.getPai().getPai().getEsquerda()) {
            // Primeira rotação à esquerda no pai
            rotacaoEsquerda(no.getPai());
            // Depois, rotação à direita no avô
            rotacaoDireita(no.getPai().getPai());
        }
// Se o nó está na subárvore esquerda e o pai está na subárvore direita
        else if (no == no.getPai().getEsquerda() && no.getPai() == no.getPai().getPai().getDireita()) {
            // Primeira rotação à direita no pai
            rotacaoDireita(no.getPai());
            // Depois, rotação à esquerda no avô
            rotacaoEsquerda(no.getPai().getPai());
        }








//    } else if(no == no.getPai().getDireita() && no.getPai().getPai().getEsquerda() == no.getPai()){
//        rotacaoEsquerda(no.getPai());
//        rotacaoDireita(no.getPai().getPai());
//    } else if(no == no.getPai().getEsquerda() && no.getPai().getPai().getDireita() == no.getPai()){
//        rotacaoDireita(no.getPai());
//        rotacaoEsquerda(no.getPai().getPai());
//    }

    }








    public void rotacaoDireita(No avo){

        if(avo.getEsquerda() == null) {
            return; // Não há nada para rotacionar
        }

        avo.getEsquerda().setPai(avo.getPai());
        if(avo.getPai() != null){
            avo.getPai().setEsquerda(avo.getEsquerda());
        } else {
            raiz = avo.getEsquerda();
        }
        avo.setPai(avo.getEsquerda());
        avo.setEsquerda( avo.getEsquerda().getDireita());

        if(avo.getEsquerda() != null){
            avo.getEsquerda().setPai(avo);
        }
        avo.getPai().setDireita(avo);
    }

    public void rotacaoEsquerda(No avo){
        if(avo.getDireita() == null) {
            return; // Não há nada para rotacionar
        }
        avo.getDireita().setPai(avo.getPai());
        if(avo.getPai() != null){
            avo.getPai().setDireita(avo.getDireita());
        } else {
            raiz = avo.getDireita();
        }
        avo.setPai(avo.getDireita());
        avo.setDireita( avo.getDireita().getEsquerda());

        if(avo.getDireita() != null){
            avo.getDireita().setPai(avo);
        }
        avo.getPai().setEsquerda(avo);
    }









    public No getRaiz() {
        return raiz;
    }


    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }


}

