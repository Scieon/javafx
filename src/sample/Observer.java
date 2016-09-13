package sample;


public interface Observer {

    void update(int selector);
    void detachSubject(Subject subject);
}
