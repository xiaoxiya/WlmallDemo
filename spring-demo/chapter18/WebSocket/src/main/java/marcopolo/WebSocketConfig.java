package marcopolo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author luopeng
 * @date 2019/12/2 21:48
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry webSocketHandlerRegistry) {
        //将MarcoHandler映射到"/marco"
        webSocketHandlerRegistry.addHandler(marcoHandler(), "/marco").withSockJS();
    }

    /**
     * 声明MarcoHandler bean（java注入spring）
     */
    @Bean
    public MarcoHandler marcoHandler() {
        return new MarcoHandler();
    }
}
