/**
 * Classe principal do Trabalho Final de Algoritmos e Estruturas de Dados I
 * @author Bernardo Nilson
 * @author Juliana Fernandes
 * @author Prof. Marcio Pinho
 */
public class App {
    public static void main(String[] args) {      
        //Teste 1
        BinarySearchTreeOfInteger teste1 = new BinarySearchTreeOfInteger();
        teste1.add(15);
        teste1.add(26);
        teste1.add(2);
        teste1.add(1);
        teste1.add(4);
        teste1.add(6);

        System.out.println("Teste 1");

        System.out.println("-------------");
        teste1.GeraDOT();
        System.out.println("-------------"); 

        teste1.ApplyBalancing(15);

        System.out.println("-------------");
        teste1.GeraDOT();
        System.out.println("-------------"); 
        
        //Teste 2
        BinarySearchTreeOfInteger teste2 = new BinarySearchTreeOfInteger();
        teste2.add(100);
        teste2.add(70);
        teste2.add(50);
        teste2.add(80);
        teste2.add(40);
        teste2.add(55);
        teste2.add(75);
        teste2.add(85);

        System.out.println("Teste 2");

        System.out.println("-------------");
        teste2.GeraDOT();
        System.out.println("-------------"); 

        teste2.ApplyBalancing(100);

        System.out.println("-------------");
        teste2.GeraDOT();
        System.out.println("-------------"); 

        teste2.add(73);

        System.out.println("-------------");
        teste2.GeraDOT();
        System.out.println("-------------");

        teste2.ApplyBalancing(100);

        System.out.println("-------------");
        teste2.GeraDOT();
        System.out.println("-------------");
        
        //Teste 3
        BinarySearchTreeOfInteger teste3 = new BinarySearchTreeOfInteger();
        teste3.add(100);
        teste3.add(70);
        teste3.add(90);
        teste3.add(95);

        System.out.println("Teste 3");

        System.out.println("-------------");
        teste3.GeraDOT();
        System.out.println("-------------"); 

        teste3.ApplyBalancing(100);

        System.out.println("-------------");
        teste3.GeraDOT();
        System.out.println("-------------"); 

        teste3.add(97);
        
        System.out.println("-------------");
        teste3.GeraDOT();
        System.out.println("-------------");

        teste3.ApplyBalancing(90);

        System.out.println("-------------");
        teste3.GeraDOT();
        System.out.println("-------------");
        
    }
     
}