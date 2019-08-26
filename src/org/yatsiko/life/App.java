package org.yatsiko.life;

import org.w3c.dom.ls.LSOutput;
import org.yatsiko.life.input.InputProvider;
import org.yatsiko.life.input.MockInputProvider;
import org.yatsiko.life.logic.God;
import org.yatsiko.life.view.Scene;

import java.util.List;

public class App {

    private static InputProvider inputProvider = new MockInputProvider();

    //не стал запускать интерфейс в другом потоке, потому что у нас нету взаимодействия с пользователем,
    //а синхронизировать потоки никто не любит.
    private static God god = new God(inputProvider.getMatrix());
    private static Scene scene = new Scene(inputProvider.getSceneDimension());

    public static void main(String[] args) throws InterruptedException {
        int iterationsQuantity = inputProvider.getIterationsQuantity();
        for (int i = 0; i < iterationsQuantity; i++) {
            List<Pair> list = god.getLiveFields();
            scene.setPairList(list);
            list.forEach(pair -> {
                System.out.println(pair.getX() + " - " + pair.getY());
            });
            System.out.println();
            System.out.println();
            System.out.println();
            god.nextGeneration();
            Thread.sleep(100);
        }

    }
}
