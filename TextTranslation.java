import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public String translateText(String text, String targetLanguage) {
    Translate translate = TranslateOptions.getDefaultInstance().getService();
    Translation translation = translate.translate(
        text, Translate.TranslateOption.targetLanguage(targetLanguage));
    return translation.getTranslatedText();
}