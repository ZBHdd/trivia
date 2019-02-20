package utils;


import net.coobird.thumbnailator.Thumbnails;

import java.io.*;

/**
 * @ClassName GifFile
 * @Description TODO
 * @Author Satan
 **/
public class GifFile {
    public static void main(String[] args) throws IOException {

        FileInputStream fileInputStream = new FileInputStream("D:\\chromeFile\\1507667222-3317.gif");

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //压缩文件
        Thumbnails.of(fileInputStream).scale(1f).outputQuality(1f).toOutputStream(byteArrayOutputStream);

        //上传流
        InputStream ossStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
        saveGifImageInputStream(ossStream, "D:\\chromeFile\\15076672223317.gif");
    }

    /**
     * 保存本地上传的gif
     * @param inputStream 图片数据
     * @param savePath 保存路径
     */
    public static void saveGifImageInputStream(InputStream inputStream, String savePath){
        byte[] data = new byte[1024];
        int len = 0;
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(savePath);
            while ((len = inputStream.read(data)) != -1) {
                fileOutputStream.write(data, 0, len);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
