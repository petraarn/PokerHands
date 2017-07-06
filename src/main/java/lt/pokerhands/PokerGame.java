package lt.pokerhands;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import lt.pokerhands.ranks.FlushRank;
import lt.pokerhands.ranks.FourOfAKindRank;
import lt.pokerhands.ranks.FullHouseRank;
import lt.pokerhands.ranks.HighCardRank;
import lt.pokerhands.ranks.OnePairRank;
import lt.pokerhands.ranks.RoyalFlushRank;
import lt.pokerhands.ranks.StraightFlushRank;
import lt.pokerhands.ranks.StraightRank;
import lt.pokerhands.ranks.ThreeOfAKindRank;
import lt.pokerhands.ranks.TwoPairRank;

public class PokerGame {

    private final List<PokerRank> gameRules = new ArrayList<>();
    private final List<PokerGameHand> players = new ArrayList<>();
    private final Set<Card> usedCards = new HashSet<>();
    private Integer winnerPlayerNumber = -1;

    public PokerGame() {
        initRules();
    }

    private void initRules() {
        gameRules.add(new RoyalFlushRank());
        gameRules.add(new StraightFlushRank());
        gameRules.add(new FourOfAKindRank());
        gameRules.add(new FullHouseRank());
        gameRules.add(new FlushRank());
        gameRules.add(new StraightRank());
        gameRules.add(new ThreeOfAKindRank());
        gameRules.add(new TwoPairRank());
        gameRules.add(new OnePairRank());
        gameRules.add(new HighCardRank());
    }

    public void addPlayerCard(int playerNumber, Card card) {
        if (!usedCards.add(card)) {
            throw new RuntimeException("Dublicate card used in a game! Somebody is cheating!");
        }
        if (players.size() <= playerNumber) {
            players.add(new PokerGameHand());
        }
        players.get(playerNumber).addCard(card);
    }

    public PokerGameHand getPlayerHand(int playerNumber) {
        return players.get(playerNumber);
    }

    public PokerGame findWinner() {
        for (int rank = 0; rank < gameRules.size(); rank++) {
            PokerRank pokerRank = gameRules.get(rank);
            List<Integer> matchedRankPlayer = findMatchedPlayers(pokerRank);
            if (matchedRankPlayer.size() == 1) {
                winnerPlayerNumber = matchedRankPlayer.get(0);
                //printResult(rank, pokerRank);
                break;
            } else if (matchedRankPlayer.size() > 1) {
                winnerPlayerNumber = matchedRankPlayer.stream()
                        .collect(Collectors.toMap(p -> p, players::get))
                        .entrySet()
                        .stream()
                        .max(compareByValue(pokerRank))
                        .map(Map.Entry::getKey)
                        .get();
                //printResult(rank, pokerRank);
                break;
            }
        }
        return this;
    }

    private void printResult(int rank, PokerRank pokerRank) {
        System.out.println(pokerRank.getClass().getName() + " : " + winnerPlayerNumber.toString() + " : "
                + players.get(winnerPlayerNumber).toString() + " /// " + players.get(winnerPlayerNumber == 1 ? 0 : 1));
    }

    private static Comparator<Map.Entry<Integer, PokerGameHand>> compareByValue(PokerRank pokerRank) {
        return (player1, player2) -> pokerRank.getComparator().compare(player1.getValue(), player2.getValue());
    }

    private List<Integer> findMatchedPlayers(PokerRank pokerRank) {
        List<Integer> matchedRankPlayer = new ArrayList<>();
        for (Integer p = 0; p < players.size(); p++) {
            PokerGameHand hand = players.get(p);
            if (pokerRank.isMatch(hand)) {
                matchedRankPlayer.add(p);
            }
        }
        return matchedRankPlayer;
    }

    public Integer getWinnerPlayerNumber() {
        return winnerPlayerNumber;
    }

}
