package pixla;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import StavHry.ManagerStavuHry;

/**
 *
 * @author rasic
 */
public class HerniPanel extends Container implements Runnable, KeyListener {

    // rozmery
    public static final int WIDTH = 320;
    public static final int HEIGHT = 240;
    public static final int SCALE = 2;
    
    // herni vlakno
    private Thread vlakno;
    private boolean bezi;
    private int FPS = 60;
    private long cilovyCas = 1000 / FPS;
    
    // obraz
    private BufferedImage obraz;
    private Graphics2D g;
    
    // game state manager
    private ManagerStavuHry gsm;
    
    
    public HerniPanel() {
        super();
        setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
        setFocusable(true);
        requestFocus();
    }
    
    @Override
    public void addNotify() {
        super.addNotify();
        if(vlakno == null){
            vlakno = new Thread(this);
            addKeyListener(this);
            vlakno.start();
        }
    }
    
    private void init() {
        obraz = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
        g = (Graphics2D) obraz.getGraphics(); //mozna bude potrebovat upravit
        bezi = true;
        gsm = new ManagerStavuHry();
    }

    @Override
    public void run() {
        init();
        
        long start;
        long elapsed;
        long wait;
        
        // herni smycka
        while(bezi){
            start = System.nanoTime();
            
            update();
            draw();
            drawToScreen();
            
            elapsed = System.nanoTime() - start;
            wait = cilovyCas - elapsed / 1000000;
            
            if(wait < 0) wait = 5;
            
            try{
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }            
        }
    }
    
    private void update() {
        gsm.update();
    }
    private void draw() {
        gsm.draw(g);
    }
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(obraz, 0, 0, WIDTH*SCALE, HEIGHT*SCALE, null);
        g2.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        gsm.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        gsm.keyReleased(e.getKeyCode());
    }
    
}
