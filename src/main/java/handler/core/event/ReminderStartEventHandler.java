package main.java.handler.core.event;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.ReminderStartedEventRequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.services.reminderManagement.ReminderStartedEventRequest;
import main.java.business.MyNameIsIntentHandler;

import java.util.Optional;

public class ReminderStartEventHandler implements ReminderStartedEventRequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput, ReminderStartedEventRequest reminderStartedEventRequest) {
        System.out.println("---- ReminderStartEventHandler: Getting device Id ---- ");
        if (handlerInput.getRequestEnvelope().getContext().getSystem()!=null){
            if (handlerInput.getRequestEnvelope().getContext().getSystem().getDevice()!=null){
                System.out.println("Device Id: "+handlerInput.getRequestEnvelope().getContext().getSystem().getDevice().getDeviceId());
            }
        }
        return true;

    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput, ReminderStartedEventRequest reminderStartedEventRequest) {
        System.out.println(" -------------Reminder started with deviceId: -------------"+ MyNameIsIntentHandler.CREATOR_DEVICE_ID);
        return Optional.empty();
    }


}
