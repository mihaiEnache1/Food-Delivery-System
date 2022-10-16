package businessLayer;

import presentationLayer.Observer;

public abstract class Observable {
    public abstract void register(Observer observer);
    public abstract void unregister(Observer observer);
    public abstract void notifyObservers();
}
