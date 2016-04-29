package MapaObjektu;

/**
 *
 * @author bleha
 */
public class List<T> {

    private Prvek<T> nulty;
    private Prvek<T> prvni;
    private Prvek<T> posledni;

    //private int pocet;
    private int kladnych;
    private int zapornych;

    public void zrus() {
        nulty = null;
        prvni = null;
        posledni = null;
        kladnych = 0;
        zapornych = 0;
    }

    public int getPocet() {
        return jePrazdny() ? 0 : kladnych + zapornych + 1;
    }
    
    public int getKladnych() {
        return kladnych;
    }
    
    public int getZapornych() {
        return zapornych;
    }

    public boolean jePrazdny() {
        return (nulty == null);
    }

    /*public boolean obsahuje(T obj) {
     boolean obsahuje = false;
     IIterator<T> iter = vytvorIterator();
     while (iter.hasNext()){
     if (iter.getNext() == obj){
     obsahuje = true;
     }
     }
     return obsahuje;
     }*/
    private void prvniVlozeni(T obj) {
        nulty = new Prvek(obj, null, null);
        prvni = nulty;
        posledni = nulty;
    }

    public void vlozPrvni(T obj) {
        if (jePrazdny()) {
            prvniVlozeni(obj);
        } else {
            Prvek pom = new Prvek(obj, null, prvni);
            zapornych++;
            prvni.predchozi = pom;
            prvni = pom;
        }
    }

    public void vlozPosledni(T obj) {
        if (jePrazdny()) {
            prvniVlozeni(obj);
        } else {
            Prvek pom = new Prvek(obj, posledni, null);
            kladnych++;
            posledni.nasledujici = pom;
            posledni = pom;
        }
    }

    public T zpristupniPrvni() {
        if (prvni != null) {
            return prvni.data;
        }
        return null;
    }

    public T zpristupniPosledni() {
        if (posledni != null) {
            return posledni.data;
        }
        return null;
    }

    public T odeberPrvni() {
        Prvek<T> smazany = prvni;
        if (jePrazdny()) {
            return null;
        }
        if (prvni == posledni) {
            zrus();
            return smazany.data;
        } else {
            prvni = prvni.nasledujici;
            zapornych--;
            return smazany.data;
        }
    }

    public T odeberPosledni() {
        Prvek<T> smazany = posledni;
        if (jePrazdny()) {
            return null;
        }
        if (prvni == posledni) {
            zrus();
            return smazany.data;
        } else {
            posledni = posledni.predchozi;
            kladnych--;
            return smazany.data;
        }
    }

    public IIterator<T> vytvorIterator() {
        return new Iterator();
    }

    private class Prvek<T> {

        T data;

        Prvek<T> predchozi;
        Prvek<T> nasledujici;

        public Prvek(T data, Prvek<T> predchozi, Prvek<T> nasledujici) {
            this.data = data;
            this.predchozi = predchozi;
            this.nasledujici = nasledujici;
        }
    }

    public class Iterator implements IIterator<T> {

        Prvek<T> aktualni;
        private int index = 0;

        @Override
        public void vynulujIterator() {
            aktualni = null;
            index = 0;
        }

        @Override
        public int getIndex() {
            return index;
        }

        @Override
        public boolean hasNext() {
            return aktualni.nasledujici != null;
        }

        @Override
        public boolean hasPrev() {
            return aktualni.predchozi != null;
        }

        @Override
        public T getNext() {
            if (hasNext() == false) {
                return null;
            }
            if (aktualni == null) {
                aktualni = prvni;
                return prvni.data;
            }

            index++;
            aktualni = aktualni.nasledujici;
            return aktualni.data;
        }

        @Override
        public T getPrev() {
            if (hasPrev() == false) {
                return null;
            }
            if (aktualni == null) {
                aktualni = prvni;
                return prvni.data;
            }

            index--;
            aktualni = aktualni.predchozi;
            return aktualni.data;
        }

        @Override
        public T zpristupniAktualni() {
            if (aktualni != null) {
                return aktualni.data;
            }
            return null;
        }

        @Override
        public T zpristupniNasledujici() {
            if (aktualni != null) {
                return aktualni.nasledujici.data;
            }
            return null;
        }

        @Override
        public T zpristupniPredchozi() {
            if (aktualni != null) {
                return aktualni.predchozi.data;
            }
            return null;
        }

        @Override
        public void prepisAktualni(T box) {
            if (aktualni != null) {
                aktualni.data = box;
            }
        }

    }

}
