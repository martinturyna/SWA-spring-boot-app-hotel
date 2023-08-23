package swa.hotel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class LoggingConfig {

    @Bean
    public CommonsRequestLoggingFilter requestLoggingFilter() {

        var loggingFilter = new CustomLoggingFilter();

        loggingFilter.setIncludeQueryString(true);
        loggingFilter.setIncludePayload(true);

        loggingFilter.setIncludeClientInfo(false);
        loggingFilter.setIncludeHeaders(false);

        loggingFilter.setMaxPayloadLength(64000);
        loggingFilter.setAfterMessagePrefix("Incoming request: ");

        return loggingFilter;
    }

}

class CustomLoggingFilter extends CommonsRequestLoggingFilter {

    @Override
    protected boolean shouldLog(HttpServletRequest request) {
        return this.logger.isInfoEnabled();
    }

    @Override
    protected void beforeRequest(HttpServletRequest request, String message) {
    }

    @Override
    protected void afterRequest(HttpServletRequest request, String message) {
        this.logger.info(message);
    }

}
