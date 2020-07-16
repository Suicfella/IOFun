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
        System.out.println(Long.MAX_VALUE / 2L);
        System.out.println(buffer.readLong());
        //buffer.writeLong(Long.MAX_VALUE / 2L);


        // write(path, buffer.getPayload());

    }


    private static void write(Path path, byte[] data) throws IOException {
        Files.write(path, data);
    }


}
