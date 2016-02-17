package enums;

import Objects.Treashure;

/**
 * Created by Admin on 11.02.2016.
 */
public enum TreashureType {
    GOLD(5),
    SILVER(3),
    Cooper(1);

    TreashureType(int equil){
        this.equil = equil;
    }

    public int getEquil() {
        return equil;
    }

    int equil;
}
