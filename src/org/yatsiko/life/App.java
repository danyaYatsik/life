package org.yatsiko.life;

import org.yatsiko.life.io.FileWriter;
import org.yatsiko.life.io.JsonReader;
import org.yatsiko.life.io.Reader;
import org.yatsiko.life.logic.Fatum;
import org.yatsiko.life.model.Cell;
import org.yatsiko.life.view.Scene;

import java.io.File;
import java.util.List;

public class App {

    private static Reader reader;
    private static FileWriter writer;
    private static Fatum fatum;
    private static Scene scene;

    public static void main(String[] args) throws Exception {
        reader = new JsonReader(new File("storage\\input.json"));
        writer = new FileWriter(new File("storage\\output.txt"));
        fatum = new Fatum(reader.getMatrix());
        scene = new Scene(reader.getSceneDimension());

        int iterationsQuantity = reader.getIterationsQuantity();

        for (int i = 0; i < iterationsQuantity; i++) {
            List<Cell> list = fatum.getLiveFields();
            scene.update(list);
            fatum.nextGeneration();
            Thread.sleep(reader.getDelay());
        }

        writer.write(fatum.getMatrix());
    }
}
