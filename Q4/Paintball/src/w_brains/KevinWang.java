/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package w_brains;

import arena.Action;
import arena.Board;
import arena.Brain;
import arena.Direction;
import arena.Occupant;
import arena.Player;
import java.awt.Color;
import java.util.Arrays;

/**
 * I really wish I had more time to work on this
 * 
 * Maple, from the anime Bofuri.
 * In the anime, Maple really doesn't like getting hurt, so she maxes out her defense.
 * 
 * This isn't a super god bot, but it should be *good enough* for the first contest.
 * If you don't want to read over the next 200 lines of spaghetti, I'll summarize my strategy.
 * 
 * goals (in this order)
 * - avoid death
 *      avoiding bullets allows you to best achieve goals
 *      I wasn't actually able to finish bullet dodging, if I had more time,
 *      I would definitely like to add it in.
 * - eliminate attackers
 *      attackers present the most threat, being able to both shoot your teammates, and your base
 * - eliminate teammates shooting the base
 *      the second biggest threat are poorly coded bots on your team. if your team is shooting your base, or killing teammates, might as well kill them too
 * - stay near the base (or middle?)
 *      nothing to explain
 * 
 * <ol>
 * <li>1. Return to the base.</li>
 * <li>2. If the opponent comes within shooting range, start spamming bullets 
 * in their general direction.</li>
 * <li>3. If they come super close, inside the base, shoot with more accuracy. 
 * Ideally, we don't want to hit the base, or other teammates.</li>
 * </ol>
 * 
 * @author Kevin Wang
 */
public class KevinWang implements Brain {
    static boolean campingBase = false;
    
    int currentColor = 0;
    int baseRow = 16;
    int baseCol = -1;
    
    
    
    
    
    // CONSTANTS

    // if Maple wanders 6 units from the base, it'll run back to base:
    // running back to base is going within 3 units
    final int outerStrayLimit = 6;
    final int innerStrayLimit = 3;
    
    // if the enemy is within 15 units of Maple, it'll start shooting
    final int enemyAttackRange = 15;
    // if the enemy is within 5 units of the base, it'll switch to precise mode:
    // when the enemy is coming from their side, we can just spam shots carelessly, hoping one will eventually hit them
    // when the enemy is in our base, we need to be extremely careful as to not shoot our own base
    final int baseLimit = 5;

    
    
    
    
    /**
     * Returns the name of the strategy.
     * @return "Maple"
     */
    @Override
    public String getName() {
        return "Maple";
    }

    /**
     * Returns the name of the coder.
     * @return "Kevinus Wangus"
     */
    @Override
    public String getCoder() {
        return "Kevinus Wangus";
    }

    /**
     * Returns the color of the strategy
     * @return brown
     */
    @Override
    public Color getColor() {
        Color pickedColor = Color.getHSBColor((float)currentColor/256, (float)1.00, (float)1.00);
        
        currentColor = (currentColor + 4) % 256;
        
        return pickedColor;
    }

    /**
     * Decides the action of the DumbBaseCharger, according to the strategy
     * presented above.
     * @param p the Player object containing this Brain
     * @param b the Board on which this Brain's Player is located
     * @return a new Action object indicating the DumbBaseCharger's choice
     * to move or shoot, as appropriate.
     */
    @Override
    public Action getMove(Player p, Board b) {
        // get all enemies and teammates
        Player[] enemies = new Player[30];
        //Player[] teammates = new Player[3];
        
        int enemyCount = 0;
        //int teamCount = 0;
        for (Player player : b.getAllPlayers()) {
            if (player.getTeam() != p.getTeam()) {
                enemies[enemyCount++] = player;
            } else {
                //teammates[teamCount++] = player;
            }
        }
        
        //determine location of base
        if (baseCol == -1) {
            baseCol = b.getBase(p.getTeam()).getCol();
        }
        
        // if you can't tell, this is a modified version of dumb base chaser
        // but instead of attacking aggressively, it defends aggressively
        // ideally this should attack enemies that come too close, or teammates who are shooting the base
        
        //determine distance and direction to base
        int distToBase = Direction.moveDistance(p.getRow(), p.getCol(), baseRow, baseCol);
        int dirToBase = Direction.getDirectionTowards(p.getRow(), p.getCol(), baseRow, baseCol);
        if (distToBase > outerStrayLimit) campingBase = false;
        
        // find the closest enemy
        int closestIndex = 0;
        int closestDist = 999;
        for (int i=0; i<3; i++) {
            if (enemies[i] == null) continue;
            int dist = Direction.moveDistance(p.getRow(), p.getCol(), enemies[i].getRow(), enemies[i].getCol());
            if (closestDist > dist) {
                closestDist = dist;
                closestIndex = i;
            }
        }
        
        if (campingBase) {
            // we're near base, move around randomly until enemies are in sight
            // then shoot all enemies
            
            // if the enemy is close, attack them
            if (closestDist <= enemyAttackRange) {
                // get direction to closest
                int dirToClosest = Direction.getDirectionTowards(p.getRow(), p.getCol(),
                        enemies[closestIndex].getRow(), enemies[closestIndex].getCol());
                
                // turn towards them
                if (dirToClosest != p.getDirection()) {
                    return new Action("T", dirToClosest);
                }
                
                int[] nextSpace = Direction.getLocInDirection(p.getRow(), p.getCol(), dirToClosest);
                
                // if they're in range, start spamming bullets at them
                Occupant occ = getOccupantInDir(b, p.getRow(), p.getCol(), p.getDirection());
                
                // player must be at least 2 units away from them to shoot them
                if (p.canShoot() || closestDist >= 2) {
                    int closestToBaseIndex = 0;
                    int closestToBaseDist = 999;
                    for (int i=0; i<3; i++) {
                        if (enemies[i] == null) continue;
                        int dist = Direction.moveDistance(baseRow, baseCol, enemies[i].getRow(), enemies[i].getCol());
                        if (closestToBaseDist > dist) {
                            closestToBaseDist = dist;
                            closestToBaseIndex = i;
                        }
                    }
                    
                    // if the enemy is INSIDE the base, you need to be absolutely certain you're hitting the enemy
                    if (closestToBaseDist <= baseLimit) {
                        if (occ instanceof Player && occ.getTeam() != p.getTeam()) return new Action("S");
                        return new Action("M", 45*((int)(Math.random() * 8)));
                    } else {
                        // don't shoot teammate
                        if (occ instanceof Player && occ.getTeam() == p.getTeam()) return new Action("M", 45*((int)(Math.random() * 8)));
                        return new Action("S");
                    }
                } else {
                    if (b.isEmpty(nextSpace[0], nextSpace[1])) {
                        return new Action("M", dirToClosest);
                    } else {
                        return new Action("M", 45*((int)(Math.random() * 8)));
                    }
                }
            } else {
                // if the enemy is far away, just move randomly
                return new Action("M", 45*((int)(Math.random()*8)));
            }
        } else {
            // we've either died, or moved outside base
            // run back to base
            if (distToBase <= innerStrayLimit) {
                campingBase = true;
                return new Action("P");
            } else {
                int[] nextSpace = Direction.getLocInDirection(p.getRow(), p.getCol(), dirToBase);
                if (b.isEmpty(nextSpace[0], nextSpace[1])) {
                    return new Action("M", dirToBase);
                } else {
                    return new Action("M", 45*((int)(Math.random() * 8)));
                }
            }
        }
    }
    
    public Occupant getOccupantInDir(Board b, int startRow, int startCol, int dir) {
        // get first 
        int[] nextSpace = Direction.getLocInDirection(startRow, startCol, dir);
        int row = nextSpace[0],
            col = nextSpace[1];
        
        while (b.isValid(row, col)) {
            if (!b.isEmpty(row, col)) return b.get(row, col);
            
            nextSpace = Direction.getLocInDirection(row, col, dir);
            row = nextSpace[0];
            col = nextSpace[1];
        }
        
        return null;
    }
}
