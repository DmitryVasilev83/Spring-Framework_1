package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class ConsoleMessageRender implements MessageRender {

    @Override
    public void render() {
        System.out.println(getMessageProvider().getMessage());
    }

    @Override
    @Lookup
    public MessageProvider getMessageProvider() {

        return null;
    }
}
