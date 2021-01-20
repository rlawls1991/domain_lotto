package study.lotto.client;


import study.lotto.controller.LottoController;

public class LottoGameApp {

    public static void main(String[] args) {
        LottoController lottoController = new LottoController();
        lottoController.gameStart();
    }
}
