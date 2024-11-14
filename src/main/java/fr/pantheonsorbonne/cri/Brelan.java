package fr.pantheonsorbonne.cri;

public class Brelan extends MainPoker{

    public Brelan(Card[] cards) {
        super(cards);
    }

    @Override
    public int getForce() {
        return 4; 
    }

    @Override
    public String getName() {
        return "Brelan";
    }

}
