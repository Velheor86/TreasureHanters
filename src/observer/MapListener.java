package observer;

import interfaces.map.GameCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 18.02.2016.
 */
public abstract class MapListener implements GameCollection {
    private ArrayList<MoveListener> listeners = new ArrayList<>();

    @Override
    public List<MoveListener> getListener(){
        return listeners;
    }

    @Override
    public void addListener(MoveListener listener){
        listeners.add(listener);
    }
    @Override
    public void removeListener(MoveListener listener){
        listeners.remove(listener);
    }
    @Override
    public void removeAll(){
        listeners.clear();
    }




}
