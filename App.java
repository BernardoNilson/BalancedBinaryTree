/**
 * Classe principal do Trabalho Final de Algoritmos e Estruturas de Dados I
 * @author Bernardo Nilson
 * @author Juliana Fernandes
 * @author Prof. Marcio Pinho
 */
public class App {
    public static void main(String[] args) {
        BinarySearchTreeOfInteger b = new BinarySearchTreeOfInteger();
        b.add(15);
        b.add(23);
        b.add(9);
        b.add(11);
        b.add(2);
        b.add(20);
        b.add(38);

        // b.add(13);
        b.add(48);
        b.add(68);

        System.out.println("-------------");
        b.GeraDOT();
        System.out.println("-------------"); 
        System.out.println("Root element: " + b.getRoot());
        b.ApplyBalancing(15);
        System.out.println("Root element: " + b.getRoot());
        // System.out.println("Central:\n" + b.positionsCentral());
        
        // System.out.println("Contem 2? " + b.contains(2));
        // System.out.println("Contem 38? " + b.contains(38));
        // System.out.println("Contem 55? " + b.contains(55));
        // System.out.println("Contem 32? " + b.contains(32));

        System.out.println("-------------");
        b.GeraDOT();
        System.out.println("-------------");        
     }
   
}
