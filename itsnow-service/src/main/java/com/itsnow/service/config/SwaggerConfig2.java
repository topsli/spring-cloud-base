package com.itsnow.service.config;

/**
 * Created by Xuekun_Li on 2019/2/11.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.OAuthBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//把import写进来主要是为了确保万无一失

@Configuration
@EnableSwagger2
public class SwaggerConfig2 {

    /**
     * 主要是这个方法，其他的方法是抽出去的，所以大家不要害怕为啥有这么多方法
     * 在 basePackage 里面写需要生成文档的 controller 路径
     */
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.itsnow.service.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(Collections.singletonList(securityScheme()))
                .securityContexts(Collections.singletonList(securityContext()));
    }

    /**
     * 这个方法主要是写一些文档的描述
     */

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("API 接口服务")
                .description("API 接口服务")
                .termsOfServiceUrl("http://www.itsnow.com")
                .version("v1")
                .license("Apache License Version 2.0")
                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
                .contact(new Contact("Itsnow", "http://www.itsnow.com", "admin@itsnow.com"))
                .build();
    }

    /**
     * 这个类决定了你使用哪种认证方式，我这里使用密码模式
     * 其他方式自己摸索一下，完全莫问题啊
     */
    private SecurityScheme securityScheme() {
        String authServer = "http://localhost:18001/auth";
        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(authServer + "/oauth/token");

        return new OAuthBuilder()
                .name("spring_oauth")
                //.grantTypes(Collections.singletonList(grantType))
                .grantTypes(grantTypes())
                .scopes(Arrays.asList(scopes()))
                .build();
    }

    @Bean
    List<GrantType> grantTypes() {
        //List<GrantType> grantTypes = new ArrayList<>();
        TokenRequestEndpoint tokenRequestEndpoint = new TokenRequestEndpoint(
                "http://localhost:18001/auth/oauth/authorize",
                "clientId", "clientSecret");
//        TokenEndpoint tokenEndpoint = new TokenEndpoint("http://localhost:18001/auth/oauth/token", "access_token");
//        grantTypes.add(new AuthorizationCodeGrant(tokenRequestEndpoint, tokenEndpoint));
//        return grantTypes;


        String tokenUrl = "http://localhost:18001/auth/oauth/token", authorizeUrl = "http://localhost:18001/auth/oauth/authorize", loginUrl = "http://localhost:18001/auth/login";
        List<GrantType> grantTypes = new ArrayList<>();
        ClientCredentialsGrant clientCredentialsGrant = new ClientCredentialsGrant(tokenUrl);
        ResourceOwnerPasswordCredentialsGrant resourceOwnerPasswordCredentialsGrant =
                new ResourceOwnerPasswordCredentialsGrant(tokenUrl);
        AuthorizationCodeGrant authorizationCodeGrant = new AuthorizationCodeGrant(new TokenRequestEndpoint(authorizeUrl
                , "clientId", "clientSecret"), new TokenEndpoint(tokenUrl, "access_token"));
        ImplicitGrant implicitGrant = new ImplicitGrant(new LoginEndpoint(tokenUrl), "access_token");
        grantTypes.add(resourceOwnerPasswordCredentialsGrant);
        grantTypes.add(implicitGrant);
        grantTypes.add(authorizationCodeGrant);
        grantTypes.add(clientCredentialsGrant);
        return grantTypes;
    }

    /**
     * 这里设置 swagger2 认证的安全上下文
     */
    private SecurityContext securityContext() {
        return SecurityContext.builder()
                .securityReferences(Collections.singletonList(new SecurityReference("spring_oauth", scopes())))
                .forPaths(PathSelectors.any())
                .build();
    }

    /**
     * 这里是写允许认证的scope
     */
    private AuthorizationScope[] scopes() {
        return new AuthorizationScope[]{
                new AuthorizationScope("user", "All scope is trusted!")
        };
    }
}
