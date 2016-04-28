package TileMap;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import pixla.HerniPanel;

/**
 *
 * @author Ondřej Bleha
 */
public class Background {
    
    private BufferedImage image;
    private BufferedImage image2;
    
    private double x;
    private double y;
    private double dx;
    private double dy;
    
    private double moveScale;
    
    public Background(String file, double moveScale) {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/Resources" + file));
            image2 = ImageIO.read(getClass().getResourceAsStream("/Resources/Backgrounds/background2.png"));
            this.moveScale = moveScale;
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public void setPosition(double x, double y){
        this.x = (x*moveScale) % HerniPanel.WIDTH;
        this.y = (y*moveScale) % HerniPanel.HEIGHT;
    }
    
    public void setVector(double dx, double dy){
        this.dx = dx;
        this.dy = dy;
    }
    
    public void update(){
        setPosition(x+dx, y+dy);
    }
    
    public void draw(Graphics2D g){
        g.drawImage(image, (int)x, (int)y, null);
        if (x < 0) {
            g.drawImage(image, (int)x + HerniPanel.WIDTH, (int)y, null);
        }
        if (x > 0){
            g.drawImage(image, (int)x - HerniPanel.WIDTH, (int)y, null);
        }
        
        if (y < 0) {
            g.drawImage(image, (int)x, (int)y + HerniPanel.HEIGHT, null);
            g.drawImage(image, (int)x - HerniPanel.WIDTH, (int)y + HerniPanel.HEIGHT, null);
        }
        if (y > 0){
            g.drawImage(image, (int)x, (int)y - HerniPanel.HEIGHT, null);
            g.drawImage(image, (int)x + HerniPanel.WIDTH, (int)y - HerniPanel.HEIGHT, null);
        }
    }
    
    
}
