package edu.estu.estufastingrestapi.core.repository.initialdataloaders.concretes;

import edu.estu.estufastingrestapi.core.model.entities.concretes.Language;
import edu.estu.estufastingrestapi.core.repository.initialdataloaders.abstracts.BaseDataSeeder;
import org.springframework.stereotype.Component;

@Component
public class LanguageDataSeeder extends BaseDataSeeder<Language, Integer> {

    @Override
    public int getOrder() {
        return 10;
    }

    @SuppressWarnings("SpellCheckingInspection")
    @Override
    public void setData() {
        data.add(new Language(null, "Afrikaans", "Afrikaans", "AF", "AFR", true, false));
        data.add(new Language(null, "Akan", "Akan", "AK", "AKA", true, false));
        data.add(new Language(null, "Albanian", "shqip", "SQ", "SQI", false, false));
        data.add(new Language(null, "Arabic", "العربية", "AR", "ARA", false, false));
        data.add(new Language(null, "Aragonese", "Aragonés", "AN", "ARG", false, false));
        data.add(new Language(null, "Armenian", "Հայերէն", "HY", "HYE", false, false));
        data.add(new Language(null, "Aymara", "Aymar aru", "AY", "AYM", true, false));
        data.add(new Language(null, "Azerbaijani", "Azərbaycan", "AZ", "AZE", false, false));
        data.add(new Language(null, "Bambara", "Bamanankan", "BM", "BAM", false, false));
        data.add(new Language(null, "Bashkir", "Башҡортса", "BA", "BAK", false, false));
        data.add(new Language(null, "Basque", "Euskara", "EU", "EUS", false, false));
        data.add(new Language(null, "Belarusian", "Беларуская", "BE", "BEL", false, false));
        data.add(new Language(null, "Bengali", "বাংলা", "BN", "BEN", false, false));
        data.add(new Language(null, "Bosnian", "bosanski", "BS", "BOS", false, false));
        data.add(new Language(null, "Bulgarian", "Български", "BG", "BUL", false, false));
        data.add(new Language(null, "Catalan", "català", "CA", "CAT", false, false));
        data.add(new Language(null, "Chinese", "中國人", "ZH", "ZHO", false, false));
        data.add(new Language(null, "Czech", "čeština", "CS", "CES", false, false));
        data.add(new Language(null, "Danish", "dansk", "DA", "DAN", false, false));
        data.add(new Language(null, "Dutch", "Nederlands", "NL", "NLD", false, false));
        data.add(new Language(null, "English", "English", "EN", "ENG", false, true));
        data.add(new Language(null, "Estonian", "eesti keel", "ET", "EST", false, false));
        data.add(new Language(null, "Ewe", "Èʋegbe", "EE", "EWE", true, false));
        data.add(new Language(null, "Finnish", "suomi", "FI", "FIN", false, false));
        data.add(new Language(null, "French", "français", "FR", "FRA", false, false));
        data.add(new Language(null, "Galician", "galego", "GL", "GLG", false, false));
        data.add(new Language(null, "Georgian", "ქართული ენა", "KA", "KAT", false, false));
        data.add(new Language(null, "German", "Deutsch", "DE", "DEU", false, false));
        data.add(new Language(null, "Greek", "ελληνικά", "EL", "ELL", false, false));
        data.add(new Language(null, "Haitian", "Kreyòl ayisyen", "HT", "HAT", false, false));
        data.add(new Language(null, "Hindi", "हिन्दी", "HI", "HIN", false, false));
        data.add(new Language(null, "Hungarian", "magyar", "HU", "HUN", false, false));
        data.add(new Language(null, "Icelandic", "íslenska", "IS", "ISL", false, false));
        data.add(new Language(null, "Indonesian", "Bahasa Indonesia", "ID", "IND", false, false));
        data.add(new Language(null, "Irish", "Gaeilge", "GA", "GLE", false, false));
        data.add(new Language(null, "Italian", "italiano", "IT", "ITA", false, false));
        data.add(new Language(null, "Japanese", "日本語", "JA", "JPN", false, false));
        data.add(new Language(null, "Javanese", "Basa Jawa", "JV", "JAV", false, false));
        data.add(new Language(null, "Kashmiri", "कॉशुर", "KS", "KAS", false, false));
        data.add(new Language(null, "Kazakh", "Қазақ тілі", "KK", "KAZ", false, false));
        data.add(new Language(null, "Korean", "한국어", "KO", "KOR", false, false));
        data.add(new Language(null, "Kurdish", "کوردی", "KU", "KUR", false, false));
        data.add(new Language(null, "Luxembourgish", "Lëtzebuergesch", "LB", "LTZ", false, false));
        data.add(new Language(null, "Macedonian", "македонски", "MK", "MKD", false, false));
        data.add(new Language(null, "Malay", "Bahasa Melayu", "MS", "MSA", false, false));
        data.add(new Language(null, "Mongolian", "монгол", "MN", "MON", false, false));
        data.add(new Language(null, "Nepali", "नेपाली", "NE", "NEP", false, false));
        data.add(new Language(null, "Norwegian", "norsk", "NO", "NOR", false, false));
        data.add(new Language(null, "Persian", "فارسی", "FA", "FAS", false, false));
        data.add(new Language(null, "Polish", "polski", "PL", "POL", false, false));
        data.add(new Language(null, "Portuguese", "Português", "PT", "POR", false, false));
        data.add(new Language(null, "Romanian", "limba română", "RO", "RON", false, false));
        data.add(new Language(null, "Russian", "Русский", "RU", "RUS", false, false));
        data.add(new Language(null, "Serbian", "српски", "SR", "SRP", false, false));
        data.add(new Language(null, "Slovak", "slovenčina", "SK", "SLK", false, false));
        data.add(new Language(null, "Spanish", "español", "ES", "SPA", false, false));
        data.add(new Language(null, "Swedish", "svenska", "SV", "SWE", false, false));
        data.add(new Language(null, "Tatar", "tatarça", "TT", "TAT", false, false));
        data.add(new Language(null, "Turkish", "Türkçe", "TR", "TUR", false, false));
        data.add(new Language(null, "Turkmen", "Türkmen dili", "TK", "TUK", false, false));
        data.add(new Language(null, "Ukrainian", "українська мова", "UK", "UKR", false, false));
        data.add(new Language(null, "Urdu", "اُردُو", "UR", "URD", false, false));
        data.add(new Language(null, "Uzbek", "Ўзбек тили", "UZ", "UZB", false, false));
        data.add(new Language(null, "Vietnamese", "Tiếng Việt", "VI", "VIE", false, false));
    }

}