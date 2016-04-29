package MapaObjektu;

/**
 *
 * @author rasic
 * @param <T>
 */
public interface IIterator<T> {
    
    void vynulujIterator();
    
    int getIndex();
    
    boolean hasNext();
    
    boolean hasPrev();
    
    T getNext();
    
    T getPrev();
    
    T zpristupniAktualni();
    
    T zpristupniNasledujici();
    
    T zpristupniPredchozi();
    
    void prepisAktualni(T box);    
    
}
