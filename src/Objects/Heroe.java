package Objects;

import Abstracts.AbstractGameObject;
import Abstracts.AbstractMoveObject;
import enums.GameObjectType;
import enums.MoveAction;
import enums.MovingDirect;

/**
 * Created by Admin on 27.01.2016.
 */
public class Heroe extends AbstractMoveObject {

    public Heroe(Coordinate coordinate) {
        super.setCoordinate(coordinate);
        super.setType(GameObjectType.HEROE);
        changeIcon(MovingDirect.UP,GameObjectType.HEROE);
    }

    private static int tern = 0;
    private static int score = 0;


    @Override
    public MoveAction move(AbstractGameObject obj) {
            MoveAction moveResult = null;
        switch (obj.getType()){
            case NOTHING:{
                moveResult = MoveAction.MOVING;

                break;
            }
            case MONSTER:{
                moveResult = MoveAction.DIE;
                break;
            }
            case TREASURE:{
                moveResult = MoveAction.COLLECT;
                setScore(((Treashure)obj).getExp());
                break;
            }
            case EXIT:{
                moveResult = MoveAction.EXIT;
                break;
            }
            case WALL:{
                moveResult = MoveAction.STAY;
                break;
            }
            default:moveResult = MoveAction.STAY;
        }
        return moveResult;
    }




    public static int getTern() {
        return tern;
    }

    public static int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public void setTern(int tern) {
        this.tern += tern;
    }
}
