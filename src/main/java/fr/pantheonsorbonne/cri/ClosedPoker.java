package fr.pantheonsorbonne.cri;

import java.util.ArrayList;
import java.util.List;

public class ClosedPoker {

    public static void main(String... args) {
        // création des joueurs
        Player p1 = new Player("Nicolas");
        Player p2 = new Player("Elio");
        Player p3 = new Player("Flavio");

        // donner des cartes aux joueurs
        p1.setHand(Deck.newRandomHand());
        p2.setHand(Deck.newRandomHand());
        p3.setHand(Deck.newRandomHand());

        // récupérer les cartes que les joueurs veulent défausser et leur donner de
        // nouvelles cartes
        Card[] cardsP1 = p1.getCardsToDiscard();
        p1.addCard(Deck.getRandomCards(cardsP1.length));

        Card[] cardsP2 = p2.getCardsToDiscard();
        p2.addCard(Deck.getRandomCards(cardsP2.length));

        Card[] cardsP3 = p3.getCardsToDiscard();
        p3.addCard(Deck.getRandomCards(cardsP3.length));

        // vérifier qui gagne

        List<Player> players = new ArrayList<>();

        if (p1.beats(p2) && p1.beats(p3)) {
            players.add(p1);
            if (p2.beats(p3)) {
                players.add(p2);
                players.add(p3);
            } else {
                players.add(p3);
                players.add(p2);
            }

        } else if (p2.beats(p1) && p2.beats(p3)) {
            players.add(p2);
            if (p1.beats(p3)) {
                players.add(p1);
                players.add(p3);
            } else {
                players.add(p3);
                players.add(p1);
            }

        } else if (p3.beats(p1) && p3.beats(p2)) {
            players.add(p3);
            if (p1.beats(p2)) {
                players.add(p1);
                players.add(p2);
            } else {
                players.add(p2);
                players.add(p1);
            }
        }

        System.out.println("");
        System.out.println(players.get(0).name + " WINS WITH HAND \n" + players.get(0).getHandString());

        System.out.println("");
        System.out.println("\nClassement des joueurs :");
        for (Player player : players) {
            MainPoker H = HandResult.determinerMain(player.getCards());
            System.out.println(player.name + " with hand (force "+H.getForce()+" => "+H.getName()+"): \n" +player.getHandString());
        }
    }

}