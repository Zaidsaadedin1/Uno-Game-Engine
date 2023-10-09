package Entity.types;

public enum ActionCardTypes {

    PLUS_TWO("+2"), REVERSE("reverse"), SKIP("skip");

    private final String value;

    ActionCardTypes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
