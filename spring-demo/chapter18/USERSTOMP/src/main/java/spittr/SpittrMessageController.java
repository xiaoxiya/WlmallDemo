package spittr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.annotation.SendToUser;
import org.springframework.stereotype.Controller;

import java.security.Principal;
import java.util.Date;

/**
 * @author luopeng
 * @date 2019/12/3 23:16
 */
@Controller
public class SpittrMessageController {

    private SpittleRepository spittleRepository;

    private SpittleFeedService feedService;

    @Autowired
    public SpittrMessageController(SpittleRepository spittleRepository, SpittleFeedService feedService) {
        this.spittleRepository = spittleRepository;
        this.feedService = feedService;
    }

    @MessageMapping("/spittle")
    @SendToUser("queue/notifications")
    public Notification handleSpittle(Principal principal, SpittleForm form) {
        Spittle spittle = new Spittle(principal.getName(), form.getText(), new Date());
        spittleRepository.save(spittle);
        feedService.broadcastSpittle(spittle);
        return new Notification("Saved Spittle for user: " + principal.getName());
    }
}
