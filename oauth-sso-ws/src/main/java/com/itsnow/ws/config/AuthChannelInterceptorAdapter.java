package com.itsnow.ws.config;

import com.itsnow.ws.service.WebSocketAuthenticatorService;
import org.apache.commons.lang.StringUtils;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptorAdapter;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.DefaultCsrfToken;

import java.util.Collections;
import java.util.Map;

/**
 * Created by Xuekun_Li on 2018/8/22.
 */
public class AuthChannelInterceptorAdapter extends ChannelInterceptorAdapter {

    private static final String USERNAME_HEADER = "login";
    private static final String PASSWORD_HEADER = "passcode";
    private final WebSocketAuthenticatorService webSocketAuthenticatorService;

    public AuthChannelInterceptorAdapter(final WebSocketAuthenticatorService webSocketAuthenticatorService) {
        this.webSocketAuthenticatorService = webSocketAuthenticatorService;
    }

    @Override
    public Message<?> preSend(final Message<?> message, final MessageChannel channel) throws AuthenticationException {
        final StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (StompCommand.CONNECT == accessor.getCommand()) {
            final String username = accessor.getFirstNativeHeader(USERNAME_HEADER);
            final String password = accessor.getFirstNativeHeader(PASSWORD_HEADER);

            //final UsernamePasswordAuthenticationToken user = webSocketAuthenticatorService.getAuthenticatedOrFail(username, password);
            UsernamePasswordAuthenticationToken user = new UsernamePasswordAuthenticationToken(
                    "admin",
                    null,
                    Collections.singleton((GrantedAuthority) () -> "USER"));
            accessor.setUser(user);

//            String jwtToken = accessor.getFirstNativeHeader("Auth-Token");
//
//            if (StringUtils.isNotEmpty(jwtToken)) {
//                Map sessionAttributes = SimpMessageHeaderAccessor.getSessionAttributes(message.getHeaders());
//                sessionAttributes.put(CsrfToken.class.getName(), new DefaultCsrfToken("Auth-Token", "Auth-Token", jwtToken));
//                UserAuthenticationToken authToken = tokenService.retrieveUserAuthToken(jwtToken);
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//                accessor.setUser(authToken);
//            }
        }
        return message;
    }
}
