interface Input {

    public void add(char c);

    public String getValue();

}

class TextInput implements Input {

    String value = "";

    @Override
    public void add(char c) {
        value += c;
    }

    @Override
    public String getValue() {
        return value;
    }
}

class NumericInput extends TextInput {

    @Override
    public void add(char c) {
        if (c >= '0' && c <= '9')
            value += c;
    }

}

public class Problem03 {

    public static void main(String[] args) {

        TextInput input = new NumericInput();
        input.add('1');
        input.add('a');
        input.add('9');
        System.out.println(input.getValue());

    }
}
