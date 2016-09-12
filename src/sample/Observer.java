package sample;


public interface Observer {

    void update();
    void detachSubject(Subject subject);
}
