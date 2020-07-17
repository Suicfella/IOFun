package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Test {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./testfile.dat");
        byte[] data = Files.readAllBytes(path);
        Buffer buffer = new Buffer(data);

        String str = FileUtils.readRandomLine(Paths.get("./sometext.txt"));
        System.out.println(str);
        //   write(path, buffer.getPayload());


    }


    private static void write(Path path, byte[] data) throws IOException {
        Files.write(path, data);
    }


}
