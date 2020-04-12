package com.javarush.task.task16.task1631;

import com.javarush.task.task16.task1631.common.*;

public class ImageReaderFactory {
    public static ImageReader getImageReader(ImageTypes type) {
        ImageReader ir = null;
        if (type == ImageTypes.JPG) {
            ir = new JpgReader();
        } else if (type == ImageTypes.PNG) {
            ir = new PngReader();
        } else if (type == ImageTypes.BMP) {
            ir = new BmpReader();
        } else {
            throw new IllegalArgumentException("Неизвестный тип картинки");
        }
        return ir;
    }
}
