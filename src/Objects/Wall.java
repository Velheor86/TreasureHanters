package Objects;

import Abstracts.AbstractGameObject;
import enums.GameObjectType;
import interfaces.object.StaticObject;

/**
 * Created by Admin on 27.01.2016.
 */
public class Wall extends AbstractGameObject implements StaticObject {

    public Wall(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setType(GameObjectType.WALL);
        super.setIcon(getImageIcon("../res/wall.png"));
    }
}
