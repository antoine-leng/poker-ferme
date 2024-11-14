package fr.pantheonsorbonne.cri;

public class Couleur extends MainPoker{
    public Couleur(Card[] cards) {
        super(cards);
    }

    @Override
    public int getForce() {
        return 6; 
    }

    @Override
    public String getName() {
        return "Couleur";
    }
}
