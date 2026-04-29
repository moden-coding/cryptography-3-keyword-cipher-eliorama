import java.util.ArrayList;

public class KeywordCipher {

    public static String encodeWord(String word, ArrayList<String> codebook) {
        for (int i = 0; i < codebook.size(); i++) {
            String entry = codebook.get(i);
            String[] parts = entry.split(",");
            if (word.equals(parts[0])) {
                word = parts[1];
            }
        }
        return word;
    }

        public static String decodeWord(String word, ArrayList<String> codebook) {
        for (int i = 0; i < codebook.size(); i++) {
            String entry = codebook.get(i);
            String[] parts = entry.split(",");
            if (word.equals(parts[1])) {
                word = parts[0];
            }
            
        }
        return word;
    }

    public static String encodeSentence(String sentence, ArrayList<String> codebook) {
        String[] parts = sentence.split(" ");
        String words = "";
        for (int i = 0; i < parts.length; i++) {
        String encoded = encodeWord(parts[i], codebook);
         if(i>0){
        words = words+" "+encoded;
         }
          else{
        words = encoded;
         }
        }

        return words;
    }

    public static String decodeSentence(String sentence, ArrayList<String> codebook) {
        String[] parts = sentence.split(" ");
        String words = "";
        for (int i = 0; i < parts.length; i++) {
        String encoded = decodeWord(parts[i], codebook);
         if(i>0){
        words = words+" "+encoded;
         }
         else{
        words = encoded;
         }
        }
        return words;
    }

    public static void main(String[] args) {

        // Build a sample codebook
        ArrayList<String> codebook = new ArrayList<String>();
        codebook.add("dog,bravo");
        codebook.add("cat,alpha");
        codebook.add("meet,foxtrot");
        codebook.add("tonight,sierra");
        codebook.add("at,tango");
        codebook.add("the,november");
        codebook.add("park,lima");
        codebook.add("run,delta");

        // Test encodeWord
        System.out.println("=== encodeWord ===");
        System.out.println(encodeWord("dog", codebook)); // expected: bravo
        System.out.println(encodeWord("cat", codebook)); // expected: alpha
        System.out.println(encodeWord("hello", codebook)); // expected: hello

        // Test encodeSentence
        System.out.println("\n=== encodeSentence ===");
        System.out.println(encodeSentence("meet the dog at the park", codebook));
        // expected: foxtrot november bravo tango november lima

        // Test decodeSentence
        System.out.println("\n=== decodeSentence ===");
        System.out.println(decodeSentence("foxtrot november bravo tango november lima", codebook));
        // expected: meet the dog at the park
    }
}
