package spittr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author luopeng
 * @date 2019/12/3 23:12
 */
@Component
public class SpittleFeedServiceImpl implements SpittleFeedService {

    private SimpMessagingTemplate messaging;
    private Pattern pattern = Pattern.compile("\\@(\\S+)");

    @Autowired
    public SpittleFeedServiceImpl(SimpMessagingTemplate messaging) {
        this.messaging = messaging;
    }

    @Override
    public void broadcastSpittle(Spittle spittle) {
        messaging.convertAndSend("/topic/spittlefeed", spittle);

        Matcher matcher = pattern.matcher(spittle.getMessage());
        if (matcher.find()) {
            String username = matcher.group(1);
            messaging.convertAndSendToUser(username, "/queue/notifications",
                    new Notification("You just got mentioned!"));
        }
    }
}
