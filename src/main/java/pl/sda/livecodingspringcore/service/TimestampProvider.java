package pl.sda.livecodingspringcore.service;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE, proxyMode = ScopedProxyMode.TARGET_CLASS)
//Scope => nie zmienia daty i godz na faktyczny czas stworzenia beana
// dopiero 'proxyMode' - timestamp będzie wstrzykiwany do BlogPostService w momencie gdy ten będzie się odwoływał do timestampprovidera
public class TimestampProvider {
    private String created;

    public TimestampProvider() {
        this.created = LocalDateTime.now().toString();
    }

    public String getCreated() {
        return created;
    }
}
