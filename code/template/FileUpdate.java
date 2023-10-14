package com.app.template;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class FileUpdate {
    private static int cnPos;
    private static int firstCurly;
    private static int lastCurly;

    public static void assignLinePointer(String filePath) {
        AtomicInteger count = new AtomicInteger(0);
//        AtomicInteger pos = new AtomicInteger(0);
        try (Stream<String> stream = Files.lines(Paths.get(filePath))) {
            stream.forEach(x -> {
                count.incrementAndGet();
                String trim = x.trim();
                if (trim.startsWith("public class")) {
                    cnPos = count.get();
                }
                if (trim.endsWith("{")) {
                    firstCurly = count.get();
                }
                if (trim.endsWith("}")) {
//                    int val = map.getOrDefault('{', 0);
//                    map.put("}", count.get());
                    lastCurly = count.get();
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> minSubArrayLen() {
        List<String> lines = new ArrayList<>();
        lines.add("    public int minSubArrayLen(int target, int[] nums) {");
        lines.add("        int start = 0;");
        lines.add("        int sum = 0;");
        lines.add("        int currMin = Integer.MAX_VALUE;");
        lines.add("        for (int i = 0; i < nums.length; i++) {");
        lines.add("            sum += nums[i];");
        lines.add("            while (sum >= target) {");
        lines.add("                currMin = Math.min(currMin, i - start);");
        lines.add("                sum -= nums[start++];");
        lines.add("            }");
        lines.add("        }");
        lines.add("        return currMin == Integer.MAX_VALUE ? 0 : currMin + 1;");
        lines.add("    }");
        lastCurly += lines.size();
        return lines;
    }

    public static List<String> getFileLines(String filePath) {
        Path path = Paths.get(filePath);
        List<String> lines;
        try {
            lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            Files.write(path, lines, StandardCharsets.UTF_8);
            return lines;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void updateFile(List<String> lines, String filePath) {
        Path path = Paths.get(filePath);
        try {
            Files.write(path, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        String filePath = "src/com/app/template/Distance2.java";
        assignLinePointer(filePath);

        List<String> lines = getFileLines(filePath);

        cnPos--;
        lines.add(cnPos++, "import java.time.LocalDate;");
        lines.add(cnPos++, "import java.time.sak;");
        lines.add(cnPos++, "import java.time.sak2;");
        lines.add(cnPos++, "import java.time.sak3;");
        lines.add(cnPos++, "import java.time.sak4;");


//        lines.addAll(lastCurly - 1, minSubArrayLen());
        updateFile(lines, filePath);

//        deleteLine(filePath, 5, 17);
//        foo();

    }

    public static void deleteLine(String filePath, int start, int end) {
        try {
            Path path = Paths.get(filePath);
            List<String> fileLines = Files.readAllLines(path, StandardCharsets.UTF_8);
            int i = start - 1;
            for (int j = start - 1; j < end; j++) {
                fileLines.remove(i);
            }

            Files.write(path, fileLines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void foo() {
        List<String> lines = new ArrayList<>();
        lines.add("The first line");
        lines.add("The first line2");
        Path file = Paths.get("the-file-name.txt");
        try {
            Files.write(file, lines, StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //Files.write(file, lines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }
}
