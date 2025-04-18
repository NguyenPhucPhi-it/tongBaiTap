package ASEandRES;

public interface Encryptable {
    String encrypt(String data) throws Exception;
    String decrypt(String data) throws Exception;
}
