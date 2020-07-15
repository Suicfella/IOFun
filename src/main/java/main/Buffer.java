package main;

public class Buffer {

    private byte[] payload;
    private int position;

    public Buffer(int capacity) {
        this.payload = new byte[capacity];
        position = 0;
    }

    public Buffer(byte[] payload) {
        this.payload = payload;
        position = 0;
    }

    public void writeByte(byte value) {
        this.payload[position] = value;
        position++;
    }

    public byte readByte() {
        byte value = this.payload[position];
        position++;
        return value;
    }

    public byte[] getPayload() {
        return payload;
    }

    public int getPosition() {
        return position;
    }
}
