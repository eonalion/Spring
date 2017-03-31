package com.epam.suboch.command;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.shell.plugin.support.DefaultBannerProvider;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CustomBannerProvider extends DefaultBannerProvider {
    @Override
    public String getBanner() {
        StringBuilder builder = new StringBuilder();
        builder.append("Version: ").append(this.getVersion());
        return builder.toString();
    }

    public String getVersion() {
        return "1.2.0.RELEASE";
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to Movie Theatre CLI";
    }

    @Override
    public String getProviderName() {
        return "Custom banner provider";
    }
}
