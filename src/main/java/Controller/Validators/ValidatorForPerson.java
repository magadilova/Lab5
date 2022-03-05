package Controller.Validators;

import Model.EyeColor;
import Model.HairColor;

public class ValidatorForPerson {
    private void validatePerson (String name, String passportID, EyeColor eyeColor, HairColor hairColor)  throws IllegalArgumentException {
    if (name == null) throw new IllegalArgumentException("Name can't be empty");
    if (passportID == null) throw new IllegalArgumentException("Passport ID can't be empty");
    if (eyeColor == null) throw new IllegalArgumentException("Eyes' color can't be empty");
    if (hairColor == null) throw new IllegalArgumentException("Hair' color can't be empty");
    }
}
