package demo;

import org.apache.commons.codec.binary.Hex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Hello {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(20);
        buffer.order(ByteOrder.BIG_ENDIAN);
        buffer.putShort((short) 12);
        buffer.put(new byte[14]);
        buffer.putInt(1234);

        byte[] array = buffer.array();
        System.out.println(Hex.encodeHex(array));

        buffer.rewind();
        short s = buffer.getShort();
        System.out.println(s);
        byte[] remaining = new byte[buffer.remaining()];
        buffer.get(remaining);
        System.out.println(Hex.encodeHex(remaining));
    }

}
