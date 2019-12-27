
public class Main
{
    private static final int ALPHABET_SIZE = 33;

    public static void main(String[] args) {

        final String ENCRYPT_TEXT = "Еъёчхф Вхзёюлх, адздёиу ф ждэщхб, црбх еёдюэчъщъгюъв южаижжзчх, ждчъёнъгжзчдв. " +
                "Ъы зёюивй жёхчгюв бюнс ж ъы вдгивъгзхбсгрв аёхкдв. \n" +
                "Зъеъёс вгъ дмъчющгд, мзд гъюэцъьгджзс тздшд аёхкх фчбфъзжф жбъщжзчюъв гъждчъёнъгжзчх мъбдчъмъжадшд югщючющиивх. \n" +
                "Ф юэимюб чхни южздёюу ю чгыж юэвъгъгюф, здмгъъ дзёхэюч еджздфггиу юэвъгмючджзс мъбдчъмъжаюк едёдадч. \n" +
                "Ю зъв гъ въгъъ, еджбъщдчхбх гъищхмх. Ф еёюнъб а чрчдщи, мзд чюгдя чжъви вдя югзъббъаз, х чдэвдьгд, " +
                "вды мёъэвъёгдъ жзёъвбъгюъ ад чжъви шхёвдгюмгдви. \n" +
                "Гхязю ёънъгюъ вгъ едвдшбх еёдшёхввх югзиюзючгдшд зюех, жеълюхбсгд ждэщхггхф щбф юэимъгюф деёъщъбъггрк жздёдг мъбдчъмъжадя щиню. \n" +
                "Въгф вдьгд гхэчхзс дзлдв Вхзёюлр, х ъы, цъэ еёъичъбюмъгюф, вхзъёсу.";

        for (int letterShift = 0; letterShift < ALPHABET_SIZE; letterShift++) {
            System.out.println(getDecryptedVersion(ENCRYPT_TEXT, letterShift) + "\n");
        }
    }

    private static String getDecryptedVersion (String encryptedText, int letterShift) {
        StringBuilder decryptedVersion = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            decryptedVersion.append(getShiftChar(encryptedText.charAt(i), letterShift));
        }
        return decryptedVersion.toString();
    }

    private static char getShiftChar (char charOfEncryptText, int letterShift) {
        char[] alphabetUpperCase = Alphabet.ALPHABET_UPPERCASE.getAlphabet();
        char[] alphabetLowerCase = Alphabet.ALPHABET_LOWERCASE.getAlphabet();

        for (int indexAlphabet = 0; indexAlphabet < ALPHABET_SIZE; indexAlphabet++) {
            if (isNotLetter(charOfEncryptText)) {
                return charOfEncryptText;
            }

            if (charOfEncryptText == alphabetUpperCase[indexAlphabet]) {
                return alphabetUpperCase[getShiftIndexOfLetter(indexAlphabet, letterShift)];
            }

            if (charOfEncryptText == alphabetLowerCase[indexAlphabet]) {
                return alphabetLowerCase[getShiftIndexOfLetter(indexAlphabet, letterShift)];
            }
        }
        return charOfEncryptText;
    }

    private static boolean isNotLetter (char nextCharOfEncryptText) {
        return String.valueOf(nextCharOfEncryptText).matches("[^А-Яа-яЁё]");
    }

    private static int getShiftIndexOfLetter (int nextIndexOfChar, int letterShift) {
        final int MAX_INDEX_OF_ALPHABET = 32;
        return nextIndexOfChar + letterShift > MAX_INDEX_OF_ALPHABET ?
                nextIndexOfChar + letterShift - ALPHABET_SIZE : nextIndexOfChar + letterShift;
    }
}