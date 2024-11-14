package fr.pantheonsorbonne.cri;

public class DoublePaire extends MainPoker{

    public DoublePaire(Card[] cards) {
        super(cards);
    }

    @Override
    public int getForce() {
        return 3; 
    }

    @Override
    public String getName() {
        return "DoublePaire";
    }


}
