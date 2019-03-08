package main.java;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;
import main.java.business.CustomerServiceIntentHandler;
import main.java.business.MyNameIsIntentHandler;
import main.java.business.RemindMeIntentHandler;
import main.java.handler.core.*;
import main.java.handler.core.event.MyReminderDeletedEventHandler;
import main.java.handler.core.event.ReminderStartEventHandler;

public class FblStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {
        return Skills.standard()
                .addRequestHandlers(
                        new LaunchRequestHandler(),
                        new MyNameIsIntentHandler(),
                        new CustomerServiceIntentHandler(),
                        new ReminderStartEventHandler(),
                        new RemindMeIntentHandler(),
                        new MyReminderDeletedEventHandler(),
                        new CancelandStopIntentHandler(),
                        new SessionEndedRequestHandler(),
                        new HelpIntentHandler(),

                        new FallbackIntentHandler())

                .build();
    }

    public FblStreamHandler() {
        super(getSkill());
    }

}