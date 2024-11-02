package net.fyoncle.elysiumdaystweaks.utility.other;

public class Ram {
    public static float getAllocatedRam() {
        return ((float)Runtime.getRuntime().maxMemory() / (1000 * 1024.0f * 1024));
    }
}