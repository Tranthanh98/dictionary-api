# dictionary-api
mvn clean install   
mvn spring-boot:run   

file response:   

```json{
{
    "pronunciations": [
        {
            "audioFile": "https://audio.oxforddictionaries.com/en/mp3/tool_gb_1.mp3",
            "dialects": [
                "British English"
            ]
        },
        {
            "audioFile": "https://audio.oxforddictionaries.com/en/mp3/tool_us_1.mp3",
            "dialects": [
                "American English"
            ]
        }
    ],
    "translateResult": [
        {
            "translations": [
                {
                    "language": "de",
                    "text": "Werkzeug"
                },
                {
                    "language": "de",
                    "text": "Gerät"
                },
                {
                    "language": "de",
                    "text": "Werkzeugmaschine"
                },
                {
                    "language": "de",
                    "text": "Meißel"
                },
                {
                    "language": "de",
                    "text": "Tool"
                },
                {
                    "language": "de",
                    "text": "Werkzeug"
                },
                {
                    "language": "de",
                    "text": "[Hilfs]mittel"
                },
                {
                    "language": "de",
                    "text": "Werkzeug"
                },
                {
                    "language": "de",
                    "text": "Apparat"
                },
                {
                    "language": "de",
                    "text": "Gerät"
                }
            ],
            "lang": "en",
            "id": "tool_en_de",
            "lexicalCategory": "Noun"
        },
        {
            "translations": [
                {
                    "language": "de",
                    "text": "bearbeiten"
                },
                {
                    "language": "de",
                    "text": "prägen"
                }
            ],
            "lang": "en",
            "id": "tool_en_de",
            "lexicalCategory": "Verb"
        }
    ]
  }
}
