package Objects;

import Abstracts.AbstractGameObject;
import enums.GameObjectType;

/**
 * Created by Admin on 27.01.2016.
 */
public class Nothing extends AbstractGameObject {


    public Nothing(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setType(GameObjectType.NOTHING);
        super.setIcon(null);
    }
}
