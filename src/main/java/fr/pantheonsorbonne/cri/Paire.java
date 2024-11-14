package fr.pantheonsorbonne.cri;

public class Paire extends MainPoker{
    public Paire(Card[] cards) {
        super(cards);
    }

    @Override
    public int getForce() {
        return 2; 
    }

    @Override
    public String getName() {
        return "Paire";
    }

}
