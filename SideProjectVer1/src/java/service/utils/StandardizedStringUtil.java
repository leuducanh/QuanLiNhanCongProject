package service.utils;

public class StandardizedStringUtil {

    public static String standardizedName(String name){
        String[] words = name.trim().toLowerCase().split(" ");

        StringBuilder builder = new StringBuilder();
        for(String word : words){
            builder.append(standardizedOneWord(word))
                    .append(" ");
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    public static String standardizedId(String id){
        String[] words = id.trim().toLowerCase().split(" ");

        StringBuilder builder = new StringBuilder();
        for(String word : words){
            builder.append(word);
        }

        return builder.toString();
    }

    public static String standardizedOneWord(String word){
        StringBuilder builder = new StringBuilder();
        word = word.trim();
        return builder.append((word.charAt(0) + "").toUpperCase())
                        .append(word.substring(1)).toString();
    }
}