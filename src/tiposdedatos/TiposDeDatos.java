/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdedatos;

import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Mauricio Sosa Giri
 */
public class TiposDeDatos {

    Object Node;

    public static void main(String[] args) {
        TreeFromInput tree = new TreeFromInput();
        tree.fillTree(tree);
        tree.printTree(tree);
    }

    public TiposDeDatos() {

    }

    public static class TreeFromInput extends TiposDeDatos {
        public TreeFromInput tree;
        public Node root;

        public TreeFromInput() {
            root = new Node();
        }

        /**
         *
         * @param root
         */
        public void printTree(TreeFromInput tree) {
            System.out.println("El árbol es:");
            System.out.println(tree.root.getValue());
            Node next = new Node();
            next = tree.root.getNext(tree.root);
            while (next != null) {
                Node child = new Node();
                child.getNext(next);
                System.out.print(child.getValue() + "  ");
            }
        }

        public TreeFromInput fillTree(TreeFromInput tree) {
            String rootString;
            String childString;
            String valueString = "";
            int level = 0;
            Scanner userInput = new Scanner(System.in);
            while (true) {
                System.out.println("Enter the root (String)");
                rootString = userInput.next();
                if (rootString.length() != 0) {
                    break;
                }
            }
            while (true) {
                System.out.println("Enter the childs (space for parent child (level)) (commas for brothers)");
                childString = userInput.next();
                if (childString.length() != 0) {
                    break;
                }
            }
            tree.root.value(rootString);
            String[] arrayChilds = childString.split("");
            for (String s : arrayChilds) {
                if (s == ",") {
                    Node child = new Node();
                    child.value(valueString);
                    tree.root.addChild(child);
                    valueString = "";
                    level++;
                } else if (s == " ") {
                    Node node = new Node();
                    node.value(valueString);
                    Node parent = new Node();
                    parent = parent.getLast();
                    parent.addChild(node);
                    valueString = "";
                } else {
                    valueString = valueString + s;
                }
            }
            return tree;
        }
    }
}
