package root.type;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum GenreType {

    electric_guitar(1), 
    acoustic_guitar(2), 
    bass(3), 
    effector(4);

    private final int value;

    public static GenreType getGenreByCode(final int value) {
        for (final GenreType genre : values()) {
            if (genre.getValue() == value) {
                return genre;
            }
        }
        return null;
    }

}
