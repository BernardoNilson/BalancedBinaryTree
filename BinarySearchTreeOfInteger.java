

public class BinarySearchTreeOfInteger {

    private static final class Node {

        public Node father;
        public Node left;
        public Node right;
        public Integer element;

        public Node(Integer element) {
            father = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos        
    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    // Construtur da public BinarySearchTreeOfInteger() {
    public BinarySearchTreeOfInteger() {
        count = 0;
        root = null;
    }

    // Consultas
    public void clear() {
        count = 0;
        root = null;
    }

    public boolean isEmpty() {
        return (root == null);
    }

    public int size() {
        return count;
    }

    public Integer getRoot() {
        if (isEmpty()) {
            throw new EmptyTreeException();
        }
        return root.element;
    }

    public int getHeight() {
        return getHeight(root);
    }
    
    private int getHeight(Node node) {
        if (node == null) return 0;
    
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
    
        return (leftHeight > rightHeight) ? leftHeight + 1 : rightHeight + 1;
    }
    
    // Adição de elementos na lista
    public void add(Integer element) {
        root = add(root, element, null);
        count++;
    }
    
    private Node add(Node n, Integer e, Node father) {
        if (n == null) {
            Node aux = new Node(e);
            aux.father = father;
            return aux;
        }
        if (n.element.compareTo(e) < 0) {
            n.right = add(n.right, e, n);
        }
        else {
            n.left = add(n.left, e, n);
        }
        return n;
    }

    // Balaceamento
    public void ApplyBalancing(Integer e) {
        // Procura o nodo do elemento
        Node n = searchNodeRef(e, root);
        System.out.println("Balanceamento do nodo com o elemento: " + n.element);
        if (n != null) {
            ApplyBalancing(n);
        }
    } 

    private void ApplyBalancing(Node n) {
        // Condicionais para aplicar rotações específicas
        if (!isBalanced(n)) {
            int rotation = whichRotation(n);

            switch (rotation) {
                case 1:
                    System.out.println("Estamos usando a rotação Esquerda-Esquerda!");
                    rotationToRight(n);
                    break;
                case 2:
                    System.out.println("Estamos usando a rotação Esquerda-Direita!");
                    rotationToLeft(n.left);
                    rotationToRight(n);
                    break;
                case 3:
                    System.out.println("Estamos usando a rotação Direita-Esquerda!");
                    rotationToRight(n.right);
                    rotationToLeft(n);
                    break;
                case 4:
                    System.out.println("Estamos usando a rotação Direita-Direita!");
                    rotationToLeft(n);
                    break;
            
                default:
                    break;
            }
        }
    }

    private void rotationToRight(Node n) {
        //  Rotação EE
        if (n != null) {
            Node child = n.left;
            Node father = n.father;
            
            // Atribui o pai do filho da esquerda como o pai do nodo e se esse pai existe
            // define que esse filho da esquerda é filho desse pai
            child.father = father;
            if (father != null) {
                if (father.right == n) father.right = child;
                else if (father.left == n) father.left = child;
            }
            
            // Caso o filho tenha alguém na direita, passamos 
            // esses nodos para a esquerda livre do nodo
            n.left = child.right;
            if (child.right != null) child.right.father = n;

            // Se o nodo é o root, atualizamos o root
            if (n == root) root = child;
            
            // Invertemos a relação de pai para filho 
            n.father = child;
            child.right = n;
        }
    }

    private void rotationToLeft(Node n) {
        //  Rotação DD
        if (n != null) {
            Node child = n.right;
            Node father = n.father;

            // System.out.println("Father de n: " + father.element);
            // System.out.println("N: " + n.element);
            // System.out.println("Filho de n: " + child.element);

            child.father = father;

            if (father != null) {
                if (father.right == n) father.right = child;
                else if (father.left == n) father.left = child;
            }
            
            n.right = child.left;
            if (child.left != null) child.left.father = n;

            if (n == root) root = child;
            
            n.father = child;
            child.left = n;
        }
    }

    /**
     * Retornos:
     * 0 se Node está nulo,
     * 1 se for rotação EE,
     * 2 se for rotação ED,
     * 3 se for rotação DE,
     * 4 se for rotação DD
     */
    private int whichRotation(Node n) {
        if (n == null) return 0;

        Node leftChild = n.left;
        Node rightChild = n.right;

        if (isHighestOrEqualThan(leftChild, rightChild)) {
            if (isHighestOrEqualThan(leftChild.left, leftChild.right)) return 1;
            else return 2;
        } else {
            if (isHighestOrEqualThan(rightChild.right, rightChild.left)) return 4;
            else return 3;
        }
    }

    private boolean isHighestOrEqualThan(Node node, Node compared) {
        return getHeight(node) >= getHeight(compared);
    }

    private boolean isBalanced(Node n) {
        if (n == null) return false;

        return Math.abs(getHeight(n.left) - getHeight(n.right)) <= 1;
    }
    
    // Caminhamentos
    public LinkedListOfInteger positionsPre() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPreAux(root, res);
        return res;
    }

    private void positionsPreAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            res.add(n.element); //Visita o nodo
            positionsPreAux(n.left, res); //Visita a subárvore da esquerda
            positionsPreAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsPos() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsPosAux(root, res);
        return res;
    }

    private void positionsPosAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsPosAux(n.left, res); //Visita a subárvore da esquerda
            positionsPosAux(n.right, res); //Visita a subárvore da direita
            res.add(n.element); //Visita o nodo
        }
    }

    public LinkedListOfInteger positionsCentral() {
        LinkedListOfInteger res = new LinkedListOfInteger();
        positionsCentralAux(root, res);
        return res;
    }

    private void positionsCentralAux(Node n, LinkedListOfInteger res) {
        if (n != null) {
            positionsCentralAux(n.left, res); //Visita a subárvore da esquerda
            res.add(n.element); //Visita o nodo
            positionsCentralAux(n.right, res); //Visita a subárvore da direita
        }
    }

    public LinkedListOfInteger positionsWidth() {
        Queue<Node> fila = new Queue<>();
        Node atual = null;
        LinkedListOfInteger res = new LinkedListOfInteger();
        if (root != null) {
            fila.enqueue(root);
            while (!fila.isEmpty()) {
                atual = fila.dequeue();
                if (atual.left != null) {
                    fila.enqueue(atual.left);
                }
                if (atual.right != null) {
                    fila.enqueue(atual.right);
                }
                res.add(atual.element);
            }
        }
        return res;
    }

    // Verificações
    public boolean contains(Integer element) {
        Node aux = searchNodeRef(element, root);
        return (aux != null);
    }

    private Node searchNodeRef(Integer element, Node target) {
        if (element == null || target == null) {
            return null;
        }
        int r = target.element.compareTo(element);
        if (r == 0) {
            return target;
        }
        else if (r > 0) {
            return searchNodeRef(element, target.left);
        }
        else {
            return searchNodeRef(element, target.right);
        }
    }    

    // Geração da visualização DOT
    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }    
}
