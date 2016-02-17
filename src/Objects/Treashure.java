package Objects;

import Abstracts.AbstractGameObject;
import enums.GameObjectType;
import interfaces.object.StaticObject;

import java.util.Random;

/**
 * Created by Admin on 27.01.2016.
 */
public class Treashure extends AbstractGameObject implements StaticObject {

    public Treashure(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setType(GameObjectType.TREASURE);
        super.setIcon(getImageIcon("../res/treashure.png"));
    }

    Random random = new Random();

    private int exp = random.nextInt(5);


    public int getExp() {
        return exp;
    }


}
