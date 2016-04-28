package StavHry;

import TileMap.Background;
import TileMap.TileMap;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author rasic
 */
public class Vesmir extends HerniStav {

    private TileMap tileMap;
    private Background bg;
    
    public Vesmir(ManagerStavuHry gsm) {
        this.gsm = gsm;
    }

    @Override
    synchronized public void init() {
        tileMap = new TileMap(8);
        tileMap.loadTiles("/Backgrounds/grass2.png");
        tileMap.loadMap("/Maps/level1-1.map");
        tileMap.setPosition(0, 0);
        
        bg = new Background("/Backgrounds/background.png", 1);
        bg.setVector(0.5, 0);
    }

    @Override
    synchronized public void update() {
        
        // update player
        /*player.update();
        tileMap.setPosition(
                GamePanel.WIDTH / 2 - player.getX(),
                GamePanel.HEIGHT / 2 - player.getY()
        );*/
        bg.update();
        
    }

    @Override
    synchronized public void draw(Graphics2D g) {
        // draw background
        bg.draw(g);
        
        // draw tilemap
        tileMap.draw(g);
        
        // draw player
        //player.draw(g);
    }

    @Override
    public void keyPressed(int k) {
            /*if(k == KeyEvent.VK_LEFT) player.setLeft(true);
            if(k == KeyEvent.VK_RIGHT) player.setRight(true);
            if(k == KeyEvent.VK_UP) player.setUp(true);
            if(k == KeyEvent.VK_DOWN) player.setDown(true);
            if(k == KeyEvent.VK_W) player.setJumping(true);
            if(k == KeyEvent.VK_E) player.setGliding(true);
            if(k == KeyEvent.VK_R) player.setScratching();
            if(k == KeyEvent.VK_F) player.setFiring();*/
	}
	
    @Override
	public void keyReleased(int k) {
            /*if(k == KeyEvent.VK_LEFT) player.setLeft(false);
            if(k == KeyEvent.VK_RIGHT) player.setRight(false);
            if(k == KeyEvent.VK_UP) player.setUp(false);
            if(k == KeyEvent.VK_DOWN) player.setDown(false);
            if(k == KeyEvent.VK_W) player.setJumping(false);
            if(k == KeyEvent.VK_E) player.setGliding(false);*/
	}
    
}
