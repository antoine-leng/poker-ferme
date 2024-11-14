package fr.pantheonsorbonne.cri;

public class HandResult {

    private int maxCardCount = 0;
    private Value cardValue = null;
    private Card[] cards;

    public HandResult(Card[] cards) {
        this.cards = cards;

        // on parcourt toutes les cartes
        for (int i = 0; i < cards.length; i++) {
            Value currCardValue = cards[i].getValue();
            int currCardCount = 1;

            // on compte combien il y a de carte identique cards[i]
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[j].getValue() == currCardValue) {
                    currCardCount++;
                }
            }

            // Si on a un total égal au maximum déjà compté
            if (currCardCount == maxCardCount) {
                // on regarde si notre combinaison est meilleure
                if (cardValue.ordinal() > currCardValue.ordinal()) {
                    // si c'est le cas, on remplace l'ancienne meilleure combinaison par celle en
                    // cours
                    cardValue = currCardValue;
                }
                // sinon, on ne fait rien
            }
            // si notre combinaison contient un plus grand nombre de carte
            else if (currCardCount > maxCardCount) {
                // on remplace l'ancienne
                cardValue = currCardValue;
                maxCardCount = currCardCount;
            }

        }

    }

    public int getNumRepetition() {
        return maxCardCount;

    }

    public Value getHighCard() {
        return cardValue;
    }





    public boolean isPaire() {
        int pairCount = 0;
        for (int i = 0; i < cards.length; i++) {
            int count = 1;
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].getValue() == cards[j].getValue()) {
                    count++;
                }
            }
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 1;
    }

    public boolean isDoublePaire() {
        int pairCount = 0;
        for (int i = 0; i < cards.length; i++) {
            int count = 1;
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].getValue() == cards[j].getValue()) {
                    count++;
                }
            }
            if (count == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    public boolean isBrelan() {
        for (int i = 0; i < cards.length; i++) {
            int count = 1;
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].getValue() == cards[j].getValue()) {
                    count++;
                }
            }
            if (count == 3) {
                return true;
            }
        }
        return false;
    }

    public boolean isSuite() {
        int[] values = new int[cards.length];
        for (int i = 0; i < cards.length; i++) {
            values[i] = cards[i].getValue().ordinal();
        }
        java.util.Arrays.sort(values);

        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] + 1 != values[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public boolean isCouleur() {
        Color firstColor = cards[0].getColor();
        for (int i = 1; i < cards.length; i++) {
            if (cards[i].getColor() != firstColor) {
                return false;
            }
        }
        return true;
    }

    public boolean isFull() {
        boolean hasBrelan = false;
        boolean hasPaire = false;
        Value brelanValue = null;
    
        for (int i = 0; i < cards.length; i++) {
            int count = 1;
            Value currentValue = cards[i].getValue();
    
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[j].getValue() == currentValue) {
                    count++;
                }
            }
    
            if (count == 3) {
                hasBrelan = true;
                brelanValue = currentValue;
            } else if (count == 2 && currentValue != brelanValue) {
                hasPaire = true;
            }
        }
    
        return hasBrelan && hasPaire;
    }
    

    public boolean isCarre() {
        for (int i = 0; i < cards.length; i++) {
            int count = 1;
            for (int j = i + 1; j < cards.length; j++) {
                if (cards[i].getValue() == cards[j].getValue()) {
                    count++;
                }
            }
            if (count == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean isQuinteFlush() {
        return isSuite() && isCouleur();
    }



    public static MainPoker determinerMain(Card[] cards) {
        HandResult result = new HandResult(cards);

        if (result.isQuinteFlush()) {
            return new QuinteFlush(cards);

        } else if (result.isCarre()) {
            return new Carre(cards);

        } else if (result.isFull()) {
            return new Full(cards);

        } else if (result.isCouleur()) {
            return new Couleur(cards);

        } else if (result.isSuite()) {
            return new Suite(cards);

        } else if (result.isBrelan()) {
            return new Brelan(cards);

        } else if (result.isDoublePaire()) {
            return new DoublePaire(cards);

        } else if (result.isPaire()) {
            return new Paire(cards);
        }

        return new CarteHaute(cards);
    }
}