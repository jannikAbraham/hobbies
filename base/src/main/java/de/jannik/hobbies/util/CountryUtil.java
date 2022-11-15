package de.jannik.hobbies.util;

import java.util.Locale;
import java.util.Set;

public class CountryUtil
{
  private static final Set<String> ISO_COUNTRIES = Set.of(Locale.getISOCountries());
  public static boolean validate(String isoCode)
  {
    return ISO_COUNTRIES.contains(isoCode);
  }
}
