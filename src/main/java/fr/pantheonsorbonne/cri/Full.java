package fr.pantheonsorbonne.cri;

public class Full extends MainPoker{
    public Full(Card[] cards) {
        super(cards);
    }

    @Override
    public int getForce() {
        return 7; // La Paire a une force de 2
    }

    @Override
    public String getName() {
        return "Full";
    }
}
