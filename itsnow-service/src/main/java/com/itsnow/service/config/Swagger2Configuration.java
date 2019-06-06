//package com.itsnow.service.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpHeaders;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.OAuthBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.*;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.*;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
///**
// * Created by Xuekun_Li on 2019/1/29.
// */
//@Configuration
//@EnableSwagger2
//public class Swagger2Configuration {
//
//    // @Value("${config.oauth2.accessTokenUri}")
//    private String accessTokenUri ="http://localhost:18000/auth/oauth/token";
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("API 接口服务")
//                .description("API 接口服务")
//                .termsOfServiceUrl("http://www.itsnow.com")
//                .version("v1")
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0")
//                .contact(new Contact("Itsnow","http://www.itsnow.com","admin@itsnow.com"))
//                .build();
//    }
//
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.itsnow.service.controller"))
//                //.apis(RequestHandlerSelectors.withClassAnnotation(Api.class))
//                .paths(PathSelectors.any())
//                .build()
//                .securityContexts(Collections.singletonList(securityContext()))
//                .securitySchemes(Collections.singletonList(securityScheme()));
//               // .securitySchemes(Arrays.asList(securitySchema(), apiKey(), apiCookieKey()));
////                .globalOperationParameters(
////                        newArrayList(new ParameterBuilder()
////                                .name("access_token")
////                                .description("AccessToken")
////                                .modelRef(new ModelRef("string"))
////                                .parameterType("query")
////                                .required(true)
////                                .build()));
//    }
//
//    @Bean
//    public SecurityScheme apiKey() {
//        return new ApiKey(HttpHeaders.AUTHORIZATION, "apiKey", "header");
//    }
//
//    @Bean
//    public SecurityScheme apiCookieKey() {
//        return new ApiKey(HttpHeaders.COOKIE, "apiKey", "cookie");
//    }
//
//
////    private SecurityContext securityContext() {
////        return SecurityContext.builder().securityReferences(defaultAuth())
////                .build();
////    }
//
//    /**
//     * 这里设置 swagger2 认证的安全上下文
//     */
//    private SecurityContext securityContext() {
//        return SecurityContext.builder()
//                .securityReferences(Collections.singletonList(new SecurityReference("spring_oauth", scopes())))
//                .forPaths(PathSelectors.any())
//                .build();
//    }
//
//    private List<SecurityReference> defaultAuth() {
//
//        final AuthorizationScope[] authorizationScopes = new AuthorizationScope[3];
//        authorizationScopes[0] = new AuthorizationScope("read", "read all");
//        authorizationScopes[1] = new AuthorizationScope("trust", "trust all");
//        authorizationScopes[2] = new AuthorizationScope("write", "write all");
//
//        return Collections.singletonList(new SecurityReference("oauth2", authorizationScopes));
//    }
//
////    @Bean
////    public SecurityConfiguration security() {
////        return new SecurityConfiguration
////                ("client", "secret", "", "", "Bearer access token", ApiKeyVehicle.HEADER, HttpHeaders.AUTHORIZATION,"");
////    }
//
////    @Bean
////    SecurityConfiguration security() {
////        return SecurityConfigurationBuilder.builder()
////                .clientId("test")
////                .clientSecret("test")
////                .realm("test-app-realm")
////                .appName("test-app")
////                .scopeSeparator(",")
////                .additionalQueryStringParams(null)
////                .useBasicAuthenticationWithAccessCodeGrant(false)
////                .build();
////    }
//
//    /**
//     * 这个类决定了你使用哪种认证方式，我这里使用密码模式
//     * 其他方式自己摸索一下，完全莫问题啊
//     */
//    private SecurityScheme securityScheme() {
//        GrantType grantType = new ResourceOwnerPasswordCredentialsGrant(accessTokenUri);
//
//        return new OAuthBuilder()
//                .name("spring_oauth")
//                .grantTypes(Collections.singletonList(grantType))
//                .scopes(Arrays.asList(scopes()))
//                .build();
//    }
//
//    private OAuth securitySchema() {
//
//        List<AuthorizationScope> authorizationScopeList = new ArrayList();
//        authorizationScopeList.add(new AuthorizationScope("read", "read all"));
//        authorizationScopeList.add(new AuthorizationScope("write", "access all"));
//        List<GrantType> grantTypes = new ArrayList();
//        GrantType passwordCredentialsGrant = new ResourceOwnerPasswordCredentialsGrant(accessTokenUri);
//        grantTypes.add(passwordCredentialsGrant);
//
//        return new OAuth("oauth2", authorizationScopeList, grantTypes);
//    }
//
//
//
//    /**
//     * 这里是写允许认证的scope
//     */
//    private AuthorizationScope[] scopes() {
//        return new AuthorizationScope[]{
//                new AuthorizationScope("user", "All scope is trusted!")
//        };
//    }
//
//    @Bean
//    UiConfiguration uiConfig() {
//        return UiConfigurationBuilder.builder()
//                .deepLinking(true)
//                .displayOperationId(false)
//                .defaultModelsExpandDepth(1)
//                .defaultModelExpandDepth(1)
//                .defaultModelRendering(ModelRendering.EXAMPLE)
//                .displayRequestDuration(false)
//                .docExpansion(DocExpansion.NONE)
//                .filter(false)
//                .maxDisplayedTags(null)
//                .operationsSorter(OperationsSorter.ALPHA)
//                .showExtensions(false)
//                .tagsSorter(TagsSorter.ALPHA)
//                .validatorUrl(null)
//                .build();
//    }
//}
