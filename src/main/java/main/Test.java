package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./testfile.dat");
        byte[] data = Files.readAllBytes(path);
        Buffer buffer = new Buffer(data);
        for (int i = 0; i < 5; i++) {
            System.out.println(buffer.readByte());
        }
    }


}
