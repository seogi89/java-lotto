package com.seok2.lotto.domain;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Rank {

    FIRST(6, Money.of(2_000_000_000)),
    SECOND(5, Money.of(1_500_000)),
    THIRD(4, Money.of(50_000)),
    FOURTH(3, Money.of(5_000)),
    MISS(0, Money.of(0));

    private static final String TO_STRING_PATTERN = "{0} 개 일치 ({1})";
    private static final Map<Integer, Rank> BY_MATCHES;

    private final int matches;
    private final Money reward;

    static {
        BY_MATCHES = Arrays.stream(values()).collect(Collectors.toMap(r -> r.matches, Function.identity()));
    }

    Rank(int matches, Money reward) {
        this.matches = matches;
        this.reward = reward;
    }

    public static Rank ofMatches(int matches) {
        return Optional.ofNullable(BY_MATCHES.get(matches)).orElse(Rank.MISS);
    }

    public Money getReward() {
        return this.reward;
    }

    @Override
    public String toString() {
        return MessageFormat.format(TO_STRING_PATTERN, this.matches, this.reward);
    }

}
