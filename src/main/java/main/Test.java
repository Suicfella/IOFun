package main;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./testfile.dat");
        byte[] data = Files.readAllBytes(path);
        ByteBuffer buffer = new ByteBuffer(data);

        List<String> list = FileUtils.readFrom(Paths.get("./sometext.txt"), 3, true);
        System.out.println(list);
        //   write(path, buffer.getPayload());


    }


    private static void write(Path path, byte[] data) throws IOException {
        Files.write(path, data);
    }


}
