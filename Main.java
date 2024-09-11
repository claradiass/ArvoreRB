public class Main {
    public static void main(String[] args) {
        Arvore a = new Arvore();

        a.inserir(50);
        a.inserir(40);
        a.inserir(60);
        a.inserir(30);
        a.inserir(45);
        a.inserir(29);
//        a.inserir(23);

        System.out.println(a.raiz.getDado());
        System.out.println(a.raiz.ehVermelho);
        System.out.println(a.raiz.getEsquerda().getDado());
        System.out.println(a.raiz.getEsquerda().ehVermelho);
        System.out.println(a.raiz.getDireita().getDado());
        System.out.println(a.raiz.getDireita().ehVermelho);
        System.out.println(a.raiz.getEsquerda().getEsquerda().getDado());
        System.out.println(a.raiz.getEsquerda().getEsquerda().ehVermelho);
        System.out.println(a.raiz.getEsquerda().getDireita().getDado());
        System.out.println(a.raiz.getEsquerda().getDireita().ehVermelho);
        System.out.println(a.raiz.getEsquerda().getEsquerda().getEsquerda().getDado());
        System.out.println(a.raiz.getEsquerda().getEsquerda().getEsquerda().ehVermelho);
        System.out.println(a.raiz.getEsquerda().getEsquerda().getEsquerda().getEsquerda().getDado());
        System.out.println(a.raiz.getEsquerda().getEsquerda().getEsquerda().getEsquerda().ehVermelho);
    }
}
