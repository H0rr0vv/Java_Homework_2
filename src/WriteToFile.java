import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class WriteToFile {

    public static void write(String[] res) {

        Logger logger = Logger.getAnonymousLogger();
        FileHandler fileHandler = null;

        try {
            fileHandler = new FileHandler("src/log.txt", true);
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }

        String filePath = "src/text.txt";
        try (FileWriter writer = new FileWriter(filePath)) {
            int i = 0;
            while (i < res.length) {
                writer.write("Студент " + res[i] + " получил " + res[i + 1] + " по предмету " + res[i + 2] + ".");
                writer.write("\n");
                i += 3;
            }
            logger.info("Запись успешно выполнена");
        } catch (IOException e) {
            e.printStackTrace();
            logger.warning("Ошибка записи файла");
        }
        fileHandler.close();
    }
}
