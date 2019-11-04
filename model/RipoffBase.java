package model;
/**
 * This is the base class for any object that will throw or catch events being
 * fired.
 * @author Tyler Wallschleger
 */

import java.util.ArrayList;
import java.util.List;
import events.RipoffEvent;
import events.ListenerInterface;


public class RipoffBase implements ListenerInterface {

    private final List listeners = new ArrayList();

   /**
    * Register a listener to be called upon when an event is fired.
    * @param listener the object that is called upon.
    */
    public synchronized void addListener(ListenerInterface listener) {
        listeners.add(listener);
    }

   /**
    * Unregister an event from being called upon.
    * @param listener the object to unregister.
    */
    public synchronized void removeListener(ListenerInterface listener) {
        listeners.remove(listener);
    }

   /**
    * When an event is fired, this method iterates through the events and fires off
    * their messageReceived method. We translate the listener array to an object array
    * while iterating in order to avoid Concurrent Access errors.
    * @param event - the event that caused this to be fired.
    */
    protected synchronized void fireEvent(RipoffEvent event) {
        // Clone the active listeners.
        Object[] temp_list = this.listeners.toArray();
        for (Object temp_list1 : temp_list) {
            ListenerInterface temp_obj = (ListenerInterface) temp_list1;
            temp_obj.messageReceived(event);
        }
    }

    @Override
    public void messageReceived(RipoffEvent event) {
        System.out.println("Message Received has not been implemented for this class");
    }

}
