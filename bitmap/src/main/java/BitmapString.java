import org.roaringbitmap.longlong.Roaring64Bitmap;
import org.roaringbitmap.longlong.Roaring64NavigableMap;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.Base64;

public class BitmapString {
    public static String bitmapToString(Roaring64NavigableMap bitmap) {
        byte[] bytes = serialize(bitmap);
        return byteArrayToBase64String(bytes);
    }

    public static String byteArrayToBase64String(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }

    public static Roaring64NavigableMap deserialize(byte[] bytes) {
        if (bytes == null) return null;
        Roaring64NavigableMap bitmap = new Roaring64NavigableMap(true, false);
        try (DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytes))) {
            bitmap.deserialize(dis);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    public static byte[] serialize(Roaring64NavigableMap bitmap) {
        if (bitmap == null) return null;
        bitmap.runOptimize();
        try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
             DataOutputStream dos = new DataOutputStream(bos)) {
            bitmap.serialize(dos);
            byte[] bytes = bos.toByteArray();
            dos.close();
            bos.close();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Roaring64NavigableMap map = new Roaring64NavigableMap();
        map.add(1L);
        System.out.println(bitmapToString(map));
    }
}
