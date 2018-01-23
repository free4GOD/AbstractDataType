/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiposdedatos;

import java.util.List;
import java.lang.Object;
/**
 *
 * @author Mauricio
 */
class Node {

    public Object data;
    public List<Node> node;
    Node() {
        this.node = (List<Node>) node;
    }
    
    void value(Object data) {
        this.data = data;
    }
    
     Object getValue() {
        return this.data = data;
    }
        
    void addChild(Node child) {
        this.node.add(child);
    }
    
    void delChild(Node child) {
        this.node.remove(child);
    }
    
    Node getChilds() {
        return (Node) this.node.listIterator();
    }
    
    Node getNext (Node previous) {
        int num = this.node.indexOf(previous);
        num = num++;
        if (num != -1 && num <= this.node.size()) {
            return (Node) this.node.get(num);
        } else {
            return null;
        }
    }
    
    Node getSpecific (int num) {
        return (Node) node.get(num);
    }
    
    Node getBefore (Node actual) {
        int index = node.indexOf(actual);
        if (index >= 0) {
            return (Node) node.get(index-1);
        }
        return null;
    }
    
    Node getRoot () {
        return (Node) node.get(0);
    }
    
    Node getLast () {
        int last = node.size();
        return (Node) node.get(last);
    }
} 
