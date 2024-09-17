public class Main {
    public static void main(String[] args) {
        Arvore a = new Arvore();

        a.inserir(50);
        a.inserir(40);
        a.inserir(60);
        a.inserir(30);
        a.inserir(29);
        a.inserir(23);
        a.inserir(65);
        a.inserir(68);

        a.inserir(24);

        System.out.println(a.raiz.getDado());
        System.out.println(a.raiz.ehVermelho); // 50
        System.out.println(a.raiz.getEsquerda().getDado());
        System.out.println(a.raiz.getEsquerda().ehVermelho); // 30 v
        System.out.println(a.raiz.getDireita().getDado());
        System.out.println(a.raiz.getDireita().ehVermelho); // 65 p
        System.out.println(a.raiz.getEsquerda().getEsquerda().getDado());
        System.out.println(a.raiz.getEsquerda().getEsquerda().ehVermelho); // 29 p
        System.out.println(a.raiz.getEsquerda().getDireita().getDado());
        System.out.println(a.raiz.getEsquerda().getDireita().ehVermelho); // 40 p
        System.out.println(a.raiz.getEsquerda().getEsquerda().getEsquerda().getDado());
        System.out.println(a.raiz.getEsquerda().getEsquerda().getEsquerda().ehVermelho); // 23 v
//        System.out.println(a.raiz.getEsquerda().getEsquerda().getEsquerda().getDireita().getDado());
//        System.out.println(a.raiz.getEsquerda().getEsquerda().getEsquerda().getDireita().ehVermelho);
        System.out.println(a.raiz.getDireita().getEsquerda().getDado());
        System.out.println(a.raiz.getDireita().getEsquerda().ehVermelho); // 60 v
        System.out.println(a.raiz.getDireita().getDireita().getDado());
        System.out.println(a.raiz.getDireita().getDireita().ehVermelho); // 68 v
    }
}
