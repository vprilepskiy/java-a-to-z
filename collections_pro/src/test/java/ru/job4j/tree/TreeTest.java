package ru.job4j.tree;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by VLADIMIR on 25.07.2017.
 */
public class TreeTest {


    @Test
    public void test() {

        Tree tree = new Tree<>();

        tree.a();

//        System.out.println(iterator.hasNext());

//        System.out.println(iterator.next());

//        Node node = new Node("Viktor");
//        node.children.add(new Node("Vova"));
//        node.children.add(new Node("Andrey"));

//        tree.add("Viktor", "Vova");

//        tree.search(node);



//        Iterator<String> iterator = tree.iterator();
//
//        System.out.println(iterator.hasNext());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

    }


    @Test
    public void test2() {

        List<String> list = new LinkedList<>();
        Iterator<String> iterator = list.iterator();

        list.add(null);

        System.out.println(list.isEmpty());
        System.out.println(list.size());



        System.out.println(iterator.hasNext());


    }



    class st{

        private String s = "0123";

        {
            System.out.println(this.s);
        }
    }

    class MyIterator{
        Node rootNode;

        MyIterator(Node rootNode) {
            this.rootNode = rootNode;
        }

        void next() {
            if (this.rootNode.children.isEmpty()) {
                System.out.println(this.rootNode.value);
            } else {

            }
        }

    }



    class Node{
        final Object value;
        final List<Node> children;

        Node(Object value){
            this.value = value;
            children = new LinkedList<Node>();
        }
    }



    @Test
    public void rekursia() {
        System.out.println(this.rek(i));
        System.out.println(this.rek(i));
    }

    int i = 5;

    private int rek(int number) {

        if (number > 0) {
            number--;
            this.rek(number);
        }

        return number;
    }

}
