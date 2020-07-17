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

    public void adjustBuffer(int extraCapacity) {
        if (extraCapacity < 1) {
            throw new IllegalArgumentException("Extra capacity must be atleast 1");
        }
        byte[] currentPayload = this.payload;
        this.payload = new byte[currentPayload.length + extraCapacity];
        this.position = currentPayload.length;

        for (int i = 0; i < currentPayload.length; i++) {
            this.payload[i] = currentPayload[i];
        }
    }

    public void writeByte(int value) {
        this.payload[position++] = (byte) value;
    }

    public byte readByte() {
        return this.payload[position++];
    }

    public void writeShort(int value) {

        this.payload[position++] = (byte) (value >> 8);
        this.payload[position++] = (byte) value;

        System.out.println("Position: " + position);

    }

    public int readShort() {
        position += 2;
        return ((this.payload[position - 2] & 0xFF) << 8) + (this.payload[position - 1] & 0xFF);
    }

    public void writeInt(int value) {
        this.payload[position++] = (byte) (value >> 24);
        this.payload[position++] = (byte) (value >> 16);
        this.payload[position++] = (byte) (value >> 8);
        this.payload[position++] = (byte) value;
    }

    public int readInt() {
        position += 4;
        return ((this.payload[position - 4] & 0xFF) << 24) + ((this.payload[position - 3] & 0xFF) << 16) + ((this.payload[position - 2] & 0xFF) << 8) + (this.payload[position - 1] & 0xFF);
    }

    public void writeLong(long value) {
        this.payload[position++] = (byte) (value >> 56);
        this.payload[position++] = (byte) (value >> 48);
        this.payload[position++] = (byte) (value >> 40);
        this.payload[position++] = (byte) (value >> 32);
        this.payload[position++] = (byte) (value >> 24);
        this.payload[position++] = (byte) (value >> 16);
        this.payload[position++] = (byte) (value >> 8);
        this.payload[position++] = (byte) value;
    }

    public long readLong() {
        final long MASK = 0xffffffffL;
        return ((readInt() & MASK) << 32) + ((long) readInt() & MASK);
    }

    public byte[] getPayload() {
        return payload;
    }


    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
