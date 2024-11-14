package fr.pantheonsorbonne.cri;

public class QuinteFlush extends MainPoker{
    public QuinteFlush(Card[] cards) {
        super(cards);
    }

    @Override
    public int getForce() {
        return 9; 
    }

    @Override
    public String getName() {
        return "QuinteFlush";
    }
}
