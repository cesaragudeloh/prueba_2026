function fn() {
    var env = karate.env || 'dev';
    var config = {
        baseUrl: 'https://jsonplaceholder.typicode.com'
    };
    if (env === 'staging') {
        config.baseUrl = 'https://staging-api.example.com';
    }
    return config;
}