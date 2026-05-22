package com.rustik.rustik;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RustikApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
		setEnvProperty(dotenv, "DB_USERNAME", "DB_USERNAME");
        setEnvProperty(dotenv, "DB_PASSWORD", "DB_PASSWORD");
        setEnvProperty(dotenv, "DB_URL", "DB_URL");
        setEnvProperty(dotenv, "CLOUDINARY_URL", "CLOUDINARY_URL");
        setEnvProperty(dotenv, "CORS", "CORS");
        setEnvProperty(dotenv, "SECRET", "SECRET");
        setEnvProperty(dotenv, "ISSUER", "ISSUER");
        setEnvProperty(dotenv, "SPRING_MAIL_USERNAME", "MAIL_USERNAME");
        setEnvProperty(dotenv, "SPRING_MAIL_PASSWORD", "MAIL_PASSWORD");
        setEnvProperty(dotenv, "RUSTIK_URL", "RUSTIK_URL");

		SpringApplication.run(RustikApplication.class, args);

	}

	private static void setEnvProperty(Dotenv dotenv, String propertyName, String envKey) {
        String value = dotenv.get(envKey);
        if (value != null) {
            System.setProperty(propertyName, value);
        }
    }
}
