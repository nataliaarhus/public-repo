import java.util.Arrays;
class Letters {
    private StringBuilder letters = new StringBuilder();

    public Letters () {
    }
    public void addLetter(char letter) {
        String l = String.valueOf(letter);
        if (this.letters.indexOf(l) == -1) {
            this.letters.append(l); //potentialy you can append char type
        }
    }
    public void addLetters(String letters) {
        for (int i=0; i<letters.length(); i++) {
            addLetter(letters.charAt(i));
        }
    }
    public String allLetters() {
        char[] sortedLetters = this.letters.toString().toCharArray();
        Arrays.sort(sortedLetters);
        return new String(sortedLetters);
    }
}