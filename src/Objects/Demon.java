package Objects;
import Abstracts.AbstractGameObject;
import Abstracts.AbstractMoveObject;
import enums.GameObjectType;
import enums.MoveAction;
import enums.MovingDirect;
import interfaces.object.MoveObject;

public class Demon extends AbstractMoveObject {

    public Demon(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setType(GameObjectType.MONSTER);
        super.changeIcon(MovingDirect.UP,GameObjectType.MONSTER);
    }





    public void Kill(){

    }

    @Override
    public MoveAction move(AbstractGameObject obj) {
        MoveAction x = null;
        if (obj == null){
            return MoveAction.STAY;
        }
        switch (obj.getType()){
            case HEROE:{
                x = MoveAction.DIE;
                break;
            }
            case NOTHING:{
                x = MoveAction.MOVING;
                break;
            }
            default:x = MoveAction.STAY;
        }
        return x;
    }

}
