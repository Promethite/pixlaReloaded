package MapaObjektu;

import Svet.Blok;

/**
 *
 * @author rasic
 */
public class ManagerDatObjektu {
    
    List<List> mapaX;
    IIterator<List> iterator;
    
    public ManagerDatObjektu() {
        this.mapaX = new List(); //list listu Y souradnic
        this.iterator = this.mapaX.vytvorIterator();
    }
    
    public void vlozBlok(Blok blok, int x, int y, int vrstva) {
        int px = x<0 ? -1 : 1; //znamenko souradnice x
        int py = x<0 ? -1 : 1; //znamenko souradnice y
        
        List<List> mapaY = findList(mapaX, x);  //list listu Z souradnic
        List<Blok> mapaZ = findList(mapaY, y);  //list vrstev (Z souradnic / vrstva)
        IIterator pristupBloku = mapaZ.vytvorIterator();
        
        //Dopsat vyhledani spravneho Bloku
        //v Iteratoru "pristupBloku" a ulozit
        //do nej Blok blok.
        
        
    }
    
    private List findList(List<List> list, int souradnice) {
        List<List> vystup;
        if(souradnice < 0) {
            if(list.getZapornych() < -souradnice) {
                while(list.getZapornych() < -souradnice+1) {
                    list.vlozPrvni(null);
                }
                list.vlozPrvni(vystup = new List());
            }else if(list.zpristupniPrvni() == null){
                list.odeberPrvni();
                list.vlozPrvni(vystup = new List());
            }else {
                vystup = list.zpristupniPrvni(); //upravit
            }
        }else {
            if(list.getKladnych() < souradnice) {
                while(list.getKladnych() < souradnice-1) {
                    list.vlozPosledni(null);
                }
                list.vlozPosledni(vystup = new List());
            }else if(list.zpristupniPosledni()== null){
                list.odeberPosledni();
                list.vlozPosledni(vystup = new List());
            }else {
                vystup = list.zpristupniPosledni(); //upravit
            }
        }
        return vystup;
    }
    
    
}
