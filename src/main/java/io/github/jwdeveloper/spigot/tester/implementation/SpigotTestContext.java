/*
 * MIT License
 *
 * Copyright (c)  2023. jwdeveloper
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.jwdeveloper.spigot.tester.implementation;

import io.github.jwdeveloper.spigot.tester.api.TestContext;
import io.github.jwdeveloper.spigot.tester.api.assertions.Assertions;
import io.github.jwdeveloper.spigot.tester.api.players.PlayerFactory;
import io.github.jwdeveloper.spigot.tester.implementation.players.FakePlayerFactoryImpl;
import org.bukkit.event.Event;
import org.bukkit.plugin.Plugin;

import java.util.List;
import java.util.function.Function;

public class SpigotTestContext implements TestContext {

    private final Plugin plugin;
    private final FakePlayerFactoryImpl playerFactory;
    private final Function<Class<?>, Object> parameterProvider;
    private final SpigotEventCollector spigotEventCollector;

    public SpigotTestContext(Plugin plugin,
                             FakePlayerFactoryImpl playerFactory,
                             Function<Class<?>, Object> parameterProvider,
                             SpigotEventCollector spigotEventCollector) {
        this.plugin = plugin;
        this.playerFactory = playerFactory;
        this.parameterProvider = parameterProvider;
        this.spigotEventCollector = spigotEventCollector;
    }

    public <T> T getParameter(Class<T> tClass) {
        return (T) parameterProvider.apply(tClass);
    }

    @Override
    public List<Event> getInvokedEvents() {
        return spigotEventCollector.getEvents();
    }

    @Override
    public PlayerFactory getPlayerContext() {
        return playerFactory;
    }

    @Override
    public Assertions assertions(Object target) {
        return new Assertions(target);
    }

    @Override
    public Plugin plugin() {
        return plugin;
    }


    public void start() {
        spigotEventCollector.startCollectingEvents();
    }

    public void stop() {
        playerFactory.clear();
        spigotEventCollector.stopCollectingEvents();
    }
}
