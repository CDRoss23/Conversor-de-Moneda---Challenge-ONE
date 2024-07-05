# Currency Converter

Este es un simple conversor de monedas escrito en Java que utiliza la API de ExchangeRate-API para obtener tasas de cambio en tiempo real.

## Requisitos

- JDK 8 o superior
- Maven (si usas Maven para gestionar las dependencias)
- Clave de API de [ExchangeRate-API](https://www.exchangerate-api.com/)

## Dependencias

Este proyecto utiliza las siguientes dependencias:

- `okhttp` para realizar solicitudes HTTP
- `gson` para parsear las respuestas JSON

Si usas Maven, añade las siguientes dependencias a tu `pom.xml`:

```xml
<dependencies>
    <dependency>
        <groupId>com.squareup.okhttp3</groupId>
        <artifactId>okhttp</artifactId>
        <version>4.9.0</version>
    </dependency>
    <dependency>
        <groupId>com.google.code.gson</groupId>
        <artifactId>gson</artifactId>
        <version>2.8.6</version>
    </dependency>
</dependencies>
