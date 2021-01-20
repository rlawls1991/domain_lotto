package study.lotto.domain.numbers;




import study.lotto.util.CommonLottoCheck;
import study.lotto.util.LottoErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.SortedSet;
import java.util.stream.Collectors;

/**
 * 당첨번호 관리
 */
public class LottoWinningNumber {

    private LottoTicket winningNumbers;
    private LottoRank lottoRank;
    private int bonusNumber = 0;

    public LottoWinningNumber(String winningNumbers, int bonusNumber) {
        isNullOrEmptyCheck(winningNumbers);
        CommonLottoCheck.checkLowStandardNumber(bonusNumber);

        this.bonusNumber = bonusNumber;
        this.winningNumbers = new LottoTicket(initLottoWinningNumber(winningNumbers, bonusNumber));
        this.lottoRank = new LottoRank(this.bonusNumber, this.winningNumbers);
    }

    public List<Integer> initLottoWinningNumber(String winningNumbers, int bonusNumber) {
        List<Integer> winningNumberList = new ArrayList<>();
        String[] arr = winningNumbers.replaceAll(" ", "").split(",");

        isLottoNumber(arr);
        checklottoOverlapNumbers(arr);

        Arrays.sort(arr);

        winningNumberList = Arrays.asList(arr).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        checkOverlap(bonusNumber, winningNumberList);

        return winningNumberList;
    }

    public int getRank(SortedSet<Integer> paramValue) {
        return lottoRank.getRank(paramValue);
    }

    private void checkOverlap(int bounsNUmber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bounsNUmber)) {
            throw new RuntimeException(LottoErrorMessage.getLottoBonusNumberOverlapCheck());
        }
    }

    private void isNullOrEmptyCheck(String inputValue) {
        if (inputValue == null || inputValue.isEmpty()) {
            throw new RuntimeException(LottoErrorMessage.getLottoRuntimeexception());
        }
    }

    private void checklottoOverlapNumbers(String[] paramValue) {
        for (int i = 0; i < paramValue.length - 1; i++) {
            isSameValueCheck(paramValue[i], paramValue[i + 1]);
        }
    }

    private void isSameValueCheck(String paramFirst, String paramSecond) {
        if (paramFirst.equals(paramSecond)) {
            throw new RuntimeException(LottoErrorMessage.getLottoOverlapCheck());
        }
    }

    private static void isLottoNumber(String[] winningNumber) {
        try {
            for (String number : winningNumber) {
                Integer.parseInt(number);
            }

        } catch (NumberFormatException e) {
            System.out.println(LottoErrorMessage.getLottoNumberformatexception());
        }

    }
}

