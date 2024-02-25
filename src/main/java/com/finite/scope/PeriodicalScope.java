package com.finite.scope;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;

public class PeriodicalScope implements Scope {

    private final Map<String, PeriodicalObject> map = new HashMap<>();

    @Override
    public Object get(String name, ObjectFactory<?> objectFactory) {
        PeriodicalObject periodicalObject = map.get(name);
        if (periodicalObject != null) {
            if (OffsetDateTime.now().isAfter(periodicalObject.creationDateTime().plusSeconds(1))) {
                map.put(name, new PeriodicalObject(OffsetDateTime.now(), objectFactory.getObject()));
            }
        } else {
            map.put(name, new PeriodicalObject(OffsetDateTime.now(), objectFactory.getObject()));
        }
        return map.get(name).object();
    }

    @Override
    public Object remove(String name) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String name, Runnable callback) {

    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
