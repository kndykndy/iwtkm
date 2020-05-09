package com.kndykndy.leetcode;

import java.util.LinkedList;
import java.util.List;

public class p_GameOfBattleships {

    interface Solution {

        /**
         * N is unnecessary
         * S are rectangular ships, not bigger than 4 cells
         * Ships do not overlap
         * T contains unique cells
         * S & T are valid
         */
        String solution(int N, String S, String T);
    }

    public static class Solution1 implements Solution {

        public enum Status {NOT_HIT, HIT, SUNK}

        static class Ship {

            private int shotsReceived = 0;

            private final List<String> cells = new LinkedList<>();

            void addCell(String cell) {
                cells.add(cell);
            }

            boolean checkIfGotShot(String shotCell) {
                boolean gotShot = cells.contains(shotCell);

                if (gotShot) {
                    ++shotsReceived;
                }

                return gotShot;
            }

            Status getStatus() {
                return shotsReceived == 0
                    ? Status.NOT_HIT
                    : shotsReceived == cells.size() ? Status.SUNK : Status.HIT;
            }
        }

        public String solution(int N, String S, String T) {
            final List<Ship> ships = buildShips(S);

            shootAtShips(T, ships);

            return getBattleStatistics(ships);
        }

        private List<Ship> buildShips(String S) {
            final List<Ship> result = new LinkedList<>();

            final String[] rawShips = S.split(",");
            for (String rawShip : rawShips) { // rawShip is "1B 2C" now
                final String[] shipBoundaries = rawShip.split(" "); // must have length=2
                final int[] lengths = new int[]{
                    shipBoundaries[0].length(), shipBoundaries[1].length()
                };

                // 26 letters in English alp -> if N is 26 row part of boundary is two-digit
                final int row1 = Integer.parseInt(shipBoundaries[0].substring(0, lengths[0] - 1));
                final char column1 = shipBoundaries[0].charAt(lengths[0] - 1);

                final int row2 = Integer.parseInt(shipBoundaries[1].substring(0, lengths[1] - 1));
                final char column2 = shipBoundaries[1].charAt(lengths[1] - 1);

                // well, I understand we have a req "ships are rectangular & not bigger than 4 cells"
                // and this may be optimized (theoretically), but no time for that now((
                final Ship currentShip = new Ship();
                for (int i = row1; i <= row2; i++) {
                    for (char j = column1; j <= column2; j++) {
                        currentShip.addCell(Integer.toString(i) + j);
                    }
                }
                result.add(currentShip);
            }

            return result;
        }

        private void shootAtShips(String rawShots, List<Ship> ships) {
            for (String rawShot : rawShots.split(" ")) {
                for (Ship ship : ships) {
                    if (ship.checkIfGotShot(rawShot)) {
                        break; // as they do not overlap
                    }
                }
            }
        }

        private String getBattleStatistics(List<Ship> ships) {
            int hitShips = 0, sunkShips = 0;

            for (Ship ship : ships) {
                if (Status.SUNK == ship.getStatus()) {
                    ++sunkShips;
                } else if (Status.HIT == ship.getStatus()) {
                    ++hitShips;
                } // else it was not hit :)
            }

            return String.format("%d,%d", sunkShips, hitShips);
        }
    }
}
