package Entity.types;

public enum WildCardTypes {

    WILD_FOUR("+4"), WILD("wild");

    private final String value;

    WildCardTypes(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
