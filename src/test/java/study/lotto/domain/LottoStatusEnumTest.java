package study.lotto.domain;


import org.junit.jupiter.api.Test;
import study.lotto.util.LottoErrorMessage;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoStatusEnumTest {

    private static LottoStatusEnum enumTest;

    @Test
    void 제대로_COUNT가_증가했는지() {
        LottoStatusEnum enumTest = LottoStatusEnum.findByCount(4);
        enumTest.addWinningCount();
        assertThat(enumTest.getWinningCount()).isEqualTo(1);
    }

    @Test
    void 제대로_RANK를_입력했는지() {
        assertThatThrownBy(() ->
                enumTest = LottoStatusEnum.findByCount(1000)
        ).isInstanceOf(RuntimeException.class)
                .withFailMessage(LottoErrorMessage.getLottoRankException());
    }
}
