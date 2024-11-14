package fr.pantheonsorbonne.cri;

public class Suite extends MainPoker{
    public Suite(Card[] cards) {
        super(cards);
    }

    @Override
    public int getForce() {
        return 5; // La Paire a une force de 2
    }

    @Override
    public String getName() {
        return "Suite";
    }
}
