package KeemaCurry.utils.font;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

import java.awt.*;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("NonAtomicOperationOnVolatileField")
public class FontUtil {
    public static volatile int completed;
    public static MinecraftFontRenderer normal;
    public static MinecraftFontRenderer normal25;
    public static MinecraftFontRenderer mini;
    public static MinecraftFontRenderer big;
    private static Font normal_;
    private static Font normal25_;
    private static Font mini_;
    private static Font big_;

    public static Font getFont(Map<String, Font> locationMap, String location, int size) {
        Font font = null;

        try {
            if (locationMap.containsKey(location)) {
                font = locationMap.get(location).deriveFont(Font.PLAIN, size);
            } else {
                InputStream is = Minecraft.getMinecraft().getResourceManager()
                        .getResource(new ResourceLocation("kima/font/" + location)).getInputStream();
                font = Font.createFont(0, is);
                locationMap.put(location, font);
                font = font.deriveFont(Font.PLAIN, size);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading font");
            font = new Font("default", Font.PLAIN, +10);
        }

        return font;
    }

    public static boolean hasLoaded() {
        return completed >= 3;
    }

    public static void bootstrap() {
        new Thread(() ->
        {
            Map<String, Font> locationMap = new HashMap<>();
            normal_ = getFont(locationMap, "arial.ttf", 19);
            
            Map<String, Font> locationMap_ = new HashMap<>();
            normal25_ = getFont(locationMap_, "arial.ttf", 25);
            
            Map<String, Font> locationMap__ = new HashMap<>();
            mini_ = getFont(locationMap__, "arial.ttf", 11);
            
            Map<String, Font> locationMap___ = new HashMap<>();
            big_ = getFont(locationMap___, "arial.ttf", 44);
            
            completed++;
            
            
        }).start();
        new Thread(() ->
        {
            Map<String, Font> locationMap = new HashMap<>();
            completed++;
        }).start();
        new Thread(() ->
        {
            Map<String, Font> locationMap = new HashMap<>();
            completed++;
        }).start();

        while (!hasLoaded()) {
            try {
                //noinspection BusyWait
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        normal = new MinecraftFontRenderer(normal_, true, true);
        normal25 = new MinecraftFontRenderer(normal_, true, true);
        mini = new MinecraftFontRenderer(mini_, true, true);
        big = new MinecraftFontRenderer(big_, true, true);
    }
}