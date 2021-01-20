package study.lotto.domain.numbers;

import study.lotto.util.CommonLottoCheck;

import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class LottoTicket {
    private final SortedSet<Integer> lottoTicket;

    LottoTicket(final List<Integer> lotto) {
        CommonLottoCheck.CheckNumber(lotto);
        this.lottoTicket = new TreeSet<>(lotto);
    }

    public SortedSet<Integer> getLottoTicket() {
        return Collections.unmodifiableSortedSet(lottoTicket);
    }

}
