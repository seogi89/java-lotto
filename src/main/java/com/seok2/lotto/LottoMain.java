package com.seok2.lotto;

import com.seok2.lotto.domain.Lotteries;
import com.seok2.lotto.domain.LottoMachine;
import com.seok2.lotto.domain.LottoSheet;
import com.seok2.lotto.domain.Money;
import com.seok2.lotto.domain.Ranks;
import com.seok2.lotto.view.LottoInputView;
import com.seok2.lotto.view.LottoOutputView;

public class LottoMain {

    public static void main(String[] args) {
        Money investment = LottoInputView.getInvestment();
        LottoSheet sheet = LottoSheet.of(LottoInputView.getLottoSheetRow());
        Lotteries lotteries = LottoMachine.buy(investment, sheet);
        LottoOutputView.print(lotteries);
        Ranks ranks = lotteries.check(LottoInputView.getWinning());
        LottoOutputView.print(ranks);
    }
}
