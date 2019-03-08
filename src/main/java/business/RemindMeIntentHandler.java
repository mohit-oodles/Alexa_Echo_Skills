package main.java.business;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.services.reminderManagement.*;
import org.joda.time.DateTime;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class RemindMeIntentHandler implements RequestHandler {


    @Override
    public boolean canHandle(HandlerInput input){
        return input.matches(intentName("RemindMeIntent"));


    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput) {
        System.out.println("RequestId() "+handlerInput.getRequest().getRequestId().toString());
        System.out.println("Application().getApplicationId() "+handlerInput.getRequestEnvelope().getSession().getApplication().getApplicationId());
        System.out.println("System().getApiAccessToken() "+handlerInput.getRequestEnvelope().getContext().getSystem().getApiAccessToken());
        System.out.println("System().getApiEndpoint() "+handlerInput.getRequestEnvelope().getContext().getSystem().getApiEndpoint());
        String accessToken = handlerInput
                .getRequestEnvelope()
                .getContext()
                .getSystem()
                .getUser()
                .getAccessToken();

        //getReminders(accessToken,handlerInput);

        String locale = handlerInput.getRequestEnvelope().getRequest().getLocale();
        System.out.println("RequestId: "+ handlerInput.getRequest().getRequestId().toString());
        System.out.println("Before creating reminder");
        getDeviceLocalTime();
        createReminder(handlerInput,locale,"We have a customer in the lobby. Please attend.");

        System.out.println("After creating reminder");
        String speechText =
                String.format("Reminder Has been created");
        String  repromptText =
                String.format("Reminder Has been created");


        System.out.println("Returning response");
        return handlerInput.getResponseBuilder()
                .withSimpleCard("CustomerServiceSession", speechText)
                .withSpeech(speechText)
                .withReprompt(repromptText)
                .withShouldEndSession(false)
                .build();
    }

    private void getReminders(String accessToken, HandlerInput handlerInput) {


    }

    private void getDeviceLocalTime() {

    }


    private void createReminder(HandlerInput input, String locale, String reminderLabel) {

        System.out.println("createReminder : "+reminderLabel);
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

        LocalDateTime triggerTime = LocalDateTime.now().plusMinutes(2);

        Recurrence recurrence = Recurrence.builder()
                .withFreq(RecurrenceFreq.DAILY)

                .withInterval(10)

                .build();
        System.out.println("Trigger time: "+triggerTime.getHour()+"-"+triggerTime.getMinute());

        Trigger trigger = Trigger.builder()
                .withType(TriggerType.SCHEDULED_RELATIVE)
                .withOffsetInSeconds(30)
                //.withRecurrence(recurrence)
                .withTimeZoneId("America/Los_Angeles")

                .build();

        System.out.println("Scheduled time: "+trigger.getScheduledTime());

        PushNotification pushNotification = PushNotification.builder()
                .withStatus(PushNotificationStatus.ENABLED)
                .build();

        System.out.println("Added Push Notification");


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
