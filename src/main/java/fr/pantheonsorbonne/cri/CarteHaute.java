package fr.pantheonsorbonne.cri;

public class CarteHaute extends MainPoker{
    public CarteHaute(Card[] cards) {
        super(cards);
    }

    @Override
    public int getForce() {
        return 1;
    }

    @Override
    public String getName() {
        return "CarteHaute";
    }
}
