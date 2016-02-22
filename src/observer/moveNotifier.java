package observer;

import Objects.Heroe;
import enums.MoveAction;

import java.util.List;


public interface MoveNotifier {
    List<MoveListener> getListener();
    void addListener(MoveListener listeners);
    void removeListener(MoveListener listener);
    void removeAll();
    void notifyListener(MoveAction action, Heroe heroe);

}
