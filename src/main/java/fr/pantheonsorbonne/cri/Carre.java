package fr.pantheonsorbonne.cri;

public class Carre extends MainPoker {
    public Carre(Card[] cards) {
        super(cards);
    }

    @Override
    public int getForce() {
        return 8; // La Paire a une force de 2
    }

    @Override
    public String getName() {
        return "Carre";
    }
}
