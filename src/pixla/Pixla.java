package pixla;

import javax.swing.JFrame;

/**
 *
 * @author Pyroman & rasic
 */
public class Pixla {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        JFrame okno = new JFrame("Pixla");
        okno.setContentPane(new HerniPanel());        
        okno.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        okno.setResizable(false);
        okno.pack();
        okno.setLocationRelativeTo(null);
        okno.setVisible(true);
        
    }
    
}
