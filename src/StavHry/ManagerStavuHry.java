package StavHry;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author rasic & Pyroman
 */
public class ManagerStavuHry {

    private ArrayList<HerniStav> gameStates;
    private int currentState;
    
    public static final int MENUSTATE = 0;
    public static final int VESMIR = 1;
    
    public ManagerStavuHry(){
        gameStates = new ArrayList<>();
        
        currentState = MENUSTATE;
        gameStates.add(new HlavniMenu(this));
        gameStates.add(new Vesmir(this));
    }
    
    public void setState(int state){
        currentState = state;
        gameStates.get(currentState).init();
    }
    
    public void update(){
        gameStates.get(currentState).update();
    }
    
    public void draw(java.awt.Graphics2D g){
        gameStates.get(currentState).draw(g);
    }
    
    public void keyPressed(int k){
        gameStates.get(currentState).keyPressed(k);
    }
    
    public void keyReleased(int k){
        gameStates.get(currentState).keyReleased(k);
    }
    
}
