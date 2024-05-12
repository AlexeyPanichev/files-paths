import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String fileDirectory = "C://Games";
        File gamesDirectory = new File(fileDirectory);
        if (!gamesDirectory.exists()) {
            if (!gamesDirectory.mkdir()) {
                System.out.println("Упс! Не получилось создать директорий: " + fileDirectory);
                return;
            }
        }

        String[] directoriesToCreate = {
                "src",
                "src/main",
                "src/test",
                "res",
                "res/drawables",
                "res/vectors",
                "res/icons",
                "savegames",
                "temp"
        };

        String[] filesToCreate = {
                "src/main/Main.java",
                "src/main/Utils.java",
                "res/temp.txt"
        };

        for (String dir : directoriesToCreate) {
            File directory = new File(fileDirectory, dir);
            if (!directory.exists()) {
                if (!directory.mkdir()) {
                    System.out.println("Ой-ой! Не получилось создать директорий: " + dir);
                } else {
                    System.out.println("Директорий создан: " + dir);
                }
            } else {
                System.out.println("Упс! Кажется такой директорий уже есть: " + dir);
            }
        }

        for (String file : filesToCreate) {
            File newFile = new File(fileDirectory, file);
            if (!newFile.exists()) {
                try {
                    if (newFile.createNewFile()) {
                        System.out.println("Упс! Не получилось создать директорий: " + file);
                    } else {
                        System.out.println("Упс! Не получилось создать файл: " + file);
                    }
                } catch (IOException e) {
                    System.out.println("ой-ой! Ошибочка вышла в создании файла: " + file);
                    e.printStackTrace();
                }
            } else {
                System.out.println("Ой, кажется файл уже существует: " + file);
            }
        }

        try (FileWriter fileWriter = new FileWriter(new File(fileDirectory, "res/temp.txt"))) {
            fileWriter.write("");
            System.out.println("Файл создан: res/temp.txt");
        } catch (IOException e) {
            System.out.println("Упс! Не получилось создать файл: res/temp.txt");
            e.printStackTrace();
        }
    }
}