package Objects;

import Abstracts.AbstractGameObject;
import enums.GameObjectType;


public class Exit extends AbstractGameObject {


    public  Exit(Coordinate coordinate) {
        super.setType(GameObjectType.EXIT);
        super.setIcon(getImageIcon("../res/exit.png"));
        super.setCoordinate(coordinate);
    }

}
