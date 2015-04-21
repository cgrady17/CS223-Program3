import java.util.Iterator;
import java.util.List;

import java.util.ArrayList;

public class GeneralTree<E> {

    private static class Directory<E> {

        E data;

        List<Directory> children = new ArrayList<Directory>();

        public Directory(E data) {this.data = data;}

    }

    private Directory<E> root;

    public GeneralTree() {}

    public GeneralTree(Directory<E> root) {this.root = root;}

/*    public static GeneralTree createSampleTree() {

        Node a = new Node("a");

        Node b = new Node("b");

        Node c = new Node("c");

        Node d = new Node("d");

        a.children.add(b);

        a.children.add(c);

        a.children.add(d);

        Node e = new Node("e");

        Node f = new Node("f");

        Node g = new Node("g");

        Node h = new Node("h");

        Node i = new Node("i");

        b.children.add(e); b.children.add(f);

        b.children.add(g); b.children.add(h);

        b.children.add(i);



        Node j = new Node("j");

        d.children.add(j);

        return new Tree(a);

    }*/



    private void displayHelper(Directory<E> dir, int indent) {

        System.out.printf("%" + indent + "s\n", dir.data.toString());

        for (Directory c : dir.children) displayHelper(c, indent + 3);

    }

    public void display() {

        displayHelper(root, 3);

    }

    public int getHeight(){

        throw new UnsupportedOperationException();

    }

    public int getLevel(E item){

        throw new UnsupportedOperationException();

    }

    //HW: write method that returns an iterator that would allow

    //    access to data in the tree in a depth first search

    public Iterator iterator(){

        throw new UnsupportedOperationException();

    }

}