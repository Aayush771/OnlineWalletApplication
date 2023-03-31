package com.wallet.onlinewalletapplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.security.SecuritySchemes;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info = @Info(title = "Online Wallet Application", version = "1.1"),
        security = { @SecurityRequirement(name = "basicAuth")
}

)

@SecuritySchemes({
        @SecurityScheme(name = "basicAuth",
                type = SecuritySchemeType.HTTP, scheme = "basic")
}
)
@SpringBootApplication
public class OnlineWalletApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineWalletApplication.class, args);
    }

}
