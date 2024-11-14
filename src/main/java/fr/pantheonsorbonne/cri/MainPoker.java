package fr.pantheonsorbonne.cri;

public abstract class MainPoker {
    protected Card [] cards;

    MainPoker(Card[] cards){
        this.cards=cards;
    }

    abstract int getForce();

    abstract String getName();

}
