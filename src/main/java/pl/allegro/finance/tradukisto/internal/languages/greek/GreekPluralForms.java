package pl.allegro.finance.tradukisto.internal.languages.greek;

import pl.allegro.finance.tradukisto.internal.languages.GenderType;
import pl.allegro.finance.tradukisto.internal.languages.PluralForms;
import pl.allegro.finance.tradukisto.internal.support.Range;

public class GreekPluralForms implements PluralForms {

    private final String singularForm;
    private final String pluralForm;
    private final String genitivePluralForm;

    private final GenderType genderType;

    public GreekPluralForms(String singularForm, String pluralForm, String genitivePluralForm, GenderType genderType) {
        this.singularForm = singularForm;
        this.pluralForm = pluralForm;
        this.genitivePluralForm = genitivePluralForm;

        this.genderType = genderType;
    }

    public GreekPluralForms() {
        this("", "", "", GenderType.NON_APPLICABLE);
    }

    @Override
    public String formFor(Integer value) {
        if (value == 1) {
            return singularForm;
        }
        if (Range.closed(2, 4).contains(value)) {
            return pluralForm;
        }

        return genitivePluralForm;
    }

    @Override
    public GenderType genderType() {
        return this.genderType;
    }
}
