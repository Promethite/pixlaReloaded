package StavHry;

import TileMap.Background;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import pixla.HerniPanel;

/**
 *
 * @author bleha
 */
public class HlavniMenu extends HerniStav{
    
    private Background bg;
    
    
    private int currentChoice = 0;
    private String[] options = {
        "Start",
        "Help",
        "Quit"
    };
    
    private Color titleColor;
    private Font titleFont;
    
    private Font font;

    public HlavniMenu(ManagerStavuHry gsm) {
        this.gsm = gsm;
        
        try {
            bg = new Background("/Backgrounds/background.png", 1);
            bg.setVector(-0.5, 0.5);
            
            titleColor = new Color(128, 0, 0);
            titleFont = new Font("Liberation Serif", Font.PLAIN, 28);
            font = new Font("Liberation Serif", Font.PLAIN, 12);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init() {
        
    }

    @Override
    public void update() {
        bg.update();
    }

    @Override
    public void draw(Graphics2D g) {
        
        // draw bg
        bg.draw(g);
        
        // draw title
        g.setColor(titleColor);
        g.setFont(titleFont);
        String title = "Pixla";
        g.drawString(title, HerniPanel.WIDTH/2-title.length()*5, 70);
        
        // draw menu options
        for (int i = 0; i < options.length; i++) {
            g.setColor(currentChoice == i ? Color.WHITE : Color.RED);
            g.drawString(options[i], HerniPanel.WIDTH/2-options[i].length()*5, 140 + i*25);
        }
        
    }
    
    private void select(){
        switch(currentChoice) {
            case 0:
                gsm.setState(ManagerStavuHry.VESMIR);
            break;
            case 1:
                // help
            break;
            case 2:
                System.exit(0);
            break;
        }
    }

    @Override
    public void keyPressed(int k) {
        if(k == KeyEvent.VK_ENTER){
            select();
        }else if (k == KeyEvent.VK_UP){
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = options.length - 1;
            }
        }else if (k == KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == options.length){
                currentChoice = 0;
            }
        }
    }

    @Override
    public void keyReleased(int k) {
        
    }
    
}
