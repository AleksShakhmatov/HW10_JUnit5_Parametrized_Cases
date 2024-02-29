package pages.components;

@SuppressWarnings("NonAsciiCharacters")
public enum Language {
    Russian("Одна цена"),
    English("Sign in to VK");

    public final String description;

    Language(String description) {
        this.description = description;
    }
}
