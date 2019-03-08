package main.java.handler.core.comm;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import java.util.Optional;
import static com.amazon.ask.request.Predicates.intentName;

public class WalkieTalkieIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(intentName("WalkieTalkieIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        System.out.println("Starting Walkie Talkie intent ");
        //Event event = Event.builder()
        // Header header = Header.builder().withRequestId();
        return Optional.empty();
    }
}
