package dictionary.api.infrastructure.enums;

public enum Language {
    EN("en"),
    EN_US("en-us"),
    AR("ar"),
    ZH("zh"),
    FR("fr"),
    DE("de"),
    RU("ru"),
    OOP("oop");

    public final String value;

    public String getValue(){
        return this.value;
    }

    Language(String value){
        this.value = value;
    }
}
