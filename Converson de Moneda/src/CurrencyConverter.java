import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_KEY = "3abc1d1998e6742ceba12dcd";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la moneda de origen (ej. USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la moneda de destino (ej. EUR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la cantidad a convertir: ");
        double amount = scanner.nextDouble();

        try {
            double convertedAmount = convertCurrency(fromCurrency, toCurrency, amount);
            System.out.println(amount + " " + fromCurrency + " = " + convertedAmount + " " + toCurrency);
        } catch (IOException e) {
            System.err.println("Error al realizar la conversión: " + e.getMessage());
        }
    }

    public static double convertCurrency(String fromCurrency, String toCurrency, double amount) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(API_URL + fromCurrency)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new IOException("Error en la llamada a la API: " + response);
            }

            String responseBody = response.body().string();
            JsonObject jsonObject = JsonParser.parseString(responseBody).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            double rate = conversionRates.get(toCurrency).getAsDouble();
            return amount * rate;
        }
    }
}
