/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdedatos;

import java.util.List;
import java.util.ListIterator;
/**
 *
 * @author Mauricio Sosa Giri (free4GOD)
 */
public class Node<A> extends TiposDeDatos {

    private A value;
    private List<Node<A>> child;
    
    public Node(A value, List<Node<A>> child) {
       this.child = (List<Node<A>>) child;
       this.value = value;
    }

    Node() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    void setValue(A value) {
        this.value = value;
    }
    
     A getValue() {
        return this.value;
    }
        
    void setChild(Node node) {
        this.child.add(node);
    }
    
    void delChild(Node childOfChild) {
        this.child.remove(childOfChild);
    }
    
    ListIterator<Node<A>> getChildren() {
        return this.child.listIterator();
    }
    
    ListIterator<Node<A>> getNext (ListIterator<Node<A>> previous) {
        int num = this.child.indexOf(previous);
        num = num++;
        if (num != -1 && num <= this.child.size()) {
            return (ListIterator<Node<A>>) this.child.get(num);
        } else {
            return null;
        }
    }
    
    ListIterator<Node<A>> getSpecific (int num) {
        return (ListIterator<Node<A>>) this.child.get(num);
    }
    
    ListIterator<Node<A>> getBefore (ListIterator<Node<A>> actual) {
        int index = this.child.indexOf(actual);
        if (index >= 0) {
            return (ListIterator<Node<A>>) this.child.get(index-1);
        }
        return null;
    }
    
    ListIterator<Node<A>> getRoot () {
        return (ListIterator<Node<A>>) this.child.get(0);
    }
    
    ListIterator<Node<A>> getLast () {
        int last = this.child.size();
        return (ListIterator<Node<A>>) this.child.get(last);
    }
} 
