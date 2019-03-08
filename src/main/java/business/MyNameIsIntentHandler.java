package main.java.business;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.*;
import com.amazon.ask.model.services.reminderManagement.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.OffsetDateTime;
import java.util.Map;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;
import static main.java.constant.SlotConstants.SLOT_NAME;

public class MyNameIsIntentHandler implements RequestHandler {

    public static String CREATOR_DEVICE_ID = null;
    private boolean endSession = false;

    Logger log = LogManager.getLogger(MyNameIsIntentHandler.class.getName());

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("MyNameIsIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        Request request = input.getRequestEnvelope().getRequest();
        IntentRequest intentRequest = (IntentRequest) request;
        Intent intent = intentRequest.getIntent();
        Map<String, Slot> slots = intent.getSlots();

        log.debug("Handling Person Name");
        Slot personName =  slots.get(SLOT_NAME);
        String speechText, repromptText;

        if(personName != null) {
            String personNameValue = personName.getValue();
            speechText =
                    String.format("%s Thank you for the response. Please wait! Someone will be down to help you.", personNameValue);
            repromptText =
                    String.format("%s Thank you for the response. Please wait! Someone will be down to help you. reprompt", personNameValue);
            String locale = input.getRequestEnvelope().getRequest().getLocale();
            createReminder(input,locale,"We have a customer in the lobby. Please attend.");
            endSession = true;
        } else {
            // Render an error since user input is out of list of color defined in interaction model.
            speechText = "I'm not sure what your name is";
            repromptText =
                    "I'm not sure what your name is";

        }
        CREATOR_DEVICE_ID = input.getRequestEnvelope().getContext().getSystem().getDevice().getDeviceId();
        if (CREATOR_DEVICE_ID!=null){
            System.out.println("-----------------"+CREATOR_DEVICE_ID);
        }
        return input.getResponseBuilder()
                .withSimpleCard("IntroSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(endSession)
                .build();

    }

    private void createReminder(HandlerInput input, String locale, String reminderLabel) {
        System.out.println("Create Reminder : "+reminderLabel);
        SpokenText spokenText = SpokenText.builder()
                .withText(reminderLabel)
                .withLocale(locale)
                .build();

        AlertInfoSpokenInfo alertInfoSpokenInfo = AlertInfoSpokenInfo.builder()
                .addContentItem(spokenText)
                .build();

        AlertInfo alertInfo = AlertInfo.builder()
                .withSpokenInfo(alertInfoSpokenInfo)
                .build();

        Trigger trigger = Trigger.builder()
                .withType(TriggerType.SCHEDULED_RELATIVE)
                .withOffsetInSeconds(10)
//                .withRecurrence(recurrence)
                .withTimeZoneId("America/Los_Angeles")

                .build();


        System.out.println("Scheduled time: "+trigger.getScheduledTime());

        PushNotification pushNotification = PushNotification.builder()
                .withStatus(PushNotificationStatus.ENABLED)
                .build();

        System.out.println("Added Push Notification");
    Event event = Event.builder().withAlertToken("Test event for anuj").build();

        ReminderRequest reminderRequest = ReminderRequest.builder()
                .withAlertInfo(alertInfo)
                .withRequestTime(OffsetDateTime.now())
                .withTrigger(trigger)
                .withPushNotification(pushNotification)
                .build();

        System.out.println("Reminder Build "+ reminderRequest.getRequestTime());
        ReminderManagementServiceClient reminderManagementServiceClient = input.getServiceClientFactory().getReminderManagementService();


        if(reminderManagementServiceClient!=null){
            System.out.println("Reminder Client found ");
        }else {
            System.out.println("Reminder Client issue");
        }
        ReminderResponse response = reminderManagementServiceClient.createReminder(reminderRequest);

        System.out.println("Reminder Response: "+response.getStatus());
        System.out.println("Reminder created ");
    }

}
