package com.example.demo.util;

import java.io.*;
import java.nio.file.*;
import java.util.List;

public class FileAggregator {

    private static final String[] filesToAggregate = {
   //         "C:\\Users\\e.khisamutdinov\\IdeaProjects\\safety_back\\src\\main\\resources\\application.yaml",
    //        "C:\\Users\\e.khisamutdinov\\IdeaProjects\\safety_back\\pom.xml",
    //        "C:\\Users\\e.khisamutdinov\\IdeaProjects\\safety_back\\src\\main\\java\\com\\example\\demo\\controller\\RiskFormController.java",
    //        "C:\\Users\\e.khisamutdinov\\IdeaProjects\\safe_back\\src\\main\\java\\com\\example\\demo\\entity\\User.java",
    //        "C:\\Users\\e.khisamutdinov\\IdeaProjects\\safe_back\\src\\main\\java\\com\\example\\demo\\entity\\Role.java",

            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\Content.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\MainContent.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\MapComponent.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\RiskForm.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\SectionHeader.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\Sidebar.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\Login.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\Register.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\RiskDetail.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\TopMenu.jsx",
            "D:\\D\\SAFE\\client\\safe_front\\src\\components\\Content.jsx",

            "D:\\D\\SAFE\\client\\safe_front\\src\\App.js",

  //          "C:\\Users\\e.khisamutdinov\\react\\deep\\my-app\\src\\styles\\App.css",
            //         "D:\\D\\SAFE\\client\\safe_front\\src\\styles\\Content.css",
     //       "D:\\D\\SAFE\\client\\safe_front\\src\\styles\\MainContent.css",
//            "C:\\Users\\e.khisamutdinov\\react\\deep\\my-app\\src\\styles\\MapComponent.css",
  //          "C:\\Users\\e.khisamutdinov\\react\\deep\\my-app\\src\\styles\\RiskForm.css",
    //        "D:\\D\\SAFE\\client\\safe_front\\src\\styles\\SectionHeader.css",
 //           "C:\\Users\\e.khisamutdinov\\react\\deep\\my-app\\src\\styles\\Sidebar.css",
   //         "D:\\D\\SAFE\\client\\safe_front\\src\\styles\\TopMenu.css",

    //        "C:\\Users\\e.khisamutdinov\\react\\deep\\my-app\\package.json"
    };

    public static void text() {
        FileAggregator aggregator = new FileAggregator();
        try {
            // Передаем имена файлов и файл для записи
            aggregator.aggregateFiles(filesToAggregate, "output.txt");
            System.out.println("Файлы успешно объединены в output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Метод для считывания содержимого переданных файлов и записи в один текстовый файл
    public void aggregateFiles(String[] fileNames, String outputFile) throws IOException {
        // Создание файла для записи
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

        // Проходим по всем переданным файлам
        for (String fileName : fileNames) {
            Path filePath = Paths.get(fileName);

            // Проверяем, существует ли файл
            if (Files.exists(filePath)) {
                // Чтение содержимого файла
                List<String> lines = Files.readAllLines(filePath);
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine(); // Добавление новой строки
                }
                writer.newLine(); // Добавление пустой строки между файлами
            } else {
                System.out.println("Файл не найден: " + fileName);
            }
        }

        // Закрытие writer после записи всех данных
        writer.close();
    }


}

