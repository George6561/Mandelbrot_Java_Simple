/*
 * Copyright © 2025 George Miller
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package com.utils;

/**
 * Utility class for working with ARGB and RGB color values.
 * <p>
 * This class provides a comprehensive set of predefined color constants with their
 * ARGB values, closely matching the W3C color names used in web and desktop development.
 * It also includes methods for constructing ARGB/RGB values from individual color components,
 * extracting individual components from packed int values, and converting those values to human-readable strings.
 * </p>
 * <p>
 * Designed to facilitate color manipulation and conversion in graphical applications,
 * user interfaces, and other visual tools requiring programmatic color handling.
 * </p>
 *
 * @author George Miller
 */

public class ColorUtils {

    /**
     * Gets a system-defined color that has an ARGB value of #FFF0F8FF.
     */
    public static final int ALICE_BLUE = 0xfff0f8ff;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFAEBD7.
     */
    public static final int ANTIQUE_WHITE = 0xfffaebd7;
    /**
     * Gets a system-defined color that has an ARGB value of #FF00FFFF.
     */
    public static final int AQUA = 0xff00ffff;
    /**
     * Gets a system-defined color that has an ARGB value of #FF7FFFD4.
     */
    public static final int AQUAMARINE = 0xff7fffd4;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF0FFFF.
     */
    public static final int AZURE = 0xfff0ffff;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF5F5DC.
     */
    public static final int BEIGE = 0xfff5f5dc;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFE4C4.
     */
    public static final int BISQUE = 0xffffe4c4;
    /**
     * Gets a system-defined color that has an ARGB value of #FF000000.
     */
    public static final int BLACK = 0xff000000;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFEBCD.
     */
    public static final int BLANCHED_ALMOND = 0xffffebcd;
    /**
     * Gets a system-defined color that has an ARGB value of #FF0000FF.
     */
    public static final int BLUE = 0xff0000ff;
    /**
     * Gets a system-defined color that has an ARGB value of #FF8A2BE2.
     */
    public static final int BLUE_VIOLET = 0xff8a2be2;
    /**
     * Gets a system-defined color that has an ARGB value of #FFA52A2A.
     */
    public static final int BROWN = 0xffa52a2a;
    /**
     * Gets a system-defined color that has an ARGB value of #FFDEB887.
     */
    public static final int BURLY_WOOD = 0xffdeb887;
    /**
     * Gets a system-defined color that has an ARGB value of #FF5F9EA0.
     */
    public static final int CADET_BLUE = 0xff5f9ea0;
    /**
     * Gets a system-defined color that has an ARGB value of #FF7FFF00.
     */
    public static final int CHARTREUSE = 0xff7fff00;
    /**
     * Gets a system-defined color that has an ARGB value of #FFD2691E.
     */
    public static final int CHOCOLATE = 0xffd2691e;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFF7F50.
     */
    public static final int CORAL = 0xffff7f50;
    /**
     * Gets a system-defined color that has an ARGB value of #FF6495ED.
     */
    public static final int CORNFLOWER_BLUE = 0xff6495ed;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFF8DC.
     */
    public static final int CORNSILK = 0xfffff8dc;
    /**
     * Gets a system-defined color that has an ARGB value of #FFDC143C.
     */
    public static final int CRIMSON = 0xffdc143c;
    /**
     * Gets a system-defined color that has an ARGB value of #FF00FFFF.
     */
    public static final int CYAN = 0xff00ffff;
    /**
     * Gets a system-defined color that has an ARGB value of #FF00008B.
     */
    public static final int DARK_BLUE = 0xff00008b;
    /**
     * Gets a system-defined color that has an ARGB value of #FF008B8B.
     */
    public static final int DARK_CYAN = 0xff008b8b;
    /**
     * Gets a system-defined color that has an ARGB value of #FFB8860B.
     */
    public static final int DARK_GOLDENROD = 0xffb8860b;
    /**
     * Gets a system-defined color that has an ARGB value of #FFA9A9A9.
     */
    public static final int DARK_GRAY = 0xffa9a9a9;
    /**
     * Gets a system-defined color that has an ARGB value of #FF006400.
     */
    public static final int DARK_GREEN = 0xff006400;
    /**
     * Gets a system-defined color that has an ARGB value of #FFBDB76B.
     */
    public static final int DARK_KHAKI = 0xffbdb76b;
    /**
     * Gets a system-defined color that has an ARGB value of #FF8B008B.
     */
    public static final int DARK_MAGENTA = 0xff8b008b;
    /**
     * Gets a system-defined color that has an ARGB value of #FF556B2F.
     */
    public static final int DARK_OLIVE_GREEN = 0xff556b2f;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFF8C00.
     */
    public static final int DARK_ORANGE = 0xffff8c00;
    /**
     * Gets a system-defined color that has an ARGB value of #FF9932CC.
     */
    public static final int DARK_ORCHID = 0xff9932cc;
    /**
     * Gets a system-defined color that has an ARGB value of #FF8B0000.
     */
    public static final int DARK_RED = 0xff8b0000;
    /**
     * Gets a system-defined color that has an ARGB value of #FFE9967A.
     */
    public static final int DARK_SALMON = 0xffe9967a;
    /**
     * Gets a system-defined color that has an ARGB value of #FF8FBC8F.
     */
    public static final int DARK_SEA_GREEN = 0xff8fbc8b;
    /**
     * Gets a system-defined color that has an ARGB value of #FF483D8B.
     */
    public static final int DARK_SLATE_BLUE = 0xff483d8b;
    /**
     * Gets a system-defined color that has an ARGB value of #FF2F4F4F.
     */
    public static final int DARK_SLATE_GRAY = 0xff2f4f4f;
    /**
     * Gets a system-defined color that has an ARGB value of #FF00CED1.
     */
    public static final int DARK_TURQUOISE = 0xff00ced1;
    /**
     * Gets a system-defined color that has an ARGB value of #FF9400D3.
     */
    public static final int DARK_VIOLET = 0xff9400d3;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFF1493.
     */
    public static final int DEEP_PINK = 0xffff1493;
    /**
     * Gets a system-defined color that has an ARGB value of #FF00BFFF.
     */
    public static final int DEEP_SKY_BLUE = 0xff00bfff;
    /**
     * Gets a system-defined color that has an ARGB value of #FF696969.
     */
    public static final int DIM_GRAY = 0xff696969;
    /**
     * Gets a system-defined color that has an ARGB value of #FF1E90FF.
     */
    public static final int DODGER_BLUE = 0xff1e90ff;
    /**
     * Gets a system-defined color that has an ARGB value of #FFB22222.
     */
    public static final int FIREBRICK = 0xffb22222;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFFAF0.
     */
    public static final int FLORAL_WHITE = 0xfffffaf0;
    /**
     * Gets a system-defined color that has an ARGB value of #FF228B22.
     */
    public static final int FOREST_GREEN = 0xff228b22;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFF00FF.
     */
    public static final int FUCHSIA = 0xffff00ff;
    /**
     * Gets a system-defined color that has an ARGB value of #FFDCDCDC.
     */
    public static final int GAINSBORO = 0xffdcdcdc;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF8F8FF.
     */
    public static final int GHOST_WHITE = 0xfff8f8ff;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFD700.
     */
    public static final int GOLD = 0xffffd700;
    /**
     * Gets a system-defined color that has an ARGB value of #FFDAA520.
     */
    public static final int GOLDENROD = 0xffdaa520;
    /**
     * Gets a system-defined color that has an ARGB value of #FF808080.
     */
    public static final int GRAY = 0xff808080;
    /**
     * Gets a system-defined color that has an ARGB value of #FF008000.
     */
    public static final int GREEN = 0xff008000;
    /**
     * Gets a system-defined color that has an ARGB value of #FFADFF2F.
     */
    public static final int GREEN_YELLOW = 0xffadff2f;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF0FFF0.
     */
    public static final int HONEYDEW = 0xfff0fff0;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFF69B4.
     */
    public static final int HOTPINK = 0xffff69b4;
    /**
     * Gets a system-defined color that has an ARGB value of #FFCD5C5C.
     */
    public static final int INDIAN_RED = 0xffcd5c5c;
    /**
     * Gets a system-defined color that has an ARGB value of #FF4B0082.
     */
    public static final int INDIGO = 0xff4b0082;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFFFF0.
     */
    public static final int IVORY = 0xfffffff0;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF0E68C.
     */
    public static final int KHAKI = 0xfff0e68c;
    /**
     * Gets a system-defined color that has an ARGB value of #FFE6E6FA.
     */
    public static final int LAVENDER = 0xffe6e6fa;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFF0F5.
     */
    public static final int LAVENDER_BLUSH = 0xfffff0f5;
    /**
     * Gets a system-defined color that has an ARGB value of #FF7CFC00.
     */
    public static final int LAWN_GREEN = 0xff7cfc00;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFFACD.
     */
    public static final int LEMON_CHIFFON = 0xfffffacd;
    /**
     * Gets a system-defined color that has an ARGB value of #FFADD8E6.
     */
    public static final int LIGHT_BLUE = 0xffadd8e6;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF08080.
     */
    public static final int LIGHT_CORAL = 0xfff08080;
    /**
     * Gets a system-defined color that has an ARGB value of #FFE0FFFF.
     */
    public static final int LIGHT_CYAN = 0xffe0ffff;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFAFAD2.
     */
    public static final int LIGHT_GOLDENROD_YELLOW = 0xfffafad2;
    /**
     * Gets a system-defined color that has an ARGB value of #FFD3D3D3.
     */
    public static final int LIGHT_GRAY = 0xffd3d3d3;
    /**
     * Gets a system-defined color that has an ARGB value of #FF90EE90.
     */
    public static final int LIGHT_GREEN = 0xff90ee90;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFB6C1.
     */
    public static final int LIGHT_PINK = 0xffffb6c1;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFA07A.
     */
    public static final int LIGHT_SALMON = 0xffffa07a;
    /**
     * Gets a system-defined color that has an ARGB value of #FF20B2AA.
     */
    public static final int LIGHT_SEA_GREEN = 0xff20b2aa;
    /**
     * Gets a system-defined color that has an ARGB value of #FF87CEFA.
     */
    public static final int LIGHT_SKY_BLUE = 0xff87cefa;
    /**
     * Gets a system-defined color that has an ARGB value of #FF778899.
     */
    public static final int LIGHT_SLATE_GRAY = 0xff778899;
    /**
     * Gets a system-defined color that has an ARGB value of #FFB0C4DE.
     */
    public static final int LIGHT_STEEL_BLUE = 0xffb0c4de;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFFFE0.
     */
    public static final int LIGHT_YELLOW = 0xffffffe0;
    /**
     * Gets a system-defined color that has an ARGB value of #FF00FF00.
     */
    public static final int LIME = 0xff00ff00;
    /**
     * Gets a system-defined color that has an ARGB value of #FF32CD32.
     */
    public static final int LIME_GREEN = 0xff32cd32;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFAF0E6.
     */
    public static final int LINEN = 0xfffaf0e6;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFF00FF.
     */
    public static final int MAGENTA = 0xffff00ff;
    /**
     * Gets a system-defined color that has an ARGB value of #FF800000.
     */
    public static final int MAROON = 0xff800000;
    /**
     * Gets a system-defined color that has an ARGB value of #FF66CDAA.
     */
    public static final int MEDIUM_AQUAMARINE = 0xff66cdaa;
    /**
     * Gets a system-defined color that has an ARGB value of #FF0000CD.
     */
    public static final int MEDIUM_BLUE = 0xff0000cd;
    /**
     * Gets a system-defined color that has an ARGB value of #FFBA55D3.
     */
    public static final int MEDIUM_ORCHID = 0xffba55d3;
    /**
     * Gets a system-defined color that has an ARGB value of #FF9370DB.
     */
    public static final int MEDIUM_PURPLE = 0xff9370db;
    /**
     * Gets a system-defined color that has an ARGB value of #FF3CB371.
     */
    public static final int MEDIUM_SEA_GREEN = 0xff3cb371;
    /**
     * Gets a system-defined color that has an ARGB value of #FF7B68EE.
     */
    public static final int MEDIUM_SLATE_BLUE = 0xff7b68ee;
    /**
     * Gets a system-defined color that has an ARGB value of #FF00FA9A.
     */
    public static final int MEDIUM_SPRING_GREEN = 0xff00fa9a;
    /**
     * Gets a system-defined color that has an ARGB value of #FF48D1CC.
     */
    public static final int MEDIUM_TURQUOISE = 0xff48d1cc;
    /**
     * Gets a system-defined color that has an ARGB value of #FFC71585.
     */
    public static final int MEDIUM_VIOLET_RED = 0xffc71585;
    /**
     * Gets a system-defined color that has an ARGB value of #FF191970.
     */
    public static final int MIDNIGHT_BLUE = 0xff191970;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF5FFFA.
     */
    public static final int MINT_CREAM = 0xfff5fffa;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFE4E1.
     */
    public static final int MISTY_ROSE = 0xffffe4e1;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFE4B5.
     */
    public static final int MOCCASIN = 0xffffe4b5;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFDEAD.
     */
    public static final int NAVAJO_WHITE = 0xffffdead;
    /**
     * Gets a system-defined color that has an ARGB value of #FF000080.
     */
    public static final int NAVY = 0xff000080;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFDF5E6.
     */
    public static final int OLD_LACE = 0xfffdf5e6;
    /**
     * Gets a system-defined color that has an ARGB value of #FF808000.
     */
    public static final int OLIVE = 0xff808000;
    /**
     * Gets a system-defined color that has an ARGB value of #FF6B8E23.
     */
    public static final int OLIVE_DRAB = 0xff6b8e23;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFA500.
     */
    public static final int ORANGE = 0xffffa500;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFF4500.
     */
    public static final int ORANGE_RED = 0xffff4500;
    /**
     * Gets a system-defined color that has an ARGB value of #FFDA70D6.
     */
    public static final int ORCHID = 0xffda70d6;
    /**
     * Gets a system-defined color that has an ARGB value of #FFEEE8AA.
     */
    public static final int PALE_GOLDENROD = 0xffeee8aa;
    /**
     * Gets a system-defined color that has an ARGB value of #FF98FB98.
     */
    public static final int PALE_GREEN = 0xff98fb98;
    /**
     * Gets a system-defined color that has an ARGB value of #FFAFEEEE.
     */
    public static final int PALE_TURQUOISE = 0xffafeeee;
    /**
     * Gets a system-defined color that has an ARGB value of #FFDB7093.
     */
    public static final int PALE_VIOLET_RED = 0xffdb7093;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFEFD5.
     */
    public static final int PAPAYA_WHIP = 0xffffefd5;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFDAB9.
     */
    public static final int PEACH_PUFF = 0xffffdab9;
    /**
     * Gets a system-defined color that has an ARGB value of #FFCD853F.
     */
    public static final int PERU = 0xffcd853f;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFC0CB.
     */
    public static final int PINK = 0xffffc0cb;
    /**
     * Gets a system-defined color that has an ARGB value of #FFDDA0DD.
     */
    public static final int PLUM = 0xffdda0dd;
    /**
     * Gets a system-defined color that has an ARGB value of #FFB0E0E6.
     */
    public static final int POWDER_BLUE = 0xffb0e0e6;
    /**
     * Gets a system-defined color that has an ARGB value of #FF800080.
     */
    public static final int PURPLE = 0xff800080;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFF0000.
     */
    public static final int RED = 0xffff0000;
    /**
     * Gets a system-defined color that has an ARGB value of #FFBC8F8F.
     */
    public static final int ROSY_BROWN = 0xffbc8f8f;
    /**
     * Gets a system-defined color that has an ARGB value of #FF4169E1.
     */
    public static final int ROYAL_BLUE = 0xff4169e1;
    /**
     * Gets a system-defined color that has an ARGB value of #FF8B4513.
     */
    public static final int SADDLE_BROWN = 0xff8b4513;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFA8072.
     */
    public static final int SALMON = 0xfffa8072;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF4A460.
     */
    public static final int SANDY_BROWN = 0xfff4a460;
    /**
     * Gets a system-defined color that has an ARGB value of #FF2E8B57.
     */
    public static final int SEA_GREEN = 0xff2e8b57;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFF5EE.
     */
    public static final int SEA_SHELL = 0xfffff5ee;
    /**
     * Gets a system-defined color that has an ARGB value of #FFA0522D.
     */
    public static final int SIENNA = 0xffa0522d;
    /**
     * Gets a system-defined color that has an ARGB value of #FFC0C0C0.
     */
    public static final int SILVER = 0xffc0c0c0;
    /**
     * Gets a system-defined color that has an ARGB value of #FF87CEEB.
     */
    public static final int SKY_BLUE = 0xff87ceeb;
    /**
     * Gets a system-defined color that has an ARGB value of #FF6A5ACD.
     */
    public static final int SLATE_BLUE = 0xff6a5acd;
    /**
     * Gets a system-defined color that has an ARGB value of #FF708090.
     */
    public static final int SLATE_GRAY = 0xff708090;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFFAFA.
     */
    public static final int SNOW = 0xfffffafa;
    /**
     * Gets a system-defined color that has an ARGB value of #FF00FF7F.
     */
    public static final int SPRING_GREEN = 0xff00ff7f;
    /**
     * Gets a system-defined color that has an ARGB value of #FF4682B4.
     */
    public static final int STEEL_BLUE = 0xff4682b4;
    /**
     * Gets a system-defined color that has an ARGB value of #FFD2B48C.
     */
    public static final int TAN = 0xffd2b48c;
    /**
     * Gets a system-defined color that has an ARGB value of #FF008080.
     */
    public static final int TEAL = 0xff008080;
    /**
     * Gets a system-defined color that has an ARGB value of #FFD8BFD8.
     */
    public static final int THISTLE = 0xffd8bfd8;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFF6347.
     */
    public static final int TOMATO = 0xffff6347;
    /**
     * Gets a system-defined color.
     */
    public static final int TRANSPARENT = 0xffffff;
    /**
     * Gets a system-defined color that has an ARGB value of #FF40E0D0.
     */
    public static final int TURQUOISE = 0xff40e0d0;
    /**
     * Gets a system-defined color that has an ARGB value of #FFEE82EE.
     */
    public static final int VIOLET = 0xffee82ee;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF5DEB3.
     */
    public static final int WHEAT = 0xfff5deb3;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFFFFF.
     */
    public static final int WHITE = 0xffffffff;
    /**
     * Gets a system-defined color that has an ARGB value of #FFF5F5F5.
     */
    public static final int WHITE_SMOKE = 0xfff5f5f5;
    /**
     * Gets a system-defined color that has an ARGB value of #FFFFFF00.
     */
    public static final int YELLOW = 0xffffff00;
    /**
     * Gets a system-defined color that has an ARGB value of #FF9ACD32.
     */
    public static final int YELLOW_GREEN = 0xff9acd32;
    
    /**
     * Private constructor - util class.
     */
    private ColorUtils() {
        throw new AssertionError("Cannot make ColorUtil!");
    }

    /**
     * Convert red, green and blue shades between 0 and 255 to an rgb value.
     *
     * @param red The red shade.
     * @param green The green shade.
     * @param blue The blus shade.
     * @return The rgb value made from those red, green and blue shades.
     */
    public static int toRGB(int red, int green, int blue) {
        return ((255 << 24))
                | ((red & 0xFF) << 16)
                | ((green & 0xFF) << 8)
                | ((blue & 0xFF));
    }

    /**
     * Convert alpha, red, green and blue shades between 0 and 255 to an rgb
     * value.
     *
     * @param alpha The alpha value.
     * @param red The red shade.
     * @param green The green shade.
     * @param blue The blus shade.
     * @return The rgb value made from those alpha, red, green and blue shades.
     */
    public static int toARGB(int alpha, int red, int green, int blue) {
        return ((alpha & 0xFF) << 24)
                | ((red & 0xFF) << 16)
                | ((green & 0xFF) << 8)
                | ((blue & 0xFF));
    }

    /**
     * Get the alpga value from an argb value.
     *
     * @param argb Argb value.
     * @return The alpha part of the argb value.
     */
    public static int getAlpha(int argb) {
        return (argb >> 24) & 0xff;
    }

    /**
     * Get the red value from an rgb or argb value.
     *
     * @param rgb An rgb or argb value.
     * @return The red part of the rgb or argb value.
     */
    public static int getRed(int rgb) {
        return (rgb >> 16) & 0xff;
    }

    /**
     * Get the green value from an rgb or argb value.
     *
     * @param rgb An rgb or argb value.
     * @return The green part of the rgb or argb value.
     */
    public static int getGreen(int rgb) {
        return (rgb >> 8) & 0xff;
    }

    /**
     * Get the blue value from an rgb or argb value.
     *
     * @param rgb An rgb or argb value.
     * @return The blue part of the rgb or argb value.
     */
    public static int getBlue(int rgb) {
        return (rgb) & 0xff;
    }

    /**
     * Convert an int representation of rgb to a string.
     *
     * @param rgb Int representation of rgb.
     * @return String of the int value of rgb.
     */
    public static String rgbToString(int rgb) {
        int red = getRed(rgb);
        int green = getGreen(rgb);
        int blue = getBlue(rgb);

        return "Color = (" + red + ", " + green + ", " + blue + ")";
    }

    /**
     * Convert an int representation of argb to a string.
     *
     * @param argb Int representation of argb.
     * @return String of the int value of argb.
     */
    public static String argbToString(int argb) {
        int alpha = getAlpha(argb);
        int red = getRed(argb);
        int green = getGreen(argb);
        int blue = getBlue(argb);

        return "Color = (" + red + ", " + green + ", " + blue + ") alpha = " + alpha;
    }
}
