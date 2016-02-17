package interfaces.object;

import Abstracts.AbstractGameObject;
import enums.MoveAction;
import enums.MovingDirect;

/**
 * Created by Admin on 25.01.2016.
 */
public interface MoveObject extends StaticObject {

    MoveAction move(AbstractGameObject obj);

}
