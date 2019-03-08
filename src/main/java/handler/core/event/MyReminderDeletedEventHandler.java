package main.java.handler.core.event;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.impl.ReminderDeletedEventRequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.model.services.reminderManagement.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Optional;

public class MyReminderDeletedEventHandler implements ReminderDeletedEventRequestHandler {

    @Override
    public boolean canHandle(HandlerInput handlerInput, ReminderDeletedEventRequest reminderDeletedEventRequest) {
        return true;
    }

    @Override
    public Optional<Response> handle(HandlerInput handlerInput, ReminderDeletedEventRequest reminderDeletedEventRequest) {
        System.out.println("----------Reminder has been deleted-------------");
        String locale = handlerInput.getRequestEnvelope().getRequest().getLocale();
        //createReminder(handlerInput,locale,"We have a customer in the lobby. Please attend.");
        return Optional.empty();
    }
    private void createReminder(HandlerInput input, String locale, String reminderLabel) {

        System.out.println("create Another Reminder : "+reminderLabel);
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
                .withInterval(20)
                .build();

        Trigger trigger = Trigger.builder()
                .withType(TriggerType.SCHEDULED_RELATIVE)
                .withOffsetInSeconds(30)
                .withRecurrence(recurrence)
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
