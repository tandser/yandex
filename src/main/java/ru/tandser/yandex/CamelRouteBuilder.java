package ru.tandser.yandex;

import org.apache.camel.builder.RouteBuilder;

public class CamelRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("quartz2:timer?cron=0/10+*+*+*+*+?")
            .process("yandexXmlGenerator");
    }
}