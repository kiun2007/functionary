package com.kiun.functionary.service.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ImgUtils {

    public static void removeBg(String imgUrl, String resUrl) throws IOException {

        BufferedImage img = ImageIO.read(new File(imgUrl));

        File file = new File(resUrl);
        if (!file.exists())
        {
            File dir = file.getParentFile();
            if (!dir.exists())
            {
                dir.mkdirs();
            }
            try
            {
                file.createNewFile();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
        ImageIO.write(img, "png", file);
    }

    public static BufferedImage removeBg(byte[] bytes) throws IOException {
        ByteArrayInputStream inputStream = new ByteArrayInputStream(bytes);
        return removeBg(ImageIO.read(inputStream));
    }

    public static BufferedImage removeBg(BufferedImage img) throws IOException {

        int width = img.getWidth();
        int height = img.getHeight();
        LinkedHashMap<Integer, Integer> colorsCount = new LinkedHashMap<>();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = img.getRGB(x, y);
                Integer count = colorsCount.get(rgb);

                if (count == null){
                    count = 0;
                }
                colorsCount.put(rgb, ++count);
            }
        }

        Map<Integer, Integer> topValue = colorsCount.entrySet().stream().
                sorted((o1, o2) -> o2.getValue() - o1.getValue()).limit(5).collect(Collectors.toMap((t)->t.getKey(), (t)->t.getValue()));

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int rgb = img.getRGB(x, y);
                if (!topValue.containsKey(rgb)){
                    img.setRGB(x, y, -1);
                }
            }
        }

//        int textColor[] = new int[4];
//        int index = 0;
//
//        for (int x = 0; x < width; x ++){
//            int rgb = img.getRGB(x, height/2);
//
//            if (rgb != -1 && topValue.containsKey(rgb)){
//                if (index == 0 || (index > 0 && textColor[index-1] != rgb)){
//                    textColor[index ++] = rgb;
//                }
//            }
//        }
        return img;
    }

    public static void removeBackground(String imgUrl, String resUrl){
        //定义一个临界阈值
        int threshold = 18000;
        try{
            BufferedImage img = ImageIO.read(new File(imgUrl));
            int width = img.getWidth();
            int height = img.getHeight();
            for(int i = 1;i < width;i++){
                for (int x = 0; x < width; x++){
                    for (int y = 0; y < height; y++){
                        Color color = new Color(img.getRGB(x, y));
//                        System.out.println("red:"+color.getRed()+" | green:"+color.getGreen()+" | blue:"+color.getBlue());
                        int num = color.getRed()+color.getGreen()+color.getBlue();
                        if(num >= threshold){
                            img.setRGB(x, y, Color.WHITE.getRGB());
                        }
                    }
                }
            }
            for(int i = 1;i<width;i++){
                Color color1 = new Color(img.getRGB(i, 1));
                int num1 = color1.getRed()+color1.getGreen()+color1.getBlue();
                for (int x = 0; x < width; x++)
                {
                    for (int y = 0; y < height; y++)
                    {
                        Color color = new Color(img.getRGB(x, y));

                        int num = color.getRed()+color.getGreen()+color.getBlue();
                        if(num==num1){
                            img.setRGB(x, y, Color.BLACK.getRGB());
                        }else{
                            img.setRGB(x, y, Color.WHITE.getRGB());
                        }
                    }
                }
            }
            File file = new File(resUrl);
            if (!file.exists())
            {
                File dir = file.getParentFile();
                if (!dir.exists())
                {
                    dir.mkdirs();
                }
                try
                {
                    file.createNewFile();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            ImageIO.write(img, "jpg", file);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void cuttingImg(String imgUrl){
        try{
            File newfile=new File(imgUrl);
            BufferedImage bufferedimage=ImageIO.read(newfile);
            int width = bufferedimage.getWidth();
            int height = bufferedimage.getHeight();
            if (width > 52) {
                bufferedimage=ImgUtils.cropImage(bufferedimage,(int) ((width - 52) / 2),0,(int) (width - (width-52) / 2),(int) (height));
                if (height > 16) {
                    bufferedimage=ImgUtils.cropImage(bufferedimage,0,(int) ((height - 16) / 2),52,(int) (height - (height - 16) / 2));
                }
            }else{
                if (height > 16) {
                    bufferedimage=ImgUtils.cropImage(bufferedimage,0,(int) ((height - 16) / 2),(int) (width),(int) (height - (height - 16) / 2));
                }
            }
            ImageIO.write(bufferedimage, "jpg", new File(imgUrl));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static BufferedImage cropImage(BufferedImage bufferedImage, int startX, int startY, int endX, int endY) {
        int width = bufferedImage.getWidth();
        int height = bufferedImage.getHeight();
        if (startX == -1) {
            startX = 0;
        }
        if (startY == -1) {
            startY = 0;
        }
        if (endX == -1) {
            endX = width - 1;
        }
        if (endY == -1) {
            endY = height - 1;
        }
        BufferedImage result = new BufferedImage(endX - startX, endY - startY, 4);
        for (int x = startX; x < endX; ++x) {
            for (int y = startY; y < endY; ++y) {
                int rgb = bufferedImage.getRGB(x, y);
                result.setRGB(x - startX, y - startY, rgb);
            }
        }
        return result;
    }
}
