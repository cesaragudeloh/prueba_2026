function fn() {
    var env = karate.env || 'dev';
    var config = {
        baseUrl: 'https://petstore.swagger.io/v2'
    };
    if (env === 'staging') {
        config.baseUrl = 'https://staging-api.example.com';
    }
    return config;
}