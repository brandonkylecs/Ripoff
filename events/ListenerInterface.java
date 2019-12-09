package events;

/**
 * A simple register listener interface.
 * @author Ike Quigley and a slight adjustment by Tyler Wallschleger
 */
public interface ListenerInterface {

    public void messageReceived(RipoffEvent _event);

}
