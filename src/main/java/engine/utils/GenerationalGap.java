package engine.utils;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class GenerationalGap {
    private final List<Character> from;
    private final List<Character> to;

    public double calculateGenerationalGap() {
        List<Character> remaining = to
                .parallelStream()
                .filter(from::contains)
                .collect(Collectors.toList());
        return (double) remaining.size() / from.size();
    }
}
