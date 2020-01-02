

import java.util.Scanner;

public class my_full_list {
    class node {
        int value;
        node next;
        node previous;

        node() {
            this.next = null;
            this.previous = null;
            value = 0;
        }

        node(int value) {
            this.value = value;
            this.next = null;
            this.previous = null;
        }

        node(node ob) {
            this.previous = ob.previous;
            this.next = ob.next;
            this.value = ob.value;
        }
        void creadHeadrec(){
            Scanner in=new Scanner(System.in);
            System.out.println("Enter value");
            int num=in.nextInt();
            this.value=num;
            char u;
               System.out.println("continue typing? Y / N ");
               String t=in.next();
               u=t.charAt(t.length()-1);

            if(u=='y'||u=='Y'){
                if(this.previous==null){
                this.previous=new node();
                this.previous.next=this;
                }
                this.previous.creadHeadrec();
            }


        }
        void creadTailrec(){
            Scanner in= new Scanner(System.in);
            System.out.println("¬ведите значение::");
            this.value=in.nextInt();
            System.out.println("continue typing? Y/N");
            char u;
            String t=in.next();
            u=t.charAt(t.length()-1);
            if(u=='Y'||u=='y'){
                if(this.next==null){
                    this.next=new node();
                this.next.previous=this;
                }
                    this.next.creadTailrec();

            }
        }



    }

    int size;
    private node head;
    private node back;

    my_full_list() {
        this.size = 0;
        head = null;
        back = null;

    }

    my_full_list(int v) {
        this.size = v;
        node tmp = new node();
        this.head = tmp;
        for (int i = 0; i < v; i++) {
            tmp.next = new node();
            tmp.next.previous = tmp;
            tmp = tmp.next;
        }
        this.back = tmp;

    }

    my_full_list(my_full_list ob) {
        node tmpob = ob.head;
        node tmp = new node();
        this.head = tmp;
        tmp.value = ob.head.value;
        while (tmpob.next != null) {
            tmpob = tmpob.next;
            tmp.next = new node();
            tmp.next.previous = tmp;
            tmp.value = tmpob.value;
        }
        this.back = tmp;
        this.size = ob.size;

    }

    my_full_list(int val[]) {
        node tmp = new node();
        this.head=tmp;
        if (val.length != 0) {
            this.size = val.length;
        }

        for (int i = 0; i < val.length; i++) {
            tmp.value = val[i];
            tmp.next = new node();
            tmp.next.previous = tmp;
            tmp = tmp.next;
        }
        this.back = tmp;
    }

    int get_value_at(int num) {
        if (this.size < num) {
            System.out.println("function get_value_at:: Error! this value greather then size! ");
            return 0;
        }
        node tmp = this.head;
        for (int i = 0; i < num; i++) {
            tmp = tmp.next;
        }
        return tmp.value;
    }

    void createTail() {
        this.back.next = new node();
        this.back.next.previous = this.back;
        this.back = this.back.next;
        this.size++;
    }

    void createTail(int value) {
        this.back.next = new node(value);
        this.back.next.previous = this.back;
        this.back = this.back.next;
        this.size++;
    }

    void createHead() {
        this.head.previous = new node();
        this.head.previous.next = this.head;
        ;
        this.head = this.head.previous;
        size++;
    }

    void createHead(int val) {
        this.head.previous = new node(val);
        this.head.previous.next = this.head;
        ;
        this.head = this.head.previous;
        size++;
    }

    void addFirst(node ob) {
        if (ob == null) {
            System.out.println("function addFirst ::: Error! this object of type class node indicates on null.");
            return;
        }
        if (ob != null) {
            this.head.previous = ob;
            this.head.previous.next = this.head;
            this.head = this.head.previous;
        }
    }

    void addFirst(my_full_list ob) {
        if (ob.head == null || ob.back == null) {
            System.out.println("function addFirst::: Error! this object of type my_full_list incorrect. ");
            return;
        }
        this.head.previous = ob.back;
        while (this.head.previous != null) {
            this.head = this.head.previous;
            this.size++;

        }
    }

    void addLast(node ob) {
        if (ob == null) {
            System.out.println("fuction addLast::: Error! this object of type class node indicates on null.");
            return;
        }
        this.back.next = ob;
        this.back.next.previous = this.back.next;
        this.back = this.back.next;
    }


    void addLast(my_full_list ob) {
        if (ob.head == null || ob.back == null) {
            System.out.println("fuction addLast::: Error! this object of type class node indicates on null.");
        }
        this.back.next = ob.head;
        while (this.back.next == null) {

            this.back.next.previous = this.back;
            this.back = this.back.next;
            this.size++;

        }
    }

    void insert(int num,int val) {
        if (num > this.size) {
            System.out.println("function insert ::: Error! this number  larger of size ");
        }
        node tmp;
        if (num <= this.size / 2) {
            tmp = this.head;
            for (int i = 0; i < num; i++) {
                tmp = tmp.next;
            }
            node n = new node();
            n.previous = tmp;
            tmp = tmp.next;
            n.next = tmp;
            n.value=val;
            tmp.previous = n;
            tmp = n.previous;
            tmp.next = n;
            size++;


        }
        if (num > this.size / 2) {
            tmp = this.back;
            for (int i = 0; i < (this.size - num); i++) {
                tmp = tmp.previous;
            }
            node n = new node();
            n.previous = tmp;
            tmp = tmp.next;
            n.next = tmp;
            tmp.previous = n;
            tmp = n.previous;
            tmp.next = n;
            size++;

        }
    }

    void removeFirst() {
        node tmp;
        tmp = this.head;
        tmp = tmp.next;
        this.head = tmp;
        --size;
    }

    void removeLast() {
        node tmp = this.back;
        tmp = tmp.previous;
        this.back = tmp;
        this.size--;
    }

    void remove(int num) {
        if (this.size < num) {
            System.out.println("function remove::: Error! this num largest of size!");
        }
        node tmp;
        if (num <= this.size / 2) {
            tmp = this.head;
            for (int i = 0; i < num; i++) {
                tmp = tmp.next;
            }
            node tmp0 = tmp.previous;
            tmp0 = tmp0.previous;
            tmp.previous = tmp0;
            tmp0.next = tmp;
            size--;


        }
        if (num > this.size / 2) {
            tmp = this.back;
            for (int i = 0; i < (this.size - num-1); i++) {
                tmp = tmp.previous;
            }
            node tmp0 = tmp.previous;
            tmp0 = tmp0.previous;
            tmp.previous = tmp0;
            tmp0.next = tmp;
            size--;

        }
    }

    @Override
     public String toString(){
        String st=new String();
    node tmp=this.head;
    while(tmp!=null){
        st+=" "+tmp.value;
        tmp=tmp.next;
    }
    return st;
    }
    void createHeadRec(){
        if(this.head==null){
            this.head=new node();
        }
        this.head.creadHeadrec();
        thisHeadfind();
        thisSizefind();

    }
    void createTailRec(){
        if(this.back==null){
            this.back=new node();
        }
        this.back.creadTailrec();
        thisBackfind();
        thisSizefind();
    }

    private void thisHeadfind(){
        while(this.head.previous!=null){
            this.head=this.head.previous;
        }
    }
    private void thisBackfind(){
        while(this.back.next!=null){
            this.back=this.back.next;
        }
    }

    private void thisSizefind(){
        if(this.head==null||this.back==null){return ;}
        node tmp=this.head;
        int s=1;
        while(tmp.next!=null){
            tmp=tmp.next;
            s++;
        }
        this.size=s;
    }
    void show(){
        node tmp= this.head;
        int i=0;
        while(tmp!=null){
            System.out.println("ob["+i+"]= "+tmp.value);
        tmp=tmp.next;
        i++;
        }


    }






}
