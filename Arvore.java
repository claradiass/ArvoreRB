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
        No pai = no.getPai();
        if(no.getPai() == null){
            no.setEhVermelho(false);  // Garante que a raiz sempre seja preta
            return;
        }

        if(!no.getPai().ehVermelho){
            return;
        }


        No tio = null;


        if(no.getDado() < pai.getDado()){
            if(pai.getPai().getDireita() != null){
                tio = pai.getPai().getDireita();
                pai.setEhVermelho(false);
                tio.setEhVermelho(false);
            }

        } else if (no.getDado() > pai.getDado()){
            if(pai.getPai().getEsquerda() != null){
                tio = pai.getPai().getEsquerda();
                pai.setEhVermelho(false);
                tio.setEhVermelho(false);
            }
        }






        if(pai.ehVermelho && tio.ehVermelho){
            pai.setEhVermelho(false);
            tio.setEhVermelho(false);
        }




        cor(pai);
    }


    public int alturaPreta(No no){
        if (no.getEsquerda() == null){
            return 1;


        } else if (no.getDireita() == null){
            return 1;
        }


        return alturaPreta(no.getDireita()) - alturaPreta(no.getEsquerda());


    }






    public No getRaiz() {
        return raiz;
    }


    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }


}

