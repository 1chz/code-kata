package io.github.shirohoo.baseball.app.port.in;

public record TryCommand(String value) {
    public static TryCommand from(String value) {
        return new TryCommand(value);
    }
}
