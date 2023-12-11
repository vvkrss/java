import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
public class WordSpliterator implements Spliterator<String> {
    private String[] words;
    private int index = 0;
    WordSpliterator(String text) {
        this.words = text.split(" ");
    }
    @Override
    public boolean tryAdvance(Consumer<? super String> action) {
        if (index < words.length) {
            action.accept(words[index]);
            index++;
            return true;
        } else {
            return false;
        }
    }
    @Override
    public Spliterator<String> trySplit() {
        int remaining = words.length - index;
        if (remaining < 10) {
            return null;
        }
        for (int splitPos = remaining / 2 + index; splitPos < words.length; splitPos++) {
            if (Character.isWhitespace(words[splitPos].charAt(words[splitPos].length() - 1))) {
                Spliterator<String> spliterator = Spliterators.spliterator(words, index, splitPos, 0);
                index = splitPos;
                return spliterator;
            }
        }
        return null;
    }
    @Override
    public long estimateSize() {
        return words.length - index;
    }

    @Override
    public int characteristics() {
        return ORDERED | SIZED | SUBSIZED | NONNULL | IMMUTABLE;
    }

    public static void main(String[] args) {
        String text = "This is a sample sentence demonstrating custom Spliterator implementation";
        Stream<String> wordStream = StreamSupport.stream(new WordSpliterator(text), false);
        wordStream.forEach(System.out::println);
    }
}