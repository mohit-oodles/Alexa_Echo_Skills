package main.java.handler.core.event;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.ReminderCreatedEventRequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.services.reminderManagement.ReminderCreatedEventRequest;

import java.util.Optional;

public class ReminderCreateEventHandler implements ReminderCreatedEventRequestHandler {


    @Override
    public boolean canHandle(HandlerInput handlerInput, ReminderCreatedEventRequest reminderCreatedEventRequest) {
        System.out.println("---- ReminderCreateEventHandler: Getting device Id ---- ");
        if (handlerInput.getRequestEnvelope().getContext().getSystem()!=null){
            if (handlerInput.getRequestEnvelope().getContext().getSystem().getDevice()!=null){
                System.out.println("Device Id: "+handlerInput.getRequestEnvelope().getContext().getSystem().getDevice().getDeviceId());
            }
        }
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput, ReminderCreatedEventRequest reminderCreatedEventRequest) {
        System.out.println("-------------Reminder created with deviceId: ");
        System.out.println("Device Id: "+handlerInput.getRequestEnvelope().getContext().getSystem().getDevice().getDeviceId());
        return Optional.empty();
    }
}
