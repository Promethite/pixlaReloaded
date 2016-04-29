package StavHry;

import Svet.Objekt;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import pixla.HerniPanel;

/**
 *
 * @author rasic
 */
public class EditaceObjektu extends HerniStav{
    
    private ManagerStavuHry gsm;
    private Objekt objekt;
    
    private final int tileSize;
    
    private final int rows;
    private final int cols;
    
    private final int ox;
    private final int oy;
    

    public EditaceObjektu(ManagerStavuHry gsm) {
        this.gsm = gsm;
        
        tileSize = 35;
        rows = HerniPanel.HEIGHT / (tileSize+2);
        cols = HerniPanel.WIDTH / (tileSize+2);
        ox = (HerniPanel.WIDTH - cols * tileSize) / 2;
        oy = (HerniPanel.HEIGHT - rows * tileSize) / 2;
        
        //System.out.println("cols:rows - "+cols+":"+rows);
        //System.out.println(ox+" - "+oy);
        
    }
    
    public void loadObject(String s) {
        
    }
    
    @Override
    public void init() {
        loadObject("/ship.xml");
    }

    @Override
    public void update() {
        
    }

    @Override
    public void draw(Graphics2D g) {
        
        // draw background
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, HerniPanel.WIDTH, HerniPanel.HEIGHT);
        
        // draw object
        //objekt.draw(g);
        
        // draw grid        
        g.setPaint(Color.WHITE);
        for (int x = 0; x <= HerniPanel.WIDTH/tileSize; x++) {
            int pos = x*tileSize;
            g.drawLine(pos+ox, oy, pos+ox, HerniPanel.HEIGHT-oy);
        }
        
        for (int y = 0; y <= HerniPanel.HEIGHT/tileSize; y++) {
            int pos = y*tileSize;
            g.drawLine(ox, pos+oy, HerniPanel.WIDTH-ox, pos+oy);
        }
        
    }

    @Override
    public void keyPressed(int k) {
        if (k == KeyEvent.VK_ESCAPE) gsm.setState(ManagerStavuHry.MENUSTATE);
    }

    @Override
    public void keyReleased(int k) {
        
    }
    
}
