package ru.netology;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> registeredPlayer = new ArrayList<>();

    public void register(Player player) {
        registeredPlayer.add(player);
    }

    private Player findPlayerByName(String playerName) {
        for (Player player : registeredPlayer) {
            if (player.getName().equals(playerName)) {
                return player;
            }
        }
        return null;
    }

    public int round(String playerName1, String playerName2) {
        Player player1 = findPlayerByName(playerName1);
        Player player2 = findPlayerByName(playerName2);
        if (player1 == null || player2 == null) {
            throw new NotRegisteredException("Both players must be registered");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
