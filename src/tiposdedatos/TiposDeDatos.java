/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdedatos;

import java.util.ListIterator;
import java.util.Scanner;

/**
 *
 * @author Mauricio Sosa Giri
 */
public class TiposDeDatos {

    public static void main(String[] args) {
        TreeFromInput tree;
        tree = new TreeFromInput();
        tree.fillTree(tree);
        tree.printTree(tree);
    }

    public static class TreeFromInput extends TiposDeDatos {

        public TreeFromInput tree;

    }

    /**
     *
     * @param root
     */
    public void printTree(TreeFromInput tree) {
        System.out.println("El árbol es:");
        Node root = new Node();
        root = (Node) root.getRoot();
        Node next = (Node) root.getNext((ListIterator) root);
        while (next != null) {
            Node child = new Node();
            child.getNext((ListIterator) next);
            System.out.print(child.getValue() + "  ");
        }
    }

    public TreeFromInput fillTree(TreeFromInput tree) {
        String nodesString = "";
        String valueString = "";
        int level = 0;
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the nodes (first is  root) (space for parent child (level)) (commas for brothers)");
            nodesString = userInput.next();
            if (nodesString.length() != 0) {
                break;
            }
        }
        String[] arrayNodes = nodesString.split("");
        for (String s : arrayNodes) {
            if (s == ",") {
                Node child = new Node();
                child.setValue(valueString);
                valueString = "";
                level++;
            } else if (s == " ") {
                Node node = new Node();
                node.setValue(valueString);
                Node parent = new Node();
                parent = (Node) parent.getLast();
                parent.setChild(node);
                valueString = "";
            } else {
                valueString = valueString + s;
            }
        }
        return tree;
    }
}
