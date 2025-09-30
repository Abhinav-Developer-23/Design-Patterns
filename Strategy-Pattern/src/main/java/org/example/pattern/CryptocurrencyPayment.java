package org.example.pattern;

/**
 * Concrete Strategy - Cryptocurrency Payment
 */
public class CryptocurrencyPayment implements PaymentStrategy {
    private String walletAddress;
    private String cryptoType;

    public CryptocurrencyPayment(String walletAddress, String cryptoType) {
        this.walletAddress = walletAddress;
        this.cryptoType = cryptoType;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Processing Cryptocurrency Payment...");
        System.out.println("Crypto Type: " + cryptoType);
        System.out.println("Wallet Address: " + walletAddress);
        System.out.println("Amount paid: $" + amount + " (converted to " + cryptoType + ")");
        System.out.println("Cryptocurrency payment successful!");
    }
}
