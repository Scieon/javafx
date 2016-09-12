package sample;


public interface Subject {

    void attach(Observer observer);

    void notifyAllObservers();
}
